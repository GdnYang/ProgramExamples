package examples.feed;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
 
import java.util.Iterator;
import java.util.Set;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;

public class FeedJsonWriter {
	
	@SuppressWarnings("rawtypes")
	public static void feedJsonWrite(Set fdset) throws FileNotFoundException {
		OutputStream os = new FileOutputStream("C:/Eclipse-Kepler/workspace/ProgrammingExamples/data/feeds.json");
        JsonWriter jsonWriter = Json.createWriter(os);
        Feed feed = null;
        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
        Iterator iter = fdset.iterator();
	    while (iter.hasNext()) {
	        feed = (Feed)iter.next();
	        jsonArrayBuilder.add(Json.createObjectBuilder()
			                .add("title", feed.getTitle())
	                        .add("link", feed.getLink())
	                        .add("pubdate", feed.getPublishDate())
	                        .add("description", feed.getDescription()));
	    }
	    
	    JsonArray jsonArray = jsonArrayBuilder.build();
	    
	    // Write JsonArray to file
	    jsonWriter.writeArray(jsonArray);
	    System.out.println(jsonArray.toString());
	    
	    jsonWriter.close();
	}

	public static void main(String[] args) throws FileNotFoundException {
		
		Feed feed = new Feed("A Feed", "http://localhost/feed/", 
	             			 "22-12-2014", "This is a feed test.");
		JsonObjectBuilder feedBuilder = Json.createObjectBuilder();
		feedBuilder.add("title", feed.getTitle())
                   .add("link", feed.getLink())
                   .add("pubdate", feed.getPublishDate())
                   .add("description", feed.getDescription());
		
		JsonObject feedJsonObject = feedBuilder.build();
        
        System.out.println("Feed JSON String\n" + feedJsonObject);
         
        //write Json to file
        OutputStream os = new FileOutputStream("C:/Eclipse-Kepler/workspace/ProgrammingExamples/data/feeds.json");
        JsonWriter jsonWriter = Json.createWriter(os);
        jsonWriter.writeObject(feedJsonObject);
        jsonWriter.close();
		
	}

}
