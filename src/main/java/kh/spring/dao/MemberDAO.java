package kh.spring.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kh.spring.dto.MemberDTO;

@Component
public class MemberDAO {
	@Autowired
	SqlSession db;
	
	public boolean login( Map temp ) {
		int result = db.selectOne("Member.login", temp);
		System.out.println(result);
		if( result == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	public MemberDTO getMyInfo( String id ) {
		return db.selectOne("Member.myInfo", id);
	}
	
	public int modifyInfo( MemberDTO dto ) {
		return db.update("Member.modify", dto);
	}
}
