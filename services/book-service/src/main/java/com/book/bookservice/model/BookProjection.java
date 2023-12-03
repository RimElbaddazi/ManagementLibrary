package com.book.bookservice.model;

import org.springframework.data.rest.core.config.Projection;

@Projection(types = Book.class, name="p")
public interface BookProjection {
    public String getId();
    public Categorie getCategorie();
    public GenreLivre getGenre();
    public Langue getLangue();
}
