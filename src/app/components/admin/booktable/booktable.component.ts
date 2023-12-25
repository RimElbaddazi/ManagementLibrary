import { Component, OnInit } from '@angular/core';
import { Books,Response } from '../../../models/app.models';
import { BookService } from '../../../services/book.service';

@Component({
  selector: 'app-booktable',
  templateUrl: './booktable.component.html',
  styleUrl: './booktable.component.css'
})
export class BooktableComponent implements OnInit {

  books:Books[]=[];

  constructor(private bookService:BookService) {
  }
  ngOnInit(): void {
    this.getAllBooks();
  }


  getAllBooks(){
    this.bookService.getAllBooks().subscribe({
      next: (response: Response) => {
        this.books = response._embedded.books;
      },
      error: err => console.error(err)
    });
  }
  

}
