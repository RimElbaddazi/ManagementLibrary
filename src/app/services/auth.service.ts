import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../models/app.models';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http:HttpClient) { }
   private apiUrl = 'http://localhost:8082/api/login'

  login(email:string, password:string):Observable<any>{
    const requestData: User = {
      email: email,
      motDePasse: password,
    };
      return this.http.post<any>(`${this.apiUrl}`,requestData);
  }


}
