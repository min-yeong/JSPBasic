package com.bit.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {
	// Filter는 서블릿으로 요청이 넘어오기 전에 미리 요청과 관련된 작업을 수행, 서블릿의 응답을 클라이언트로 전송하기 전에 응답에 관련된 추가 내용을 수행
	private static Logger logger = Logger.getLogger(EncodingFilter.class.getSimpleName());
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info("[Encoding Filter] init");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// Filter는 여러개가 연결될 수 있고 doFilter 메서드 내에서 요청 관련 처리를 마친 후 chain에 연결된 필터의 doFilter를 다시 호출
		logger.info("[EncodingFilter : doFilter]");
		// 뒤쪽으로 넘기기 전에 요청을 먼저처리
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		// 필터 적용 순서 확인
		PrintWriter out = response.getWriter();
		out.println("<h1>필터 동작 이전</h1>");
		// 먼저 처리된 요청과 응답 객체를 연결된 뒤쪽 필터(서블릿)으로 전달
		chain.doFilter(request, response);
		out.println("<h1>필터 동작 이후</h1>");
		// 응답 시 filter의 적용 순서는 요청 적용 순서의 역순
	}
	
	@Override
	public void destroy() {
		logger.info("[EncodingFilter] destroy");
	}
}
