import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.*;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

/**
 * <h1>Text Analyzer</h1>
 * This function uses jsoup to read an html file and 
 * collect the top 20 words used in the file
 * @author Guens Delius
 * @version 1.0
 * @since 2021-03
 *
 */
public class TextAnalyzer extends JFrame {
	
	static int count = 0;
	
	int maxCount=0;
	static int rank = 1;
    String word = "";
	private static JTable table;
	static JScrollPane scrollPane = new JScrollPane(table);
	
	
	
	static Map<String, Long> newMap;
	
	private static Map<String, Long> valueSort(Map<String, Long> messMap){
		/**
	     * this function sorts a map using value comparisons
	     * and the collections functions, returning a map
		 */
		
		List<Map.Entry<String, Long>> list =
				new LinkedList<Map.Entry<String, Long>>(messMap.entrySet());
		
		Collections.sort(list, new Comparator<Map.Entry<String, Long>>(){
			public int compare(Map.Entry<String, Long> o1,
							   Map.Entry<String, Long> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});
		
		Map<String, Long> sortMap = new LinkedHashMap<String, Long>();
		for (Entry<String, Long> entry : list) {
			sortMap.put(entry.getKey(), entry.getValue());
		}
		
		return sortMap;
			
		}
	public JTable makeTable(Map<String, Long> map) {
		/**
	     *This function takes in a Map and uses it to make a table
		 */
		
		 System.out.println("Window Made");
		setLayout(new FlowLayout());
		
		String colNames[] = {"Word", "Rank"};
		Object [][] data = new Object[map.size()][2];
		System.out.println("Window Made");
		int i =0;
		
		for(Map.Entry<String, Long>entry : map.entrySet()) {
			while(i != 20) {
				data[i][0] = entry.getKey();
				data[i][1] = entry.getValue();
			}
		}
		System.out.println("Window Made");
		JTable topTwenty = new JTable(data,colNames);
		topTwenty.setPreferredScrollableViewportSize(new Dimension(500, 50));
		topTwenty.setFillsViewportHeight(true);
		System.out.println("Window Made");
		return topTwenty;
	}
	
	public static void main(String[] args)  {
		/**
	     *This is the main function
		 */
		
		TextAnalyzer txt = new TextAnalyzer();
		
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
	 
	        System.out.println("title : " + title);
	        
	        List<String> pool = new ArrayList<String>();
	        while(token.hasMoreTokens()) {
	        	String t = token.nextToken();
	        	pool.add(t);
	        	count++;
	        }
	               
	       Map<String, Long> freq = Arrays.stream(pool.toString().split(" +|\n")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

	       newMap = valueSort(freq);
	       Iterator<Map.Entry<String, Long>> itr = newMap.entrySet().iterator();
	       Map.Entry<String, Long> entry = itr.next();
	      
	       table = txt.makeTable(newMap);
	       txt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       txt.setSize(600, 200);
	       txt.setVisible(true);
	       txt.setTitle("Java Table");
	        
	       while (itr.hasNext()) {
	    	   while (rank != 21) {
	    	   System.out.println("#"+ rank+": "+entry.getKey()+" "+entry.getValue());
	    	   entry = itr.next();
	    	   rank++;
	           }
	     }
	       
	}	
}

	
