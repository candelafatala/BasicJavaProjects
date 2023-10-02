package com.candela.book.repos;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.candela.book.models.BookModel;

@Repository
public interface BookRepository extends CrudRepository<BookModel, Long>{ //el id de bookmodel es una variable de tipo long
	
	//Este método recupera todos los libros de la base de datos
    List<BookModel> findAll();
    
    //Este método encuentra un libro por su descripción
    List<BookModel> findByDescriptionContaining(String search);
    
    //Este método cuenta cuántos libros contiene cierta cadena en el título
    Long countByTitleContaining(String search);
    
    //Este método borra un libro que empieza con un título específico
    Long deleteByTitleStartingWith(String search);
}
