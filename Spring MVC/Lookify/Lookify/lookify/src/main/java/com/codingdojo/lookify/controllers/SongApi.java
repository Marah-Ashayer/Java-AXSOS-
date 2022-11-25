package com.codingdojo.lookify.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.lookify.models.Song;
import com.codingdojo.lookify.services.SongService;

@RestController
public class SongApi {
 private final SongService songService;
 public SongApi(SongService songService){
     this.songService = songService;
 }
 @RequestMapping("/api/songs")
 public List<Song> index() {
     return songService.allSongs();
 }
 
 @RequestMapping(value="/api/songs", method=RequestMethod.POST)
 public Song create(@RequestParam(value="title") String title, @RequestParam(value="artist") String artist, @RequestParam(value="rating") int rating) {
	 Song song = new Song(title, artist, rating);
     return songService.createSong(song);
 }
 
 @RequestMapping("/api/songs/top")
 public List<Song> top() {
     return songService.find();
 }
}