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

public class FileDelete implements MvcAction {

	@Override
	public MvcForward excute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		//file경로를 알고있는 것
		String path = request.getRealPath("/fff");
		path = "D:\\utf8Work\\mvcProj\\WebContent\\fff";
		
		try {
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
			//dto.setUpfile(mm.getFilesystemName("upfile"));
			
			
			String msg = "암호가 일치하지 않습니다.";
			BoardDTO dto2 = new BoardDAO().fileDelete(dto);//id, pw가 맞는지 확인만하는 형식으로 
			if(dto2 != null) {//null이면 할일이 없고 null이면 파일을 삭제해라
				
				//파일삭제
				File ff = new File(path+"\\"+dto2.getUpfile());
				ff.delete();
				msg = "파일이 삭제 되었습니다.";
			}else {
				dto.setUpfile(mm.getParameter("upfile"));
			}
			
			
			
			request.setAttribute("dto", dto);
			
			request.setAttribute("msg", msg);
			request.setAttribute("nowPage", page);
			request.setAttribute("mainUrl", "board/ModifyForm.jsp");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return null;
	}

}
