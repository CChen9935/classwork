package objectbooks;

import java.awt.Color;

public class Book {
	private String title;
	private int numberOfPages;
	private Person author;
	private Color jacketColor;
	private boolean wasLitOnFire;
	private int height;
	private int thickness;
	Color color;

	public Book(String title, int numberofPages, Person author) {
		this.title = title;
		this.numberOfPages = numberofPages;
		this.author = author;
		jacketColor = Color.gray;
		height = (int) (Math.random() * 100) + 150;
		thickness = numberOfPages / 10;
	}

	public int getHeight() {
		return height;
	}

	public int getThickness() {
		return thickness;
	}

	public String toString() {
//		if(wasLitOnFire){
//			author ="too difficult to read";
//		}
		return "\"" + title + "\", by " + author + ", " + numberOfPages
				+ " pages.";
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public String getTitle() {
		return title;
	}

	public Person getAuthor() {
		return author;
	}

	public Color getJacketColor() {
		return jacketColor;
	}
	public void setHeight(int height) {

	    this.height = height;

	}
	public void setColor(Color color){

	    this.color=color;

	}



	public Color getColor() {
	    return color;

	}
	public void setOnFire() {
		jacketColor = Color.black;
		title = "The title of this book is too charred to make out";
		numberOfPages = 0;
		wasLitOnFire = true;
		// Book.getAuthor();
	}
}
