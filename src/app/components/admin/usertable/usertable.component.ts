import { Component, OnInit } from '@angular/core';
import { UserService } from '../../../services/user.service';
import { Response, User } from '../../../models/app.models';

@Component({
  selector: 'app-usertable',
  templateUrl: './usertable.component.html',
  styleUrl: './usertable.component.css'
})
export class UsertableComponent implements OnInit {

  users:User[]=[];

  constructor(private userService:UserService) {
  }
  ngOnInit(): void {
    this.getAllUsers();
  }


  getAllUsers(){
    this.userService.getAllUsers().subscribe({
      next: (response: Response) => {
        this.users = response._embedded.adherents;
      },
      error: err => console.error(err)
    });
  }
  

}
