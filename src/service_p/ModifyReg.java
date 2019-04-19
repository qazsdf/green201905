package service_p;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import db_p.BoardDAO;
import db_p.BoardDTO;
import di.MvcAction;
import di.MvcForward;

public class ModifyReg implements MvcAction {

	@Override
	public MvcForward excute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		
		
		
		//file경로를 알고있는 것
		String path = request.getRealPath("/fff");
		path = "D:\\utf8Work\\mvcProj\\WebContent\\fff";
		
		try {
			//enctype을 쓰면 request를 못쓴다 ㅎ
			MultipartRequest mm = new MultipartRequest(
					request,
					path,
					10*1024*1024,
					"utf-8", 
					new DefaultFileRenamePolicy());
			
			int page = 1;
			if(mm.getParameter("page")!=null) {
				page = Integer.parseInt(mm.getParameter("page"));
			}
			
			BoardDTO dto = new BoardDTO();
			dto.setBid(Integer.parseInt(mm.getParameter("bid")));
			dto.setTitle(mm.getParameter("title"));
			dto.setPname(mm.getParameter("pname"));
			dto.setPw(mm.getParameter("pw"));
			dto.setContent(mm.getParameter("content"));
			if(mm.getParameter("upfile")!=null) {
				dto.setUpfile(mm.getParameter("upfile"));//이것만하면안되
			}else {
				dto.setUpfile(mm.getFilesystemName("upfile"));
			}
			
			
			//request.setAttribute("dto", dto);
			
			
			String msg = "암호가 일치하지 않습니다.";
			String goUrl = "ModifyForm?bid="+dto.getBid()+"&page="+page;
			//암호 체크는 DAO delete안에서 
			if(new BoardDAO().modify(dto)) {
				msg = "수정되었습니다.";
				goUrl = "Detail?bid="+dto.getBid()+"&page="+page;
			}else if((mm.getParameter("upfile"))==null){
				File ff = new File(path+"\\"+dto.getUpfile());
				ff.delete();
			}
			
			
			request.setAttribute("msg", msg);
			request.setAttribute("goUrl", goUrl);
			request.setAttribute("mainUrl", "board/alert.jsp");
			
			System.out.println(dto.getBid());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return null;
	}

}
