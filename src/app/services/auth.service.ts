import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { Login } from '../models/app.models';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private isAuthenticatedSubject = new BehaviorSubject<boolean>(this.checkInitialAuth());


  private checkInitialAuth(): boolean {
    const user = localStorage.getItem('user');
    return !!user;
  }

  constructor(private http:HttpClient) { }
   private apiUrl = 'http://localhost:8082/api/login'

  login(email:string, password:string):Observable<any>{
    const requestData: Login = {
      email: email,
      motDePasse: password,
    };
      return this.http.post<any>(`${this.apiUrl}`,requestData);
  }

  updateAuthStatus(isAuthenticated: boolean, userData: any): void {
    localStorage.setItem('user', JSON.stringify(userData));
    this.isAuthenticatedSubject.next(isAuthenticated);
  }

  logout() {
    localStorage.removeItem('user');
    this.isAuthenticatedSubject.next(false);
  }

  get isAuthenticated$() {
    return this.isAuthenticatedSubject.asObservable();
  }




}
