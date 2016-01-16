import java.io.*;


public class FileHandler {
	
	private File thisFile;
	
	
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
	
	
	public <T> void write(T value){
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
	
	public <T> void writeAll(T fileContents){
		
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
	
	public <T> void writeAll(T fileContents, String fileName){
		
		thisFile = new File(fileName);
		
		writeAll(fileContents);
		
	}
	
	
}
