import java.awt.Component;
import java.io.*;


import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class FileHandler {
	
	private File thisFile;
	private Component parent;
	
	
	public FileHandler(Component c){
		parent = c;
	}
	
	public String getFileTitle(){
		return thisFile.getName();
	}
	
	private byte[] openFile(String filePath){
		try(DataInputStream reader = new DataInputStream 
					(new BufferedInputStream(new FileInputStream(new File(filePath))))){
			
			
			byte[] newByteList = new byte[reader.available()];
			
			for(int i = 0; reader.available()>0; i++)
				newByteList[i] = reader.readByte();
			
			
			return newByteList;
		
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
			
		return null;
	}

	public String readAll(File newFile){
		String fileContents;
		thisFile = newFile;
		
		try{
			BufferedReader reader = new BufferedReader(new FileReader(thisFile));
			
			fileContents = reader.readLine();
			
			reader.close();
			
			return fileContents;
		
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
			
		
		return null;	
		
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
	
    public void saveFileAs(String fileContents){
		
    	fileChooser.showSaveDialog(parent);
    	thisFile = fileChooser.getSelectedFile();
    	
    	saveFile(fileContents);
    	
	}
	
}
