package com.cs.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.Exception.BookNotFoundException;
import com.cs.Model.Book;
import com.cs.Repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookrepo;
	
	@Override
	public List<Book> getAllBooks() {
		return bookrepo.findAll();
	}

	@Override
	public Book getBookById(int id) throws BookNotFoundException{
		Book book=bookrepo.findById(id).orElseThrow(()->new BookNotFoundException("Book not found"));
		return book;
	}

	@Override
	public Book addBook(Book book) {
		Book newbook=bookrepo.save(book);
		return newbook;
	}

	@Override
	public String updateBook(int id, Book book) {
		Book update_book=bookrepo.findById(id).orElseThrow(()->new BookNotFoundException("Book not found"));
		update_book.setTitle(book.getTitle());
		update_book.setAuthor(book.getAuthor());
		bookrepo.save(update_book);
		return ("Updated book successfully");
	}

	@Override
	public void deleteBook(int id) {
		bookrepo.deleteById(id);

	}

}
