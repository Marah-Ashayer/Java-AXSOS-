package com.codingdojo.authentication.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.authentication.models.BookClub;
import com.codingdojo.authentication.models.User;
import com.codingdojo.authentication.repositories.BookClubRepository;
import com.codingdojo.authentication.repositories.UserRepository;

@Service
public class BookClubService {

	
	private final UserRepository userRepository;
	private final BookClubRepository bookRepository;
 
 public BookClubService(BookClubRepository bookRepository,UserRepository userRepository) {
     this.bookRepository = bookRepository;
     this.userRepository=userRepository;
 }
 // returns all books
 public List<BookClub> allBooks() {
     return bookRepository.findAll();
 }
 // creates a book
 public BookClub createBook(BookClub b) {
     return bookRepository.save(b);
 }
 // find a book
 public BookClub findBook(Long id) {
     Optional<BookClub> optionalBook = bookRepository.findById(id);
     if(optionalBook.isPresent()) {
         return optionalBook.get();
     } else {
         return null;
     }
 }
 // Update a  Book
 public BookClub updateBook(BookClub book){
	 return bookRepository.save(book);
 }
 
 // Delete a Book
 public void deleteBook(Long id ) {
     Optional<BookClub> optionalBook = bookRepository.findById(id);
     if(optionalBook.isPresent()) {
    	 bookRepository.deleteById(id);
     }
 }
 
 
 
 
//--------------------------------------------------------------------------------------------------------------
	//borrow book
	public void borrowBook(Long userId, Long bookId) {
		BookClub b = bookRepository.findById(bookId).orElse(null);
		User u = userRepository.findById(userId).orElse(null);
		b.setBorrower(u);
		bookRepository.save(b);
	}
	
	//return book
	public void returnBook(Long userId, Long bookId) {
		BookClub b = bookRepository.findById(bookId).orElse(null);
		User u = userRepository.findById(userId).orElse(null);	
		b.setBorrower(null);
		bookRepository.save(b);		
	}
}

