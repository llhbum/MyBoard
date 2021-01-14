package org.llhbum.mapper;

import java.util.List;

import org.llhbum.domain.BoardVO;
import org.llhbum.domain.Criteria;

public interface BoardMapper {
	
	List<BoardVO> getList();
	
	void insert(BoardVO vo);
	
	void insertSelectKey(BoardVO board);
	
	BoardVO read(Long bno);
	
	int delete(Long bno);
	
	int update(BoardVO board);
	
	List<BoardVO> getListWithPaging(Criteria cri);
}
