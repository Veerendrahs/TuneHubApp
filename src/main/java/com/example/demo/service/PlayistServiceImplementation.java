package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.PlaylistRepository;

@Service
public class PlayistServiceImplementation implements PlaylistService
{
	@Autowired
    PlaylistRepository prepo;
}
