
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class FileHandler {
	
	private File thisFile;
	
	public void getFile(){
		return thisFile;
	}
	
	public char read(){
			
		
		try{
			
			FileReader charReader = new FileReader(thisFile);
			
			char fileContents = (char) charReader.read();
			
			charReader.close();
			
			return fileContents;
		
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		return ' ';	
	}
	
	
	public void write(char value){
		try{
			PrintWriter writer = new PrintWriter(new FileWriter(thisFile));
			
			writer.print(value);
			
			writer.close();
			
		
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		
	}
	

	public String readAll(){
		try{
			BufferedReader reader = new BufferedReader(new FileReader(thisFile));
			
			String fileContents = reader.readLine();
			
			reader.close();
			
			return fileContents;
		
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		return null;	
	
	}
	
	
	public String readAll(String fileName){	
					
			thisFile = new File(fileName);
			
			return readAll();
	}
	
	public String readAll(File fileName){	
					
			thisFile = fileName;
			
			return readAll();
	}
	
	public void writeAll(String fileContents){
		
		try{
			PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(thisFile)));
			
			writer.println(fileContents);
			
			writer.close();
			
		
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		
	}
	
	public void writeAll(String fileContents, String fileName){
		
		thisFile = new File(fileName);
		
		writeAll(fileContents);
		
	}
	
	
}
