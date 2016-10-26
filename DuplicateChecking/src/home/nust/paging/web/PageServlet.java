package home.nust.paging.web;

import home.nust.paging.model.DuplicateChecking;
import home.nust.paging.model.Page;
import home.nust.paging.service.PageService;
import home.nust.paging.service.PageServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PageServlet extends HttpServlet {

	public static final Logger logger = Logger.getLogger("PageServlet");
	
	private PageService pageService = new PageServiceImpl();
	public PageServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		logger.setLevel(Level.INFO);

		String pageIndex = request.getParameter("currentPage");
        int index;
        if("".equals(pageIndex) || null == pageIndex)
            index = 1;
        else
            index = Integer.parseInt(pageIndex);

        logger.info("visit page " + index);
        
        Page<DuplicateChecking> page = pageService.getPage(index, 10);
        request.setAttribute("page", page);
        request.setAttribute("msg","error");
        request.getRequestDispatcher("/list.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void init() throws ServletException {
	}

}
