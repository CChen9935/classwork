package objectbooks;

import java.awt.Dimension;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

import javax.swing.JFrame;

public class BookShelf {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person author1 = new Person("Bob", "Ross");
		Person author2 = new Person("Nobel", "Webster");
		Person author3 = new Person("Monkey", "D.", "Luffy");
		Person author4 = new Person("Philip", "K.", "Dick");
		Book book1 = new Book("Joy of Painting", 25, author1);
		Book book2 = new Book("Dictionary", 525, author2);
		Book book3 = new Book("One Piece", 718, author3);
		book1.setColor(Color.GREEN);
		book2.setColor(Color.CYAN);
		book3.setColor(Color.BLUE);
		// System.out.println(book1);
		// System.out.println(book2);
		// System.out.println(book3);

		ArrayList<Book> shelf = new ArrayList<Book>();

		shelf.add(book1);
		shelf.add(book2);
		shelf.add(book3);
		shelf.add(new Book("The Man", 20, author3));
		Book book5 = new Book("The Minority Report", 509, author2);
		shelf.add(0, book5);
		ArrayList<Book> creepyBooks = new ArrayList<Book>();
		creepyBooks.add(new Book("The Man in the High Castle", 120, author4));
		creepyBooks.add(new Book("Flow My Tears, the Policeman Said", 121,
				author4));
		creepyBooks.add(new Book("Blade Runner", 150, author4));
		creepyBooks.add(new Book("Total Recall", 140, author4));
		creepyBooks.add(new Book("A Scanner Darkly", 130, author4));
		for (int i = 0; i < creepyBooks.size(); i++)
			shelf.add(creepyBooks.get(i));

		Collections.sort(shelf, new Comparator<Book>() {
//			public int compare(Book a, Book b) {
//				return a.getNumberOfPages() - b.getNumberOfPages();
//			}
			public int compare(Book a, Book b) {
				return a.getAuthor().getLastName().compareTo( b.getAuthor().getLastName());
			}

		});
		//printAllBooks(shelf);
		Library lib = new Library(shelf);//use "books" or "shelf" whatever your ArrayList is 

		lib.setSize(new Dimension(500,500));

		lib.setVisible(true);

		lib.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void sortByPageNumber(boolean ascending, ArrayList<Book> list){
		Collections.sort(list, new Comparator<Book>() {
			public int compare(Book a, Book b) {
				return a.getNumberOfPages()-b.getNumberOfPages();
			}

		});
	}	
	public static void sortByHeight(boolean ascending, ArrayList<Book> list){
		Collections.sort(list, new Comparator<Book>() {
			public int compare(Book a, Book b) {
				return a.getHeight()-b.getHeight();
			}

		});
	}
	public static void sortByTitle(boolean ascending, ArrayList<Book> list){
		Collections.sort(list, new Comparator<Book>() {
			public int compare(Book a, Book b) {
				return a.getTitle().compareTo( b.getTitle());
			}

		});
	}	
	public static void sortByAuthor(boolean ascending, ArrayList<Book> list){
		Collections.sort(list, new Comparator<Book>() {
			public int compare(Book a, Book b) {
				return a.getAuthor().getLastName().compareTo( b.getAuthor().getLastName());

		}});
	}
	private static void printAllBooks(ArrayList list) {
		for (int i = 0; i < list.size(); i++)
			System.out.println(i + ")" + list.get(i));
	}

}
