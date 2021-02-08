import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class HtmlParse {
	public static void main(String args[]) {
		
		 Document htmlFile = null;
	        try {
	            htmlFile = Jsoup.parse(new File("C:/Users/Guens Delius/Desktop/Project/GrizzCave/The Project Gutenberg E-text of The Raven, by Edgar Allan Poe.html"), "windows-1252");
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } // right
	        String title = htmlFile.title();
	        Elements p = htmlFile.getElementsByClass("poem");
	        String cssClass = p.text(); // getting class form HTML element
	        
	        StringTokenizer token = new StringTokenizer(cssClass, " \"\t\n\r\f.:;?!—,");
	 
	        System.out.println("Jsoup can also parse HTML file directly");
	        System.out.println("title : " + title);
	        /*while(token.hasMoreTokens()) {
	        	System.out.println(token.nextToken());
	        }*/
	        
	        
	        List<String> pool = new ArrayList<String>();
	        while(token.hasMoreTokens()) {
	        	String t = token.nextToken();
	        	pool.add(t);
	        	System.out.println(t);
	        }
	}

}
