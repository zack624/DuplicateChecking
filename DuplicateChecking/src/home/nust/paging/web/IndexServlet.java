package home.nust.paging.web;

import home.nust.paging.model.DuplicateChecking;
import home.nust.paging.model.Page;
import home.nust.paging.service.PageService;
import home.nust.paging.service.PageServiceImpl;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static final Logger LOGGER = Logger.getLogger("IndexServlet");   
    private PageService pageService = new PageServiceImpl();
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		LOGGER.setLevel(Level.INFO);

		String pageIndex = request.getParameter("currentPage");
        int index;
        if("".equals(pageIndex) || null == pageIndex)
            index = 1;
        else
            index = Integer.parseInt(pageIndex);

        LOGGER.info("visit page " + index);
        
        Page<DuplicateChecking> page = pageService.getPage(index, 10);
        request.setAttribute("page", page);
        request.getRequestDispatcher("/jsp/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
