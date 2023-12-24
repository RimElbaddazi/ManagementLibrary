import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit {

  loginForm?: any;
  loginError!: string;


  constructor(private fb: FormBuilder,private authService:AuthService,private router:Router){}

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required]
    });
  }

  onSubmit(): void {
    if (this.loginForm.valid) {
      const email = this.loginForm.get('email')?.value;
      const password = this.loginForm.get('password')?.value;
  
      this.authService.login(email, password).subscribe({
        next: (response) => {
          if (response) {
            console.log(response);
            localStorage.setItem('user', JSON.stringify(response));
            if (response.role === 'ADMIN') {
              this.router.navigate(['/admin']);
            } else {
              this.router.navigate(['/customer']);
            }
          } else {
            this.loginError = 'Login or password is incorrect';
          }
        },
        error: (error) => {
          console.error("Login failed", error);
          this.loginError = 'Login or password is incorrect';
        }
      });
    } else {
      Object.keys(this.loginForm.controls).forEach(field => {
        const control = this.loginForm.get(field);
        control?.markAsTouched();
      });
    }
  }
  
 

}
