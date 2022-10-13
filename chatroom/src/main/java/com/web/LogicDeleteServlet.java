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

@WebServlet("/logicDeleteServlet")
public class LogicDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        CharContentService charContentService = new CharContentServiceImpl();

        CharContent charContent = new CharContent();

        charContent.setId(Integer.parseInt(request.getParameter("id")));

        charContentService.logicDelete(charContent);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
