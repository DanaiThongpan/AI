/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package newaaa;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

/**
 *
 * @author Danai
 */
public class ShowMovieFromREST extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String movieName = request.getParameter("movieName");
        PrintWriter out = response.getWriter();
        HttpURLConnection Connection = (HttpURLConnection) new URL("http://localhost:8080/MoviesWeb/GetMovieService/" + movieName).openConnection();
        Connection.setRequestMethod("GET");
        int responseCode = Connection.getResponseCode();
        if (responseCode == 200) {
            String json = "";
            Scanner scanner = new Scanner(Connection.getInputStream());
                while (scanner.hasNextLine()) {
                    json += scanner.nextLine();
                    json += "\n";
            }
                out.println(json + "<br/>");
                out.println("<br/>");
                JSONObject jsonObject = new JSONObject(json);
                String name = jsonObject.getString("name");
                String type = jsonObject.getString("type");
                String time = jsonObject.getString("time");
                String level = jsonObject.getString("level");
                String price = jsonObject.getString("price");
                out.println("Movie from REST"+"<br/>");
                out.println("name:" + name + "<br/>");
                out.println("type:" + type + "<br/>");
                out.println("time:" + time + "<br/>");  
                out.println("level:" + level + "<br/>");  
                out.println("price:" + price + "<br/>");  
        }else{
            out.println("ERROR....");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
