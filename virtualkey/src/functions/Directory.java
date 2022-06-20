package functions;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;


public class Directory {
	
public static final String name = "src\\virtualKeyFiles\\Files\\";
	
	ArrayList<File> files = new ArrayList<File>();
	
	File DirFiles = new File(name);
	
	public String getName() {
        return name;
    }
    
	public void print() {
    	System.out.println("Existing Files: ");
    	for (File f : files)  {
            System.out.println(f);
    	}
    }

    public ArrayList<File> fillFiles() {
    	
        File[] directoryFiles = DirFiles.listFiles();
        
    	files.clear();
    	for (int i = 0; i < directoryFiles.length; i++) {
    		if (directoryFiles[i].isFile()) {
    			files.add(directoryFiles[i]);
    		}
    	}
    	
    	Collections.sort(files);
    	
    	return files;
    }

    public ArrayList<File> getFiles() {
    	
    	fillFiles();
    	return files;
    }
    
    
    public void mergeSort() {
    	
    }

}
