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
    /**
     * Gets POST request from front end.
     * Data point expected from POST request: General Location of the user
     * My Current BackEnd Domain: https://8080-0c250ce2-596f-498a-97c9-5a6597a1c933.cs-us-east1-wzxb.cloudshell.dev/get
     * Expected structure of POST request from front-end: 
     * 
     *  var endpoint = "https://8080-0c250ce2-596f-498a-97c9-5a6597a1c933.cs-us-east1-wzxb.cloudshell.dev/get"
     *    $.ajax{
     *     type: "POST"
     *     content-type: "JSON"
     *     url: endpoint,
     *     data: {location: location} <-- This will be passed to the scraping API to get location specific dat
     *     success: function{} <--------  This is where data from backend will end up if call is successfull
     *     error: function{}.  <--------   Incase of error
     *  }
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //Currently, any POST request will be forwarded to doGet which will immediately retrieve data
        response.setContentType("application/json;");
        //Call doGet
        doGet(request, response); 
    }
    /**
     * Retrieves data from the backend servlet which will then be passed to the front end 
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;");
        //Call the class and pass it into response
        response.getWriter().println(scrap.scraper());
    }
}