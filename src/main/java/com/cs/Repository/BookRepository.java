package com.cs.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cs.Model.Book;

public interface BookRepository extends MongoRepository<Book,Integer>{

}
