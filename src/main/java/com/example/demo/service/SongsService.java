package com.example.demo.service;

import java.util.List;

import com.example.demo.entites.Songs;

public interface SongsService 
{
   public String addSongs(Songs song);
   public boolean songExists(String name);
   public List<Songs> fetchAllSongs();
}
