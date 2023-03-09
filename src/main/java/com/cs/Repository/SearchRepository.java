package com.cs.Repository;

import java.util.*;



import com.cs.Model.Book;
public interface SearchRepository{
	List<Book> findByText(String text);

}
