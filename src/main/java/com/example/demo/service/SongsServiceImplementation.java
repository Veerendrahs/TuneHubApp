package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entites.Songs;
import com.example.demo.repository.SongsRepository;
@Service
public class SongsServiceImplementation implements SongsService
{
	@Autowired
    SongsRepository srepo;
	@Override
	public String addSongs(Songs song)
	{
		srepo.save(song);
		return "Song is Added";
	}
	@Override
	public boolean songExists(String name) {
		Songs song=srepo.findByName(name);
		if(song==null)
		{
			return false;
		}
		else
		{
			return true;
		}
			
	}
	@Override
	public List<Songs> fetchAllSongs() {
		List<Songs> songlist=srepo.findAll();
		return songlist;
	}
  
}
