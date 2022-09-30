package Services;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Movies;
import org.json.JSONObject;

public class GetMovieService extends HttpServlet {

    private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String requestUrl = request.getRequestURI();
		String movieName = requestUrl.substring("/MoviesWeb/GetMovieService/".length());
		
		Movies movies = MoviesData.getInstance().getPerson(movieName);
		
		if(movies != null){
			String json = "{\n";
			json += "\"name\": " + JSONObject.quote(movies.getMovieName()) + ",\n";
			json += "\"type\": " + JSONObject.quote(movies.getMovieType()) + ",\n";
                        json += "\"time\": " + JSONObject.quote(movies.getMovieTime()) + ",\n";
                        json += "\"level\": " + JSONObject.quote(movies.getMovieLevel()) + ",\n";
                        json += "\"price\": " + JSONObject.quote(movies.getMoviePrice()) + ",\n";
			//json += "\"price\": " + movies.getMoviePrice() + "\n";
			json += "}";
			response.getOutputStream().println(json);
		}
		else{
			//That person wasn't found, so return an empty JSON object. We could also return an error.
			response.getOutputStream().println("{ERROR...}");
		}
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String movieName = request.getParameter("movieName");
		String movieType = request.getParameter("movieType");
                String movieTime = request.getParameter("movieTime");
                String movieLevel = request.getParameter("movieLevel");
                String moviePrice = request.getParameter("moviePrice");
		//int moviePrice = Integer.parseInt(request.getParameter("moviePrice"));
		
		MoviesData.getInstance().putPerson(new Movies(movieName, movieType, movieTime, movieLevel, moviePrice));
	}
}