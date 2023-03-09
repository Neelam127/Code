package com.cs.Model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection="books")
public class Book {
	
	@Id
	private int id;
	private String title;
	private String author;
	private int page_num;
	private boolean isBorrowed;
	
	public Book() {

	}

	public Book(int id, String title, String author, int page_num,boolean isBorrowed) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.page_num = page_num;
		this.isBorrowed=isBorrowed;
	}
	
	

	public Book(int id, String title, String author, int page_num) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.page_num = page_num;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPage_num() {
		return page_num;
	}

	public void setPage_num(int page_num) {
		this.page_num = page_num;
	}

	public boolean isBorrowed() {
		return isBorrowed;
	}

	public void setBorrowed(boolean isBorrowed) {
		this.isBorrowed = isBorrowed;
	}
	
	

	
	
	
	
	

}
