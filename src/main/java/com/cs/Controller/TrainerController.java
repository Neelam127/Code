package com.cs.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;


import com.cs.Exception.BookNotFoundException;
import com.cs.Model.Book;
import com.cs.Repository.BookRepository;
import com.cs.Repository.SearchRepository;
import com.cs.Service.BookService;

@RestController
@RequestMapping("/api")
public class TrainerController {
	
	@Autowired
	private BookService bookserv;
	
	@GetMapping("/books")
	public List<Book> getAllBooks(){
		return bookserv.getAllBooks();
	}
	
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book) {
		Book newbook=bookserv.addBook(book);
		return newbook;
	}
	
	@GetMapping("/books/{id}")
	public Book getBookById(@PathVariable("id") int id){
		Book book=bookserv.getBookById(id);
		return book;
	}
	
	@PutMapping("/books/{id}")
	public void  updateBook(@PathVariable("id") int id,@RequestBody Book book1){
		bookserv.updateBook(id, book1);
		
	}
	
	@DeleteMapping("books/{id}")
	public void deleteBook(@PathVariable("id") int id) {
		bookserv.deleteBook(id);
	}
	
//	@GetMapping("/book/{text}")
//	public List<Book> search(@PathVariable String text){
//		return srepo.findByText(text);
//	}
		

}
