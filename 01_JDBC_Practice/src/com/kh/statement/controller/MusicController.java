package com.kh.statement.controller;

import java.util.List;

import com.kh.statement.model.dao.MusicDao;
import com.kh.statement.model.vo.Music;

public class MusicController {
	public int plusMusic(String musicName, String singer, String genre, String playTime, int albumSell, String releaseDate) {
		
		Music music = new Music(musicName, singer, genre, playTime, albumSell, releaseDate);
		
		int result = new MusicDao().plusMusic(music);
		return result;
	}
	public List<Music> findAll() {
	List<Music> musics = new MusicDao().findAll();	
	return musics;
	}

}