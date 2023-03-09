package com.cs.Service;
import java.util.*;


import com.cs.Exception.BookNotFoundException;
import com.cs.Model.Book;
public interface BookService {
	
	List<Book> getAllBooks();
	Book getBookById(int id) throws BookNotFoundException;
	Book addBook(Book book);
	String updateBook(int id,Book book) throws BookNotFoundException;
	void deleteBook(int id);
	
	
	
	
}
