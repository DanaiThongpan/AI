/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

/**
 *
 * @author Danai
 */
import java.util.HashMap;
import java.util.Map;
import model.Movies;

/**
 * Example DataStore class that provides access to user data.
 * Pretend this class accesses a database.
 */
public class MoviesData {

	//Map of names to Person instances.
	private final Map<String, Movies> movieMap = new HashMap<>();
	
	//this class is a singleton and should not be instantiated directly!
	private static final MoviesData instance = new MoviesData();
	public static MoviesData getInstance(){
		return instance;
	}

	//private constructor so people know to use the getInstance() function instead
	private MoviesData(){
		//dummy data
                movieMap.put("Seobok", new Movies("Seobok", "Action movie", "no","a","200"));
                movieMap.put("Paracite", new Movies("Paracite", "Adventure movie", "no","b" ,"200"));
                movieMap.put("LittleForest", new Movies("Little Forest", "Drama movie", "no","c","200"));
	}

	public Movies getPerson(String movieName) {
		return movieMap.get(movieName);
	}

	public void putPerson(Movies movies) {
		movieMap.put(movies.getName(), movies);
	}
}