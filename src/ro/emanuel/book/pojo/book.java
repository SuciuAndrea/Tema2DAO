package ro.emanuel.book.pojo;

public class book {
	private int id;
	private String title;
	private String author;
	private int pages;
	
	public book() {
	}
	@Override
	public String toString() {
		return "book [id=" + id + ", title=" + title + ", author=" + author+ ", pages=" + pages + "]";
	}
	public book(int id, String title, String author, int pages) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.pages = pages;
	}
	public book(String title, String author, int pages) {
		super();
		this.title = title;
		this.author = author;
		this.pages = pages;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	
	
}