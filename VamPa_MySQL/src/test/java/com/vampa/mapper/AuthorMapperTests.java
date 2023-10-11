package com.vampa.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vampa.model.AuthorVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class AuthorMapperTests {
	
	@Autowired
	private AuthorMapper mapper; // MemberMapper.java 인터페이스 의존성 주입
	
	/* 작가 정보 수정 */
	@Test
	public void authorModifyTest() {
		
		AuthorVO author = new AuthorVO();
				
		author.setAuthorId(1);
		System.out.println("(service)수정 전...................." + mapper.authorGetDetail(author.getAuthorId()));
		
		author.setAuthorName("(service)수정");
		author.setNationId("01");
		author.setAuthorIntro("(service)소개 수정 하였습니다.");
		
		mapper.authorModify(author);
		System.out.println("수정 후...................." + mapper.authorGetDetail(author.getAuthorId()));
		
	}
}
