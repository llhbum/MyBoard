package org.llhbum.service;

import java.util.List;

import org.llhbum.domain.BoardAttachVO;
import org.llhbum.domain.BoardVO;
import org.llhbum.domain.Criteria;
import org.llhbum.mapper.BoardMapper;
import org.springframework.stereotype.Service;

// 4. service 구축
// 서비스는 비지니스 용어를 사용해야함
public interface BoardService {
	
	void register(BoardVO board);
	
	BoardVO get(Long bno);
	
	boolean modify(BoardVO board);
	
	boolean remove(Long bno);
	
	List<BoardVO> getList();
	
	List<BoardVO> getList(Criteria cri);
	
	int getTotal(Criteria cri);
	
	public List<BoardAttachVO> getAttachList(Long bno);
	
}
