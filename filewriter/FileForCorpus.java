package filewriter;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
/*
 * Author: Santosh Rayala
 * Create a new object of FileWriter to create a new file and use its addString method to add data to the file.
 * New object takes the path of the file as a parameter
*/

public class FileForCorpus {
	
	Writer writer = null;
	public FileForCorpus(String path)
	{
		try {
			writer = new BufferedWriter(new OutputStreamWriter(
			          new FileOutputStream(path), "utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addString(String line)
	{
		try {
			writer.write(line+"\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void close()
	{
		try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
