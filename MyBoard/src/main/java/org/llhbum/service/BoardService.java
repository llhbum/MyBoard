package org.llhbum.service;

import java.util.List;

import org.llhbum.domain.BoardVO;
import org.llhbum.domain.Criteria;
import org.llhbum.mapper.BoardMapper;
import org.springframework.stereotype.Service;


// 서비스는 비지니스 용어를 사용해야함
public interface BoardService {
	
	Long register (BoardVO board);
	
	BoardVO get(Long bno);
	
	int modify(BoardVO board);
	
	int remove(Long bno);
	
	List<BoardVO> getList();
	
	List<BoardVO> getList(Criteria cri);
	
}
