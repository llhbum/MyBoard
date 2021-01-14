package org.llhbum.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.llhbum.domain.BoardVO;
import org.llhbum.domain.Criteria;
import org.llhbum.domain.pageDTO;
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
	
	@Test
	public void testPaging() {
		//1페이지에 10개
		Criteria cri = new Criteria();
		
		List<BoardVO> list = boardMapper.getListWithPaging(cri);
		
		list.forEach(b -> log.info(b));
	}

	@Test
	public void testPageDTO() {
		Criteria cri = new Criteria();
		cri.setPageNum(25);
		
		pageDTO pageDTO = new pageDTO(cri, 251);
		
		log.info(pageDTO);
		
	}
	
}
