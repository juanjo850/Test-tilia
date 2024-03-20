import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { TableModule } from 'primeng/table';
import { RouterOutlet } from '@angular/router';
import { Cloth, ClothingResponse } from './cloth';
import { AppService } from './app.service';
import { log } from 'console';


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,TableModule],
  providers: [AppService, HttpClient],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})

export class AppComponent {
  title = 'laundry';
  clothing: Cloth[] = [];

  constructor(private appService: AppService){}

  loadClothing(){
    this.appService.getClothing().subscribe(
      (response: ClothingResponse) => {
        this.clothing = response.clothing;
        console.log("clothing:", {response});
      }
    )
  }
}
