package com.visual.teamsix.servlets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.KeyFactory;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form-handler")
public class FormHandlerServlet extends HttpServlet {

    @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    // Get the value entered in the form.
    String Location = request.getParameter("Location");

    // Print the value so you can see it in the server logs.
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("User Location");
    FullEntity contactEntity =
        Entity.newBuilder(keyFactory.newKey())
            .set("User Location", Location)
            .build();
    datastore.put(contactEntity);

    System.out.println("User Location: " + Location);
    
    // Write the value to the response so the user can see it.
   response.sendRedirect("/index.html");
  }
}