package com.cs.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.bson.Document;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import com.cs.Model.Book;
import com.cs.Repository.SearchRepository;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Component
public class SerachRepositoryImpl implements SearchRepository {

	MongoClient client;
	
	MongoConverter converter;
	
	@Override
	public List<Book> findByText(String text) {
		final List<Book> books=new ArrayList<>();
		MongoDatabase database=client.getDatabase("Book");
		MongoCollection<Document> collection=database.getCollection("books");
		
		AggregateIterable<Document> result=collection.aggregate(Arrays.asList(new Document("$search",
				new Document("text",
						new Document("query",text)
						.append("path", Arrays.asList("title","author")))),
				new Document("$sort",
						new Document("exp",1L)),
				new Document("$limit",5L)));
		
		result.forEach(doc->books.add(converter.read(Book.class, doc)));
		
		return books;
	}

	
}
