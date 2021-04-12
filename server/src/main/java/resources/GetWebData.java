package resources;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

public class GetWebData {
 
  static final int MAX_WEBSITE_PAGES = 12;
  static final int INITIAL_PAGE = 2;
  static final String BASE_URL = "https://www.simplyhired.com";

  private String scrapeURL = "https://www.simplyhired.com/search?q=gig+work";
  
  public GetWebData(String zip, String dist){
    String locationQuery = "&l="+zip+"&mi="+dist+"&pn=";
    scrapeURL = scrapeURL+locationQuery;
  }

  public JsonObject scraper() {
    //Create a document object - This is where website data is initially held
    Document document;
    //Count gigs in page
    int postingTotal; 
    int count = 0;
    //Initialize needed classes for JSON object creation after data is obtained
    JsonArray array = new JsonArray();;
    Gson gson = new GsonBuilder().create();
    JsonObject jsonObject = new JsonObject();
    JsonObject main = new JsonObject();

    try {
      //We have to loop through each of the website page as displayed
      for (int current_page = INITIAL_PAGE; current_page <= MAX_WEBSITE_PAGES; current_page++) {
        //Get Document object after parsing the html from given url.
        String url = scrapeURL + String.valueOf(current_page);
        document = Jsoup.connect(url).get();
        Elements mainDiv = document.select("div.SerpJob-jobCard");
        postingTotal = Integer.parseInt(document.select("span.posting-total").text());
        if(count >= postingTotal) break;
        for (int i = 0; i < mainDiv.size(); i++) {
          Element element = mainDiv.get(i);
          String name = element.select("a.SerpJob-link").text();
          String location = element.select("span.jobposting-location").text();
          //Clean data to get first 2 words
          String[] mylocation = location.split(" ");
          //Concatenate the first two words
          location = mylocation[0] + " " + mylocation[1];
          //Get description
          String description = element.select("p.jobposting-snippet").text();
          Elements hreff = element.select("a.SerpJob-link");
          //Get salary
          String salary = element.select("span.jobposting-salary").text();
          //concatenate string url and extracted part
          String link = BASE_URL + hreff.attr("data-mdref");
          //Create an object for each data that is retrieved
          Gig gig = new Gig(name, location, description, salary, link);
          //Add each data to a JSON array
          array.add(gson.toJsonTree(gig));
          count++;
          jsonObject.add("subdata", array);
        }
      }
    } catch (final IOException e) {
      e.printStackTrace();
    }
    main.add("data", jsonObject);
    return main;
  }

}