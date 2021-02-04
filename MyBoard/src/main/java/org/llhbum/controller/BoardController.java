package org.llhbum.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.llhbum.domain.BoardAttachVO;
import org.llhbum.domain.BoardVO;
import org.llhbum.domain.Criteria;
import org.llhbum.domain.pageDTO;
import org.llhbum.service.BoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

// 6. Controller 분기 및 service와 연동
// 7. JSP 작성
@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {
	
	private BoardService service;
	
//	@GetMapping("/list")
//	public void list(Model model) {
//		log.info("list..............................");
//		model.addAttribute("list", service.getList());
//	}
	
	@GetMapping("/list")
	public void list(Model model, Criteria cri) {
		
		model.addAttribute("list", service.getList(cri));
		model.addAttribute("pageMaker", new pageDTO(cri, service.getTotal(cri)));
	}
	 
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		log.info("*** register Method ***");
		
		
		log.info("=====================================");
		log.info("register : " + board);
		
		//getAttachList에 파일 형식은 저장되어있지않음.
		if(board.getAttachList() != null) {
			board.getAttachList().forEach(attach -> log.info(attach));
		}
		log.info("=====================================");
		
		service.register(board);
		rttr.addFlashAttribute("result", board.getBno());
		
		return "redirect:/board/list";
	}
	
	@GetMapping("/register")
	public void registerGET(@ModelAttribute("cri") Criteria cri , Model model) { 
		
	}
	
	@GetMapping({"/get", "/modify"})
	public void get(@RequestParam("bno")Long bno, @ModelAttribute("cri") Criteria cri, Model model) {
		model.addAttribute("board",service.get(bno));
	}
	
	
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr, Criteria cri ) {
		
		if(service.modify(board)) {
			rttr.addFlashAttribute("result", "success");
		}
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/board/list";
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno")Long bno, RedirectAttributes rttr , Criteria cri) {
		
		List<BoardAttachVO> attachList = service.getAttachList(bno);
		
		if(service.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
			deleteFiles(attachList);
		}
		return "redirect:/board/list" + cri.getListLink();
	}
	
	@GetMapping(value = "/getAttachList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<BoardAttachVO>>getAttachList(Long bno){
		log.info("getAttachList " + bno);
		
		return new ResponseEntity<List<BoardAttachVO>>(service.getAttachList(bno), HttpStatus.OK);
	}
	
	private void deleteFiles(List<BoardAttachVO> attachList) {
		if(attachList == null || attachList.size() == 0) {
			return;
		}
		
		log.info("delete attach files.....................");
		log.info(attachList);
		
		attachList.forEach(attach -> {
			try {
				// 파일이름뒤에 공백 발견 trim으로 제거
				String attachFN = attach.getFileName().trim();
				Path file = Paths.get("C:\\upload\\" + attach.getUploadPath()+"\\"+attach.getUuid()+"_"+attachFN);
				Files.deleteIfExists(file);
				
				if(Files.probeContentType(file).startsWith("image")) {
					
					Path thumbNail = Paths.get("C:\\upload\\" + attach.getUploadPath()+"\\s_"+attach.getUuid()+"_"+attachFN);
					
					Files.delete(thumbNail);
				}
			}catch(Exception e) {
				log.error("delete file error " + e.getMessage());
			}
		});
	}
}
