package com.kh.statement.model.service;
import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.kh.statement.model.dao.MusicDao;
import com.kh.statement.model.vo.Music;


public class MusicService {
	private Connection conn = null;
	
	public MusicService() {
		conn = getConnection();
	}
	
	public int plusMusic(Music music) {
		
		int result = new MusicDao().plusMusic(conn, music);
		
		if(result > 0) {
			commit(conn);
		}
		
		close(conn);
		return result;
	}
	
	public List<Music> findAll(){
		
		List<Music> musics = new MusicDao().findAll(conn);
		close(conn);
		return musics;
		
	}
	
	public List<Music> findByName(String name){
		
		List<Music> musics = new MusicDao().findByName(conn, name);
		close(conn);
		return musics;
		
	}
	
	public Music findBySinger(String singerName){
		
		Music music = new MusicDao().findBySinger(conn, singerName);
		close(conn);
		return music;
		
	}

	public Music findByGenre(String genreName){
	
	Music music = new MusicDao().findByGenre(conn, genreName);
	close(conn);
	return music;
	
}
	

}