package org.llhbum.service;

import java.util.List;

import org.llhbum.domain.BoardAttachVO;
import org.llhbum.domain.BoardVO;
import org.llhbum.domain.Criteria;
import org.llhbum.mapper.BoardAttachMapper;
import org.llhbum.mapper.BoardMapper;
import org.llhbum.mapper.ReplyMapper;
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
	@Autowired
	private final ReplyMapper replyMapper;
	
	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public void register(BoardVO board) {
		// TODO Auto-generated method stub
		mapper.insertSelectKey(board);
		if(board.getAttachList() == null || board.getAttachList().size() <= 0){
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
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public boolean modify(BoardVO board) {
		log.info("modify ............ " + board);
		
		// 모든 upload파일/이미지 다 지움
		attachMapper.deleteAll(board.getBno());
		
		boolean modifyResult = mapper.update(board) == 1;
		
		if(modifyResult && board.getAttachList() != null && board.getAttachList().size()>0) {
			board.getAttachList().forEach(attach -> {
				attach.setBno(board.getBno());
				attachMapper.insert(attach);
			});
		}
		return modifyResult;
	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public boolean remove(Long bno) {
		// TODO Auto-generated method stub
		log.info("remove.... " + bno );
		attachMapper.deleteAll(bno);
		replyMapper.replyDeleteAll(bno);
		return mapper.delete(bno) == 1;
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
