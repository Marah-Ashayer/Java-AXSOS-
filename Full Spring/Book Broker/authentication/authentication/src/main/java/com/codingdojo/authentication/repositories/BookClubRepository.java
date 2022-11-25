package com.codingdojo.authentication.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.authentication.models.BookClub;

@Repository
public interface BookClubRepository extends CrudRepository<BookClub, Long> {
	List<BookClub> findAll();
	List<BookClub> findBorrowedBooksByBorrowerId(Long borrower_id);
	List<BookClub> findAllByBorrowerIsNullOrderByTitle();	
	
	
    
    List<BookClub> findByBorrowerIsNull();

    
    List<BookClub> findByBorrowerIsNotNull();

}
