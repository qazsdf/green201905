package service_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.BoardDAO;
import db_p.BoardDTO;
import di.MvcAction;
import di.MvcForward;

public class Detail implements MvcAction {
	//detail2에서 id 넘길때 pw 같이 넘김. 그때 bid넘길때 &&하고 pw도 같이 보내면 된다.
	@Override
	public MvcForward excute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		BoardDTO dto = new BoardDTO();
		dto.setBid(Integer.parseInt(request.getParameter("bid")));
		
		BoardDAO dao = new BoardDAO();
		dao.addCount(dto);
		
							//나가는 dto		//받는 dto
		request.setAttribute("dto", dao.detail(dto)); 
		
		dao.close();
		
		System.out.println("디테일 서비스 진입");
		
		
		
		return null;
	}

}
