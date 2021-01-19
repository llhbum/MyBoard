package org.llhbum.mapper;

import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.llhbum.domain.ReplyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {
	
	@Autowired
	private ReplyMapper mapper;
	

	
	@Test
	public void testCreate() {
		
		ReplyVO vo = new ReplyVO();
		vo.setBno(3670092L);
		vo.setReply("강두기만세");
		vo.setReplyer("강두기");
		
		mapper.insert(vo);
	}
	
	@Test
	public void testRead() {
		
		ReplyVO vo = new ReplyVO();
		vo = mapper.read(1L);
		log.info(vo);
	}
	
	@Test
	public void testDelete() {
		int result = mapper.delete(1L);
		log.info(result);
	}
	
	@Test
	public void testUpdate() {
		ReplyVO vo = new ReplyVO();
		vo.setReply("강두기 저질");
		vo.setRno(3L);
		int cnt = mapper.update(vo);
		
		log.info(cnt);
	}
	
	@Test
	public void testMapper(){
		log.info(mapper);
	}
}
