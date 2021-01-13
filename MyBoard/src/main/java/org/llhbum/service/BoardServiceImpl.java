package org.llhbum.service;

import java.util.List;

import org.llhbum.domain.BoardVO;
import org.llhbum.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@RequiredArgsConstructor
@ToString
public class BoardServiceImpl implements BoardService{
	
	private final BoardMapper mapper;

	@Override
	public Long register(BoardVO board) {
		// TODO Auto-generated method stub
		
		mapper.insertSelectKey(board);
		return board.getBno();
	}

	@Override
	public BoardVO get(Long bno) {
		// TODO Auto-generated method stub
		
		return mapper.read(bno);
	}

	@Override
	public int modify(BoardVO board) {
		// TODO Auto-generated method stub
		
		return mapper.update(board);
	}

	@Override
	public int remove(Long bno) {
		// TODO Auto-generated method stub
		return mapper.delete(bno);
	}

	@Override
	public List<BoardVO> getList() {
		// TODO Auto-generated method stub
		return mapper.getList();
	}
}
