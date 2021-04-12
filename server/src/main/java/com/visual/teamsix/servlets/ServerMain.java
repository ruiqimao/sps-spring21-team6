package com.visual.teamsix.servlets;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHandler;

/**
 * Starts up a server and links up WebScrapper servlet class to the server.
 * link to Jetty Documentation: https://www.eclipse.org/jetty/documentation/jetty-11/programming_guide.php
 */
public class ServerMain {

    public static void main(String[] args) throws Exception {

        // Create a server that listens on port 8080.
        Server server = new Server(8080);

        ServerConnector connector = new ServerConnector(server);
        connector.setPort(8080);
        server.setConnectors(new Connector[] {
            connector
        });
        
        final ServletHandler servletHandler = new ServletHandler();
        
        servletHandler.addServletWithMapping(WebScraper.class, "/get");
        server.setHandler(servletHandler);

        //Start the server class
        server.start();

        // Keep the main thread alive while the server is running.
        server.join();
    }
}