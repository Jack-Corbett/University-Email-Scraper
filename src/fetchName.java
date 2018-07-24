import java.io.*;
import java.net.*;

public class fetchName {
	
	public static void main(String[] args) throws Exception {
		String address;
		String id = new String();
		String name = new String();
		
		System.out.println("Enter the user id you are looking for: ");
		
		//Take the input of the id from the user
		BufferedReader systemIn = new BufferedReader(new InputStreamReader(System.in));
		id = systemIn.readLine();
		
		//Create the URL
		address = "http://www.ecs.soton.ac.uk/people/"+id;
		
		//Convert the address from a string to a URL
		URL url = new URL(address);
		
		//Connects to the site and starts the input stream
	    	URLConnection urlConnection = url.openConnection();
	    	BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        
		String str;
		//We are looking for the title tag as this is followed by the name
		String search = "<title>";
		//Store position pointers of the name
		Integer nameStart;
		Integer nameEnd;
		//Boolean flag when name found stop searching the file
		Boolean found = false;

		while (((str = in.readLine()) != null) & !found) {
		    str.toString();
		    //Check it that line has the title tag
		    if (str.toLowerCase().contains(search.toLowerCase())) {
				//Find the name and save it
			nameStart = str.indexOf('>') + 1;
				nameEnd = str.indexOf('|') - 1;
				name = str.substring(nameStart, nameEnd);
				//Trigger found flag
				found = true;
		    }
		}
		in.close();

		System.out.println("The name of this user is: " + name);
	}
}
