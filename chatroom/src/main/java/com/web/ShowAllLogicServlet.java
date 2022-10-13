package com.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pojo.CharContent;
import com.service.CharContentService;
import com.service.CharContetnImpl.CharContentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/showAllLogicServlet")
public class ShowAllLogicServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        CharContentService charContentService = new CharContentServiceImpl();

        List<CharContent> list = charContentService.findAllLogicDelete();

        ObjectMapper om = new ObjectMapper();

        om.writeValue(response.getWriter(),list);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
