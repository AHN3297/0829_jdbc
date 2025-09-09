package com.kh.statement.model.service;
import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;
import java.util.function.Function;

import com.kh.statement.model.dao.MemberDao;
import com.kh.statement.model.dao.MusicDao;
import com.kh.statement.model.dto.MusicNameDTO;
import com.kh.statement.model.vo.Music;


public class MusicService {
	
	private Connection conn = null;
	
	public MusicService() {
		conn = getConnection();
	}
	
	private <T> T executeQuery(Function<Connection, T> daofunction) {
		Connection conn = null;
		T result = null;
		conn = getConnection();
		result = daofunction.apply(conn);

		close(conn);

		return result;

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
		
		return executeQuery(new MusicDao()::findAll);
		
	}
	
	public List<Music> findByName(String name){
		
		return executeQuery(conn -> new MusicDao().findByName(conn, name));
		
	}
	
	public Music findBySinger(String singerName){
		
		return executeQuery(conn -> new MusicDao().findBySinger(conn, singerName));
		
	}

	public Music findByGenre(String genreName){
		return executeQuery(conn -> new MusicDao().findByGenre(conn, genreName));
	
	}
    public int update(MusicNameDTO md) {
    	if(md.getNewMusicName().length() < 0) {
			return 0;
		}
    	Music music = new MusicDao().update(conn, md.getSinger());
    	
    	if(music == null) {
    		return 0;	
    	}
    	int result = new MusicDao().update(conn, md);
    	
    	if(result > 0) {
    		commit(conn);
    	}
    	close(conn);
    	
    	return result;
    }
    public int delete(Music music) {
    	int result = new MusicDao().delete(conn,music);

		if(result > 0) {
			commit(conn);
		}

		close(conn);

		return result;
    	
    }
	

}