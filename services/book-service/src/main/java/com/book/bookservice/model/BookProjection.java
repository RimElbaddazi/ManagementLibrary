package com.book.bookservice.model;

import com.book.bookservice.model.Book;
import com.book.bookservice.model.Categorie;
import com.book.bookservice.model.GenreLivre;
import com.book.bookservice.model.Langue;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Book.class, name="p")
public interface BookProjection {
    public String getId();
    public Categorie getCategorie();
    public GenreLivre getGenre();
    public Langue getLangue();
}
