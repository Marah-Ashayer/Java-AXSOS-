package com.codingdojo.lookify.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.lookify.models.Song;


@Repository
public interface SongRepository extends CrudRepository<Song, Long>{
 // this method retrieves all the books from the database
 List<Song> findAll();
 
 
@Query(value="SELECT * FROM songs GROUP BY title ORDER BY rating DESC LIMIT 10 ", nativeQuery=true)
List<Song> find();

@Query(value="SELECT * FROM songs GROUP BY artist WHERE artist= ?1 ", nativeQuery=true)
List<Song> search(String artist );


//List<Song> findByArtistContaining(String artist);
}
