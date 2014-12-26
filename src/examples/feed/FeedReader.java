package examples.feed;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;

import com.sun.syndication.feed.synd.*;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

public class FeedReader {
	
	@SuppressWarnings("rawtypes")
	public static void main(String args[]) {
		
		String sURL = "http://www.macleans.ca/multimedia/feed/";
		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
		XmlReader reader = null;
		try {
			URL feedURL = new URL(sURL);
			reader = new XmlReader(feedURL);
			SyndFeedInput input = new SyndFeedInput();
			SyndFeed sdfeed = input.build(reader);
			Set<Object> sEntries = new HashSet<Object>();
			List entries = sdfeed.getEntries();
			Iterator it = entries.iterator();
			while (it.hasNext()) {
				SyndEntry entry = (SyndEntry)it.next();
				String title = entry.getTitle();
				Date pubDate = entry.getPublishedDate();
				String pubDate_str = dateformat.format(pubDate);
				String link = entry.getLink();
				String descr = entry.getDescription().getValue();
				Feed feed = new Feed(title, link, pubDate_str, descr);
				sEntries.add(feed);
				System.out.println("Feed To String : " + feed.toString());
				System.out.println("*****************************************************************");
			}
			
			// Write Feed HashSet to Database
			FeedWriteToDB.writeFeedToDB(sEntries);
			
			// Write Feed HashSet to file as JSON format
			FeedJsonWriter.feedJsonWrite(sEntries);		
			
		} catch (Exception ex) {
			ex.printStackTrace();
            System.out.println("ERROR: " + ex.getMessage());
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (Exception ex) {
				}
			}
		}
	}
}

