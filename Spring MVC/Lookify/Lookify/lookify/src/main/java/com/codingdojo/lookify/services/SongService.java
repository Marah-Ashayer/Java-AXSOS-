package com.codingdojo.lookify.services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.lookify.models.Song;
import com.codingdojo.lookify.repositories.SongRepository;

@Service
public class SongService {
 // adding the Song repository as a dependency
	private final SongRepository songRepository;
 
 public SongService(SongRepository songRepository) {
     this.songRepository = songRepository;
 }
 // returns all songs
 public List<Song> allSongs() {
     return songRepository.findAll();
 }
 // creates a song
 public Song createSong(Song s) {
     return songRepository.save(s);
 }
 // retrieves a song
 public Song findSong(Long id) {
     Optional<Song> optionalSong = songRepository.findById(id);
     if(optionalSong.isPresent()) {
         return optionalSong.get();
     } else {
         return null;
     }
 }
 
 public Song updateSong(Song song){
	 return songRepository.save(song);
 }
 
 public void deleteSong(Long id ) {
     Optional<Song> optionalSong = songRepository.findById(id);
     if(optionalSong.isPresent()) {
    	 songRepository.deleteById(id);
     }
 }
 public List<Song> find(){
     List<Song> table = songRepository.find();
     return table;
}
 
// public List<Song> search(String artist){
//	 return songRepository.findByArtistContaining(artist);
//      
//}
 
 
public List<Song> search(String artist){
 return songRepository.search(artist);
  
}
}


