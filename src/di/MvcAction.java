package di;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MvcAction {
	MvcForward excute(HttpServletRequest request, HttpServletResponse response);
	

}
