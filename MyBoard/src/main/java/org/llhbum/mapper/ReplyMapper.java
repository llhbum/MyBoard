package org.llhbum.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.logging.log4j.message.LoggerNameAwareMessage;
import org.llhbum.domain.ReplyVO;

public interface ReplyMapper {
	
	public int insert(ReplyVO vo);
	
	public ReplyVO read(Long rno);
	
	public int delete(Long rno);
	
	public int update(ReplyVO vo);
	
	
}
