import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Servlet은 HttpServlet을 상속받아 세부 메서드를 구현한다.
public class HelloServlet extends HttpServlet {
	
	//Log 기록을 위한 Logger 설정
	private static final Logger logger = Logger.getLogger("HelloServlet");
	private String appName; // 컨텍스트 파라미터로부터 받아올 응용프로그램 이름
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// 첫번째 요청이 일어났을 때 1회 호출, 서블릿 전체의 초기화를 담당
		super.init(config);
		logger.info("[LifeCycle] : init");
		
		// 컨텍스트 파라미터 불러오기
		// 1. 컨텍스트 불러오기
		ServletContext context = getServletContext();
		// 2. 컨텍스트로부터 초기화 파라미터 불러오기
		appName = context.getInitParameter("appName");
		
		logger.info("Application Name : "+ appName);
	}
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// servlet 초기화 파라미터 읽어오기
		// 1. servletConfig 확인
		ServletConfig config = getServletConfig();
		String servletName = config.getInitParameter("servletName");
		String description = config.getInitParameter("description");
		
		logger.info("ServletName : "+servletName);
		logger.info("description : "+description);
		// service 메서드 : 모든요청(GET, POST, PUT, DELETE 등) 처리
		logger.info("[LifeCycle] : service");
	
		// 요청 메서드 확인
		logger.info("method :"+ req.getMethod());
		if(req.getMethod().equals("GET")) doGet(req, resp);
		else if(req.getMethod().equals("POST")) doPost(req, resp);
		else super.service(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Get 메서드 요청 처리를 위한 메서드 오버라이드
		// Servlet은 WAS가 특정 요청을 받았을 때 실행시켜준다 클라이언트로부터 전달받은 요청을 객체로 변환하여 HttpServletRequest로 전달
		// 요청에 따른 응답은 WAS로 부터 전달받은 HttpServletRequest 객체로 출력
		
		// 1. 클라이언트로부터 전송된 Parameter를 받아오기(name) {
		logger.info("[LifeCycle] : doGet");
		String name = req.getParameter("name");
		
		// 2. 응답 객체에 페이지 컨텐츠 타입을 전송
		resp.setContentType("text/html;charset=UTF-8");
		if(name==null) {
			name = "Anonymous";
			//만약에 name 파라미터가 없다면 오류발생
			// Error page 테스트
			throw new ServletException("name이 비어있음");
		}
			
		//응답 바디를 출력
		// 3. 응답 출력을 위한 Writer 얻어오기
		PrintWriter out = resp.getWriter();
		out.println("<h1>Hello Servlet</h1>");
		out.println("<p>Welcome, "+name+"</p>");
//		super.doGet(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("[LifeCycle] : doPost");
		// POST 방식의 요청처리를 위한 method override
		//super.doPost(req, resp);
		//클라이언트 요청의 encoding을 UTF-8로 변경
		req.setCharacterEncoding("UTF-8");
		// 응답 출력을 위한 컨텐트 타입고 인코딩을 결정
		resp.setContentType("text/html;charset=UTF-8"); // -> 이 콘텐트 타입의 정보를 가지고 브라우저가 출력방식 결정
		
		// 응답 출력을 위해 응답 객체로부터 출력용 객체를 얻어옴
		PrintWriter out = resp.getWriter();
		String first_name = req.getParameter("first_name");
		String last_name = req.getParameter("last_name");
		out.println("<h1>폼 데이터 처리</h1>");
		out.println("전송된 first_name:"+first_name);
		out.println("전송된 last_name:"+last_name);
	}
	
	@Override
	public void destroy() {
		// 서버가 종료되거나 요청이 오랫동안 없어서 더 이상 필요 없을 경우 1회 호출
		logger.info("[LifeCycle] : destory");
		super.destroy();
	}

}
