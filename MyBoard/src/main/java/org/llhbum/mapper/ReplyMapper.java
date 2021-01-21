package org.llhbum.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.logging.log4j.message.LoggerNameAwareMessage;
import org.llhbum.domain.BoardVO;
import org.llhbum.domain.Criteria;
import org.llhbum.domain.ReplyVO;

public interface ReplyMapper {
	
	public int insert(ReplyVO vo);
	
	public ReplyVO read(Long rno);
	
	public int delete(Long rno);
	
	public int update(ReplyVO vo);
	
	public List<ReplyVO> getListwithPaging(
			@Param("cri") Criteria cri,
			@Param("bno") Long bno);
			
}
