package examples.feed;

import java.io.Serializable;

public class Feed implements Serializable {
	
	private static final long serialVersionUID = -5958110630434539041L;
	
	private String title;
	private String link;
	private String publishDate;
	private String description;
	
	public Feed(String title, String link, String publishDate, String description) {
		this.title = title;
		this.link = link;
		this.publishDate = publishDate;
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Feed [title=" + title + ", link=" + link + ", publishDate="
				+ publishDate + ", description=" + description + "]";
	}
	
	
}
