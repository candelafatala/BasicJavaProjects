package com.candela.book.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.candela.book.models.BookModel;
import com.candela.book.service.BookService;

@RestController
public class BookApiController {
	
	//inyyeccion de dependencias
	
	@Autowired
    private BookService bookService;
	
    //public BookApi(BookService bookService){
        //this.bookService = bookService;
    //}
    
    //mostrar info de todos los libros
    @GetMapping("/api/books")
    public List<BookModel> index() {
        return bookService.allBooks();
    }
    
    //crea un libro
    @PostMapping(value="/api/books")
    public BookModel create(@RequestParam(value="title") String title, 
    		@RequestParam(value="description") String desc, 
    		@RequestParam(value="language") String lang, 
    		@RequestParam(value="numberOfPages") Integer numOfPages) {
        BookModel book = new BookModel(title, desc, lang, numOfPages);
        return bookService.createBook(book);
    }
    
    
    //muestra info de un libro por id
    @GetMapping("/api/books/{id}")
    public BookModel show(@PathVariable("id") Long id) {
        BookModel book = bookService.findBook(id);
        return book;
    }
    
    
    //actualizar info de un libro en especifico
    @PutMapping("/api/books/{id}")
    public BookModel update(@PathVariable("id") Long id, 
    		@RequestParam(value="title") String title, 
    		@RequestParam(value="description") String desc, 
    		@RequestParam(value="language") String lang, 
    		@RequestParam(value="numberOfPages") Integer numOfPages) {
    	
    	BookModel book = new BookModel(title, desc, lang, numOfPages);
    	return bookService.updateBook(book, id);
    }
    
    //borrar registro de libro
    @DeleteMapping("/api/books/{id}")
    public void deleteBook(@PathVariable("id") Long id) {
    	bookService.deleteBook(id);
    }

}
