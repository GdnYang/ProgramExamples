package examples.feed;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Set;

public class FeedWriteToDB {
	
	/**
	 * CREATE TABLE feedtab ( 
 	 *   id INT AUTO_INCREMENT, 
 	 *   title varchar(156), 
 	 *   link  varchar(128),
 	 *   pubdate varchar(30),
 	 *   description varchar(500),
 	 *   primary key (id)); 
	 *
	 */
	static final String WRITE_FEED_SQL = "INSERT INTO feedtab(title, link, pubdate, description) VALUES (?, ?, ?, ?)";
	static final String READ_FEED_SQL = "SELECT * FROM feedtab WHERE id = ?";

	public static Connection getConnection() throws Exception {
		String driver = "com.mysql.jdbc.Driver";   
		String url = "jdbc:mysql://localhost:3306/feeds_db";  
		String username = "root";  
		String password = "rtpw"; 
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, username, password);
		return conn;
	}

	public static long writeToDB(Connection conn, Feed fd) throws Exception {
		
		PreparedStatement pstmt = conn.prepareStatement(WRITE_FEED_SQL, Statement.RETURN_GENERATED_KEYS);

		// set input parameters
		pstmt.setString(1, fd.getTitle());
		pstmt.setString(2, fd.getLink());
		pstmt.setString(3, fd.getPublishDate());
		pstmt.setString(4, fd.getDescription());
		pstmt.executeUpdate();

		// get the generated key for the id
		ResultSet rs = pstmt.getGeneratedKeys();
		long id = -1;
		if (rs.next()) {
			id = rs.getInt(1);
		}

		rs.close();
		pstmt.close();
		
		System.out.println("writeFeedToDB: generated key: " + id);
		return id;
	}

	public static Feed readFromDB(Connection conn, long id) throws Exception {
		PreparedStatement pstmt = conn.prepareStatement(READ_FEED_SQL);
		pstmt.setLong(1, id);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		
		Feed fd = new Feed(rs.getString("title"), rs.getString("link"), 
				           rs.getString("pubdate"), rs.getString("description"));
		
		rs.close();
		pstmt.close();
		return fd;
	}
	
	@SuppressWarnings("rawtypes")
	public static void writeFeedToDB(Set fdset) throws Exception {
		Connection conn = null;
		try {
		    conn = getConnection();
		    conn.setAutoCommit(false);
		    
		    Iterator iter = fdset.iterator();
		    while (iter.hasNext()) {
		        Feed feed = (Feed)iter.next();
		    	writeToDB(conn, feed);
		    }
		    
		    conn.commit();
		    
		} catch (Exception e) {
		      e.printStackTrace();
		} finally {
		      conn.close();
		}
	}

	public static void main(String args[]) throws Exception {
		Connection conn = null;
		try {
		    conn = getConnection();
		    System.out.println("conn=" + conn);
		    conn.setAutoCommit(false);
		    
		    Feed feed = new Feed("A Feed", "http://localhost/feed/", 
		    		             "22-12-2014", "This is a feed test.");
		    
		    long key_id = writeToDB(conn, feed);
		    conn.commit();
		    
		    System.out.println("create Key = " + key_id);
			
		    Feed rtfeed = readFromDB(conn, key_id);
		    System.out.println("Read Feed rtfeed = " + rtfeed);
		    
		} catch (Exception e) {
		      e.printStackTrace();
		} finally {
		      conn.close();
		}
	}		
}
