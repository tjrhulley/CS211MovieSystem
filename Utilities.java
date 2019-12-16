import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Utilities {

    public static void writeToFile(List data, String path){

        try {

            Path file = Paths.get(path);
            Files.write(file, (Iterable<? extends CharSequence>) data, StandardCharsets.UTF_8);
            //Files.write(file, lines, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void writeToFile(String data) {

        Path file = Paths.get("/Users/sarashabon/Desktop/room.txt");
        try {
            Files.write(file, Collections.singleton(data), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    public static void writeMovieToFile(List data){

        try {

            Path file = Paths.get("movies.txt");
            Files.write(file, (Iterable<? extends CharSequence>) data, StandardCharsets.UTF_8);
            //Files.write(file, lines, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    public static void writeEmployeeToFile(List data){

        try {

            Path file = Paths.get("/Users/sarashabon/Desktop/employeeList.txt");
            Files.write(file, (Iterable<? extends CharSequence>) data, StandardCharsets.UTF_8);
            //Files.write(file, lines, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static String readFile(String path){
    	
    	StringBuilder contentBuilder = new StringBuilder();
	    try (BufferedReader br = new BufferedReader(new FileReader(path))) {
	 
	        String sCurrentLine;
	        while ((sCurrentLine = br.readLine()) != null) {
	        	contentBuilder.append(sCurrentLine).append("\n");
	        	
	      	}
	    }
   
	    catch (IOException e) {
	        e.printStackTrace();
	    }
	    //System.out.println(contentBuilder.toString());
	    return contentBuilder.toString();
	}
}
