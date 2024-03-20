import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ClothingResponse } from './cloth';

@Injectable({
  providedIn: 'root'
})
export class AppService {

  constructor(private http:HttpClient) { }

  getClothing(): Observable<ClothingResponse> {
    return this.http.get<ClothingResponse>('http://localhost:9090/getAllCloths')
  }
}
