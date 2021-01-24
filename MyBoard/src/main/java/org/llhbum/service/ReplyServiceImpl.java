package org.llhbum.service;

import java.util.List;

import org.llhbum.domain.Criteria;
import org.llhbum.domain.ReplyPageDTO;
import org.llhbum.domain.ReplyVO;
import org.llhbum.mapper.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	private ReplyMapper mapper;
	
	@Override
	public int register(ReplyVO vo) {
		log.info("register..................................");
		return mapper.insert(vo);
	}

	@Override
	public ReplyVO get(Long rno) {
		log.info("get..................................");
		return mapper.read(rno);
	}

	@Override
	public int remove(Long rno) {
		log.info("remove..................................");
		return mapper.delete(rno);
	}

	@Override
	public int modify(ReplyVO vo) {
		log.info("modify..................................");
		return mapper.update(vo);
	}

	@Override
	public List<ReplyVO> getList(Criteria cri, Long bno) {
		log.info("getList..................................");
		return mapper.getListwithPaging(cri, bno);
	}

	@Override
	public ReplyPageDTO getListPage(Criteria cri, Long bno) {
		// TODO Auto-generated method stub
		return new ReplyPageDTO(
				mapper.getCountByBno(bno),
				mapper.getListwithPaging(cri, bno)
				);
	}

}
