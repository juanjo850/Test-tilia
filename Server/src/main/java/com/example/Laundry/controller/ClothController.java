package com.example.Laundry.controller;

import com.example.Laundry.model.Cloth;
import com.example.Laundry.repo.ClothRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ClothController {

    @Autowired
    private ClothRepo clothRepo;

    @GetMapping("/getAllCloths")
    public ResponseEntity<List<Cloth>> getAllCloths(){
        try {
            List<Cloth> clothingList = new ArrayList<>();
            clothRepo.findAll().forEach(clothingList::add);

            if (clothingList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(clothingList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/getClothById/{id}")
    public ResponseEntity<Cloth> getClothById(@PathVariable Long id){
        Optional<Cloth> clothData = clothRepo.findById(id);

        if (clothData.isPresent()) {
            return new ResponseEntity<>(clothData.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/addCloth")
    public ResponseEntity<Cloth> addCloth(@RequestBody Cloth cloth){
        Cloth clothObj = clothRepo.save(cloth);

        return new ResponseEntity<>(clothObj, HttpStatus.OK);
    }

    @PostMapping("/updateClothById/{id}")
    public ResponseEntity<Cloth> updateClothById(@PathVariable Long id, @RequestBody Cloth clothStatusUpdate){
        Optional<Cloth> oldClothData = clothRepo.findById(id);

        if (oldClothData.isPresent()) {
            Cloth updateClothStatus = oldClothData.get();
            updateClothStatus.setStatus(clothStatusUpdate.getStatus());
            Cloth clothObj = clothRepo.save(updateClothStatus);
            return new ResponseEntity<>(clothObj, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteClothById/{id}")
    public ResponseEntity<HttpStatus> deleteClothById(@PathVariable Long id){
        clothRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
