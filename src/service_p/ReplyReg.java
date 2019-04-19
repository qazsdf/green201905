package service_p;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import db_p.BoardDAO;
import db_p.BoardDTO;
import di.MvcAction;
import di.MvcForward;

public class ReplyReg implements MvcAction {

	@Override
	public MvcForward excute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		BoardDTO dto = new BoardDTO();
		dto.setBid(Integer.parseInt(request.getParameter("bid")));
		dto.setTitle(request.getParameter("title"));
		dto.setPname(request.getParameter("pname"));
		dto.setPw(request.getParameter("pw"));
		dto.setContent(request.getParameter("content"));
		
		new BoardDAO().reply(dto);
		
		request.setAttribute("msg", "작성되었습니다.");
		request.setAttribute("goUrl", "Detail?bid="+dto.getBid()+"&page="+request.getParameter("page"));
		request.setAttribute("mainUrl", "board/alert.jsp");
		
		
		
		return null;
	}

}
