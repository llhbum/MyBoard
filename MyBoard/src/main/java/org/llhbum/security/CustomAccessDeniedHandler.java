package org.llhbum.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.handler.Handler;

import org.springframework.security.access.AccessDeniedException;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomAccessDeniedHandler {
	
	public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessException)
	throws IOException, ServletException{
		log.error("");
		log.error("");
		
		response.sendRedirect("/accessError");
	}
	
}
