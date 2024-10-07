package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entites.Playlist;
import com.example.demo.service.PlaylistService;
import com.example.demo.service.SongsService;
import com.example.demo.entites.Songs;


@Controller
public class PlaylistController 
{
	@Autowired
    PlaylistService pserv;
	
	@Autowired
	SongsService sserv;
	
	@GetMapping("/creatplaylist")
	public String createPlaylist(Model model)
	{
		List<Songs> songlist=sserv.fetchAllSongs();
		model.addAttribute("songlist",songlist);
		return "createplaylist";
	}
	@PostMapping("/addplaylist")
	public String addPlayList(@ModelAttribute Playlist playlist)
	{
		return "playlistsuccess";
	}
}
