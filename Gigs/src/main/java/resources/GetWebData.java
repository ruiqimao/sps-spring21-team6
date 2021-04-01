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
    static String url = "https://www.simplyhired.com/search?q=gig+work&pn=";
    static int current_page = 2;
    
    public JsonObject scraper() {
        //Create a document object - This is where website data is initially held
        Document document;
        //Initialize needed classes for JSON object creation after data is obtained
        JsonArray array = new JsonArray();;
        Gson gson = new GsonBuilder().create();
        JsonObject jsonObject = new JsonObject();
        JsonObject main = new JsonObject();
        
       
        try {
            //We have to loop through each of the website page as displayed
            for(current_page = 2; current_page <= MAX_WEBSITE_PAGES; current_page++) {
                //Get Document object after parsing the html from given url.
                url += String.valueOf(current_page);
                document = Jsoup.connect(url).get();
                Elements mainDiv = document.select("div.SerpJob-jobCard");
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
                    Elements hreff = element.select("div.jobposting-title > a");
                    //concatenate string url and extracted part
                    String link = url + hreff.attr("href");
                    //Create an object for each data that is retrieved
                    Data data = organizedData(name, description, location, link);
                    //Add each data to a JSON array
                    array.add(gson.toJsonTree(data));
                    jsonObject.add("subdata", array);
                }
            }

        } catch (final IOException e) {
            e.printStackTrace();
        }
        main.add("data", jsonObject);
        //You can print main to get results on your terminal
        //main is the final JSON object that is the result of 'adding up' each json data object
        return main;

    }
    // method that creates an object representation for each set of data obtained 
    private static Data organizedData(String name, String description, String location, String link) {
         Data data = new Data();
        data.setName(name);
        data.setDescription(description);
        data.setLocation(location);
        data.setUrl(link);
        return data;
    }
}