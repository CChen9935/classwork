package objectbooks;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;





import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SpringLayout;





public class Library extends JFrame{



 /**
 * 
 */
 private static final long serialVersionUID = -242645458485054340L;
 
 public static int BASELINE = 10;
 public static int MARGIN = 450;                                      
 public static int LINE_SPACE = 40;
 public static int BUTTON_SPACE = 100;
 public static int CENTERLINE = 200;
 
 public static int SORT_TITLE=0;
 public static int SORT_AUTHOR=1;
 public static int SORT_SIZE=2;
 public static int SORT_LENGTH=3;

 private ArrayList<Book> shelfAsItIsNow;
 private int base;
 private SpringLayout layout;//view of the library (personView layout)
 private JCheckBox ascending; 
 private JButton sortTitle;
 private JButton sortAuthor;
 private JButton sortHeight;
 private JButton sortPages;
 private BufferedImage bookStack;

 public void paint(Graphics g){
 Graphics2D g2 = (Graphics2D)g;
 g2.setColor(Color.WHITE);
 g2.fillRect(0, 0, getWidth(), getHeight());
 paintComponents(g);
 g2.setColor(Color.BLACK);
 g2.drawLine(0, getHeight()-BASELINE, getWidth(), getHeight()-BASELINE);
 g.drawImage(bookStack, CENTERLINE-bookStack.getWidth()/2, getHeight()-BASELINE-bookStack.getHeight(), this);
 
 }



 public Library(ArrayList<Book> bookshelf) {

 shelfAsItIsNow = bookshelf;
 redoBookImage();
 
 //create all Components (Buttons and ComboBoxes), etc
 ascending = new JCheckBox("Ascending");
 sortTitle=new JButton("Title");
 sortAuthor=new JButton("Author");
 sortHeight=new JButton("Size");
 sortPages=new JButton("Length");
 
 makeLayout();
 }
 
 private void redoBookImage() {
 int maxWidth=0;
 int height =0;
 for(Book b:shelfAsItIsNow){
 if(b.getHeight()>maxWidth)maxWidth=b.getHeight();
 height+=b.getThickness();
 }
 height++;
 maxWidth++;
 bookStack = new BufferedImage(maxWidth, height, BufferedImage.TYPE_INT_ARGB);
 Graphics2D g2= bookStack.createGraphics();
 g2.setColor(Color.WHITE);
 g2.fillRect(0, 0, bookStack.getWidth(), bookStack.getHeight());
 base = bookStack.getHeight();
 for(Book b:shelfAsItIsNow){
 g2.setColor(b.getColor());
 int bookX1 = (maxWidth-b.getHeight())/2;
 int bookY1 = base -b.getThickness();
 g2.fillRect(bookX1, bookY1,b.getHeight(), b.getThickness());
 g2.setColor(Color.BLACK);
 g2.drawRect(bookX1, bookY1,b.getHeight(), b.getThickness());
 int fontHeight = g2.getFontMetrics().getHeight();
 int fontDip = g2.getFontMetrics().getDescent();
 int fontWidth = g2.getFontMetrics().stringWidth(b.getTitle());
 if(b.getThickness()>fontHeight)g2.drawString(b.getTitle(), maxWidth/2-fontWidth/2, base-b.getThickness()/2+fontHeight/2-fontDip);
 base = base-b.getThickness();
 } 
 }
 
 private void makeLayout(){;

// private JButton enterAs;

 layout = new SpringLayout();
 getContentPane().setBackground(Color.WHITE);
 setLayout(layout);
 basicAdd(new JLabel("Sort books by..."),2.5,0);
 basicAdd(ascending,3,0);
 arrangeSortButton(sortTitle,1,SORT_TITLE);
 arrangeSortButton(sortAuthor,2,SORT_AUTHOR);
 arrangeSortButton(sortHeight,3,SORT_SIZE);
 arrangeSortButton(sortPages,4,SORT_LENGTH);

 
 
 
 }

 private void marginAdd(Component component, double level, int width, int margin) {
 add(component);
 layout.putConstraint(SpringLayout.WEST, component, MARGIN+margin, SpringLayout.WEST, this);
 if(width!=0)layout.putConstraint(SpringLayout.EAST, component, MARGIN+margin+width, SpringLayout.WEST, this);
 layout.putConstraint(SpringLayout.NORTH, component, (int)(LINE_SPACE*level), SpringLayout.NORTH, this);
 }

 public void basicAdd(Component c, double level, int width){
 marginAdd(c, level, width, 0);
 }
 
 private void arrangeSortButton(JButton b, int c, final int sortType) {
 add(b);
 layout.putConstraint(SpringLayout.WEST,b,MARGIN+c*BUTTON_SPACE,SpringLayout.WEST,this);
 layout.putConstraint(SpringLayout.EAST,b,MARGIN+(c+1)*BUTTON_SPACE-5,SpringLayout.WEST,this);
 layout.putConstraint(SpringLayout.NORTH, b, LINE_SPACE*3, SpringLayout.NORTH, this);
 b.addActionListener(new ActionListener() {
 
 
 public void actionPerformed(ActionEvent e) {
 if(sortType == SORT_TITLE)BookShelf.sortByTitle(ascending.isSelected(), shelfAsItIsNow);
 if(sortType == SORT_AUTHOR)BookShelf.sortByAuthor(ascending.isSelected(), shelfAsItIsNow);
 if(sortType == SORT_SIZE)BookShelf.sortByHeight(ascending.isSelected(), shelfAsItIsNow);
 if(sortType == SORT_LENGTH)BookShelf.sortByPageNumber(ascending.isSelected(), shelfAsItIsNow);
 redoBookImage();
 repaint();
 }
 });
 }

}

