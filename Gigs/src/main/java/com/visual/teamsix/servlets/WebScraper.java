package com.visual.teamsix.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import resources.GetWebData;

/** Servlet that responds with data retrieved from webscrapper. */
@WebServlet("/get")
public class WebScraper extends HttpServlet {
    private static final long serialVersionUID = 1L;
    GetWebData scrap = new GetWebData();
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;");
        //Call the class and pass it into response
        response.getWriter().println(scrap.scraper());
    }
}