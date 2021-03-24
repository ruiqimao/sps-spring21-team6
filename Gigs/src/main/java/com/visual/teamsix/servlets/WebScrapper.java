package com.visual.teamsix.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import resources.Scrapper;
/** Servlet that responds with the current date. */
@WebServlet("/getData")
public class WebScrapper extends HttpServlet {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
       Scrapper scrap = new Scrapper();
      // String jso = convertToJson(info);

    // Send the JSON as the response
    response.setContentType("application/json;");
    response.getWriter().println(scrap.scrapper());
    //scrap.Scrapper();

  }

 
}