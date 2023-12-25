import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Response } from '../models/app.models';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  constructor(private http:HttpClient) { }

  private apiUrl = 'http://localhost:8081/books'


getAllBooks():Observable<Response>{
  return this.http.get<Response>(`${this.apiUrl}`);
}


}
