package com.candela.book.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.candela.book.models.BookModel;
import com.candela.book.repos.BookRepository;

@Service
public class BookService {
	//Agregando el book al repositorio como una dependencia
    
	@Autowired
	private BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    //Devolviendo todos los libros.
    public List<BookModel> allBooks() {
        return bookRepository.findAll();
    }
    //Creando un libro.
    public BookModel createBook(BookModel b) {
        return bookRepository.save(b);
    }
    //Obteniendo la información de un libro
    public BookModel findBook(Long id) {
        Optional<BookModel> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    //Actualizar info de un libro
    public BookModel updateBook(BookModel book, Long id) {
    	BookModel temp = findBook(id);
    	temp.setDescription(book.getDescription());
    	temp.setTitle(book.getTitle());
    	temp.setLanguage(book.getLanguage());
    	temp.setNumberOfPages(book.getNumberOfPages());
    	return bookRepository.save(temp);
    }
    //borrar registro
    public void deleteBook(Long id) {
    	bookRepository.deleteById(id);
    }
}
