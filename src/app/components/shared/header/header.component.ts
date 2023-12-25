import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent implements OnInit {

constructor(private auth:AuthService,private router:Router){}
isAuth:boolean=false

  ngOnInit(): void {
    this.auth.isAuthenticated$.subscribe(
      authStatus => this.isAuth = authStatus
    );
  }

  

  logOut(): void {
    this.auth.logout();
    this.router.navigate(['/']);
  }
  



}
