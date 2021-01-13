package org.llhbum.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.llhbum.domain.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Test
	public void testGetList() {
		log.info("---------------------");
		boardMapper.getList();
	}
	
	@Test
	public void testInsert() {
		
		BoardVO vo = new BoardVO();
		vo.setTitle("test 제목");
		vo.setContent("test 내용");
		vo.setWriter("test 작성자");
		
		boardMapper.insert(vo);
		
//		log.info("--------------------------");
//		log.info(vo.getBno()); //null 값 -> selectKey 사용하면 편하게 bno 가져올수 있음
	}
	
	@Test
	public void testRead() {
		BoardVO vo = boardMapper.read(6L);
		log.info(vo);
	}
	
	@Test
	public void testDelete() {
		int cnt = boardMapper.delete(1L);
		log.info("---------------------------");
		log.info(cnt);
		
	}
	
	@Test
	public void testUpdate() {
		BoardVO vo = new BoardVO();
		vo.setBno(2L);
		vo.setTitle("upadate title");
		vo.setContent("upadate content");
		vo.setWriter("upadate writer");
		
		log.info("count : " + boardMapper.update(vo));
	}
	

	
}
