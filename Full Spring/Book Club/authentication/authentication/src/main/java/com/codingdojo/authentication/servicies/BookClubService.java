package com.codingdojo.authentication.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.authentication.models.BookClub;
import com.codingdojo.authentication.repositories.BookClubRepository;

@Service
public class BookClubService {

 // adding the Book repository as a dependency
	private final BookClubRepository bookRepository;
 
 public BookClubService(BookClubRepository bookRepository) {
     this.bookRepository = bookRepository;
 }
 // returns all books
 public List<BookClub> allBooks() {
     return bookRepository.findAll();
 }
 // creates a book
 public BookClub createBook(BookClub b) {
     return bookRepository.save(b);
 }
 // retrieves a book
 public BookClub findBook(Long id) {
     Optional<BookClub> optionalBook = bookRepository.findById(id);
     if(optionalBook.isPresent()) {
         return optionalBook.get();
     } else {
         return null;
     }
 }
 
 public BookClub updateBook(BookClub book){
	 return bookRepository.save(book);
 }
 public void deleteBook(Long id ) {
     Optional<BookClub> optionalBook = bookRepository.findById(id);
     if(optionalBook.isPresent()) {
    	 bookRepository.deleteById(id);
     }
 }
}

