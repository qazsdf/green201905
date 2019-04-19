package cont;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.BoardDAO;
import di.MvcAction;
import di.MvcForward;

/**
 * Servlet implementation class F_Controller
 */
@WebServlet("/board/*")//web.xml열할을 해주는 녀석 /board/라고 써있으면 다 여기로와
//img파일은 board로 만들면안되 다른 폴더로 분류해서 우회하게 만들어야한다.
public class F_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public F_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //doget이 dopost로 넘겨주고있다
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String service = request.getRequestURI().substring("/mvcProj/board/".length());
		//board/로 들어가는 녀석들만 mapping
		try {
			//서비스를 가지고 어트리뷰트를 셋팅하고 
			//서비스 클래스를 만들어놓고(forward) 갔다가 다시 돌아와서 dispatcher로 넘김
			request.setAttribute("mainUrl", "board/"+service+".jsp");
			
			MvcAction action = (MvcAction)Class.forName("service_p."+service).newInstance();
			//service클래스를 불러옴 .newInstance()로 클래스를 생성하고 그러면 service_p/List.java를 생성해서 넘어가, 넘어가면 
			//request.setAttribute("data", new BoardDAO().list()); 이게 db를 다녀오는 과정
			//return값이 object 하나의 메소드이름을 다같이 쓰면서, interface로 구현 . 형변환이 자유롭게 하기위해서
			//누구를 사용해도 excute로 실행하게 
			//현재 6번까지 진행
			
			MvcForward forward = action.excute(request, response);//파일에 따른 처리 분기
			//service_p안에 만들어야하는 class들은(list,detail...등) mvcAction을 꼭 구현하고 있어야해
			
			
			//view page로 넘긴다. template로 넘길꺼야
			//inc폴더에 top, menu, bottom jsp파일을 만들고
			//request로 부터 dispatcher를 받아올꺼야
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/template.jsp");
			//페이지 이동 클래스
			dispatcher.forward(request, response);
			//페이지 이동
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(service);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
