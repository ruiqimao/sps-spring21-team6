package resources;

import java.io.IOException;
import com.google.gson.*;
//import com.google.gson.GsonBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Scrapper{
    public JsonObject scrapper() {
    Document document;
    JsonArray array = new JsonArray();
    Gson gson = new GsonBuilder().create();
    JsonObject jsonObject = new JsonObject();
    JsonObject main = new JsonObject();
      try {
            int pages = 2;
            //We have to loop through each of the the pages as displayed
            for(pages= 2; pages <= 12; pages++){
                //Get Document object after parsing the html from given url.
                String url = "https://www.simplyhired.com/search?q=gig+work&pn="+String.valueOf(pages);
                document = Jsoup.connect(url).get();
                Elements mainDiv = document.select("div.SerpJob-jobCard");
                for(int i=0; i<mainDiv.size();i++) {
                    
                    Element element = mainDiv.get(i);
                    String name = element.select("a.SerpJob-link").text();
                    String location = element.select("span.jobposting-location").text();
                    //Regex to get first 2 words
                    String[] mylocation = location.split(" ");
                    location = mylocation[0] + " " + mylocation[1];
                    // String link = element.select("a.SerpJob-link").text();
                    String description = element.select("p.jobposting-snippet").text();
                    Elements hreff = element.select("div.jobposting-title > a");
                    //concatenate string url and extracted part
                    String link = url+hreff.attr("href");
                    Data data = OrganizedData(name, description, location, link);     
                    array.add(gson.toJsonTree(data));
                    jsonObject.add("subdata",array);
 
                }
            } 

            }
        catch (final IOException e) {
            e.printStackTrace();
        }
        main.add("data", jsonObject);
        //You can print main to get results on your terminal
        return main;

  }

   private static Data OrganizedData(String name, String description, String location, String link){
        Data data = new Data();
        data.setName(name);
        data.setDescription(description);
        data.setLocation(location);
        data.setUrl(link);
        return data;
        }
}