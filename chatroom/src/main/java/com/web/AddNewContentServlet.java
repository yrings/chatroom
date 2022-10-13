package com.web;

import com.pojo.CharContent;
import com.service.CharContentService;
import com.service.CharContetnImpl.CharContentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddNewContentServlet")
public class AddNewContentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CharContentService charContentService = new CharContentServiceImpl();

        String content = request.getParameter("input");

        CharContent charContent = new CharContent();

        charContent.setContent(content);

        charContentService.addNewcontent(charContent);

        request.getRequestDispatcher("/index.jsp").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
