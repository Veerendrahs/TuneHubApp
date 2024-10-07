package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.demo.entites.Songs;
import com.example.demo.service.SongsService;

@Controller
public class SongsController 
{
	@Autowired
	SongsService songserv;
	@PostMapping("/addSongs")
  public String addSongs(@ModelAttribute Songs song)
  {
		String name=song.getName();
		boolean status=songserv.songExists(name);
		if(status==false)
		{
			songserv.addSongs(song);
			  return "songsuccess";
		}
		else
		{
			return "songfail";
		}
	  
  }
	@GetMapping("/map-viewsongs")
   public String viewSongs(Model model)
   {
		List<Songs> songlist=songserv.fetchAllSongs();
		model.addAttribute("songslist", songlist);
		return "displaysongs";
   }
	
	@GetMapping( "/viewsongs")
	   public String viewCustomerSongs(Model model)
	   {
	   boolean primeCustomerStatus=true;
	   if(primeCustomerStatus==true)
	   {
			List<Songs> songlist=songserv.fetchAllSongs();
			model.addAttribute("songslist", songlist);
			return "displaysongs";
	   }
	   else
	   {
		   return "makepayment";
	   }
	   }
}
