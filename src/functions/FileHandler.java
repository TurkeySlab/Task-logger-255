package functions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class FileHandler {
	public String[][] populateTaskView()
	{
		/* TODO
		 * Given the file name "tasks.txt" read in the data that was saved from the last session
		 * 
		 * NOTE : reading in the file will be the inverse as writing it to the file
		 */
		
		return getFile();		// calls private method "getFile()"
	}
	
	public static void writeFile( String[][] data )
	{
		/* TODO
		 * Given the file name; create a new file and write the String value of what is stored in data[][]
		 * Store the file as <filename> + ".txt"

		 * Make sure every entry in data is written correctly 
		 * 
		 * NOTE  : data[row] 		will access the array in that row
		 * 		   data[0][0]		will hold the "header" vlaue : TODO check this
		 * 		   data[row][value]	will access the String value for that [row][value]
		 * 
		 * NOTE2 : This method is overloaded; writeFile( String[][] ) is used for calendar objects
		 * 
		 * NOTE3 : 
		 */
		
		String fileName = "tasks.txt";			// saved to working directory || folder where .jar was called from 

	}
	public static void writeFile( String fileName, String data )
	{
		/* TODO
		 * Given the file name; create a new file and write the String value of what is stored in data
		 * Store the file as <filename> + ".txt".
		 
		 * Make sure every entry in data is written correctly 
		 * 
		 * NOTE  : This method is used to save the contents of the "notePanel" 
		 * 
		 */
		PrintWriter writer;
		try {
			writer = new PrintWriter(fileName, "UTF-8");
			writer.append(data);
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static String getFile( String fileName )
	{
		StringBuilder sb = new StringBuilder();
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		    String everything = sb.toString();
		    br.close();
		} catch( Exception e) {
		    e.printStackTrace();
		}
		return sb.toString();
	}
	private static String[][] getFile()
	{
		/* TODO
		 * Read in the file "tasks.txt" and return its contents as String[][]
		 * 
		 * NOTE : overloaded, this method is for saved DailyTasks
		 */
		
		String fileName = "tasks.txt";		// saved to working directory || folder where .jar was called from 

		
		return null;
	}
}
