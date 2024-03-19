package com.example.Laundry.repo;

import com.example.Laundry.model.Cloth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClothRepo extends JpaRepository<Cloth, Long> {
}
