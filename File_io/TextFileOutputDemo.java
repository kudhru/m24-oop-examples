package File_io;

import java.io.* ;


public class TextFileOutputDemo
{
  public static void main(String[] args)
  {
	PrintWriter outStream = null;

	// OPEN the file here as in previous code
	 try { 
		outStream = 
			new PrintWriter(new FileOutputStream("stuff.txt"));
		outStream.println("The quick brown fox");
    	outStream.println("jumped over the lazy dog.");
	}
	catch (IOException e) {	System.err.println (e.getMessage());
	}

	finally  { // always close the file 
	    outStream.close( );
	}
  }
}

