import { Component, OnInit } from '@angular/core';
import { Books, Response, User } from '../../../models/app.models';
import { UserService } from '../../../services/user.service';
import { BookService } from '../../../services/book.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent implements OnInit {

  users: User[] = [];
  books:Books[]=[];

  constructor(private userService:UserService,private bookService:BookService) {
  }
  ngOnInit(): void {
    this.userService.getAllUsers().subscribe({
      next: (response: Response) => {
        this.users = response._embedded.adherents;
      },
      error: err => console.error(err)
    });

    this.bookService.getAllBooks().subscribe({
      next: (response: Response) => {
        this.books = response._embedded.books;
      },
      error: err => console.error(err)
    });

  }



  
}
