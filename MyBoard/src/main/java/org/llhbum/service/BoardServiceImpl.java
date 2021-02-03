package org.llhbum.service;

import java.util.List;

import org.llhbum.domain.BoardAttachVO;
import org.llhbum.domain.BoardVO;
import org.llhbum.domain.Criteria;
import org.llhbum.mapper.BoardAttachMapper;
import org.llhbum.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
	private final BoardMapper mapper;
	@Autowired
	private final BoardAttachMapper attachMapper ;
	
	

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public void register(BoardVO board) {
		// TODO Auto-generated method stub
		
		mapper.insertSelectKey(board);
		if(board.getAttachList() == null || board.getAttachList().size() <= 0) {
			return;
		}
		
		board.getAttachList().forEach(attach -> {
			attach.setBno(board.getBno());
			attachMapper.insert(attach);
		});
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

	@Override
	public List<BoardAttachVO> getAttachList(Long bno) {
		log.info("get Attach list by bno : " + bno);
		
		return attachMapper.findByBno(bno);
	}
}
