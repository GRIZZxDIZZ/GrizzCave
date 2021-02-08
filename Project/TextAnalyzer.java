import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class TextAnalyzer {

	public static void main(String[] args)  {
		
		int count =0 , maxCount=0, rank = 1;
		String word = "";
		
		 Document htmlFile = null;
	        try {
	            htmlFile = Jsoup.parse(new File("C:/Users/Guens Delius/Desktop/Project/GrizzCave/The Project Gutenberg E-text of The Raven, by Edgar Allan Poe.html"), "windows-1252");
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } // right
	        String title = htmlFile.title();
	        Elements p = htmlFile.getElementsByClass("poem");
	        String cssClass = p.text(); 
	        
	        StringTokenizer token = new StringTokenizer(cssClass, " \"\t\n\r\f.:;?!—,");
	 
	        System.out.println("Jsoup can also parse HTML file directly");
	        System.out.println("title : " + title);
	        
	        List<String> pool = new ArrayList<String>();
	        while(token.hasMoreTokens()) {
	        	String t = token.nextToken();
	        	pool.add(t);
	        	count++;
	        }
	               
	       Map<String, Long> freq = Arrays.stream(pool.toString().split(" +|\n")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	       LinkedHashMap<String, Long> wordsByCount = freq.entrySet()
	    		   .stream()
	    		   .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
	    		   .collect(Collectors.toMap(
	    				   Map.Entry::getKey,
	    				   Map.Entry::getValue,
	    				   (v1, v2) ->{
	    					   throw new IllegalStateException();
	    				   },
	    				   LinkedHashMap::new
	    				   ));
	       
	    Iterator wbcIterator = wordsByCount.entrySet().iterator();
	       System.out.println("Top 20 words");
	       while(rank != 21) {
	    	   System.out.println("#"+ rank +":"+ wbcIterator.next());
			rank++;
	        }
}
}

	
