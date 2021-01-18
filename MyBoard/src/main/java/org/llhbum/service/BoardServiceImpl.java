package org.llhbum.service;

import java.util.List;

import org.llhbum.domain.BoardVO;
import org.llhbum.domain.Criteria;
import org.llhbum.mapper.BoardMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.log4j.Log4j;

// 5. service에 맞는 Impl 작성

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
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public BoardVO get(Long bno) {
		// TODO Auto-generated method stub
		
		mapper.boardHit(bno);
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

	@Override
	public List<BoardVO> getList(Criteria cri) {
		return mapper.getListWithPaging(cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		return mapper.getTotalCount(cri);
	}
}
