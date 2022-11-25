package com.codingdojo.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.lookify.models.Song;
import com.codingdojo.lookify.services.SongService;

@Controller
public class SongController {
	
	  private final SongService songService;
	  
	  public SongController(SongService songService) {
	      this.songService = songService;
	  }
	  
	  @GetMapping("")
	  public String main() {
	      return "main.jsp";
	  }
	  
	  @GetMapping("/dashboard")
	  public String main(Model model) {
	  	
	    List<Song> songs = songService.allSongs();
	    model.addAttribute("songs", songs);
	      return "dashboard.jsp";
	  }
	  //------------------------Add Song --------------------------------------// 
	    @GetMapping("/songs")
	    public String newSong(Model model,@ModelAttribute("song") Song song) {
	        List<Song> songs = songService.allSongs();
	        model.addAttribute("songs", songs);
	        return "new.jsp";
	    }
	    @PostMapping("/songs/new")
	    public String create(@Valid @ModelAttribute("song") Song song, BindingResult result,Model model) {
	        if (result.hasErrors()) {
		        List<Song> songs = songService.allSongs();
		        model.addAttribute("songs", songs);
	            return "new.jsp";
	        } else {
	        	songService.createSong(song);
	            return "redirect:/dashboard";
	        }
	    }
//    // ---------------------------Show Song --------------------------------//
	 @GetMapping("/songs/{id}")
	 public String show(@PathVariable("id") Long id, Model model) {
		 Song song = songService.findSong(id);
		 model.addAttribute("song",song);
	     return "show.jsp";
	     }
	  
      //-----------------------------Delete --------------------------------//
      
      @DeleteMapping("/songs/delete/{id}")
      public String destroy(@PathVariable("id") Long id) {
      	songService.deleteSong(id);
          return "redirect:/dashboard";
      }
      @RequestMapping("/songs/top")
      public String top(Model model) {
  	    List<Song> topSongs = songService.find();
  	    model.addAttribute("topSongs", topSongs);
  	    return "top.jsp";
          
      }
      // --------------------------------Search ------------------------------//
	  	@PostMapping("/search")
	  	public String searc(@RequestParam("artist") String artist, Model model) {
	  		model.addAttribute("artist", artist);
	  		return "redirect:/search/"+artist;
	  	}
		@GetMapping("/search/{artist}")
		public String search(@PathVariable("artist") String artist, Model model) {
			List<Song> songs = songService.search(artist);
			model.addAttribute("songs", songs);
			return "search.jsp";
		}
}
