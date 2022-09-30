/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Movie;

/**
 *
 * @author Danai
 */
public class AddNewMovie extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try {
            HttpSession session = request.getSession();
            Movie movie = (Movie) session.getAttribute("movie");
        // รับข้อมูลครั้งแรกจาก addNewCar.html
        
            if (movie == null) {
                String movieName = request.getParameter("movieName");
                String movieType = request.getParameter("movieType");
                String movie1 = request.getParameter("movie1");
                String movieTime[] = request.getParameterValues("movieTime");
                int moviePrice = Integer.parseInt(request.getParameter("moviePrice"));
                String movieTimes = "";
                for (String n : movieTime) {
                    movieTimes += n + " ";
                }
                movie = new Movie();
                movie.setMovieName(movieName);
                movie.setMovieType(movieType);
                movie.setMovieTime(movieTimes);
                movie.setMovie1(movie1);
                movie.setMoviePrice(moviePrice);
        
                session.setAttribute("movie", movie);
                out.println("<html><body><h1>ข้อมูล Movie<h1>");
                out.println("<form action='AddNewMovie'>");
                out.println("ชื่อเรื่อง : " + movie.getMovieName() + "<br/>");
                out.println("ประเภทหนังที่ชอบ : " + movie.getMovieType() + "<br/>");
                out.println("ช่วงเวลาที่ชอบดู : " + movie.getMovieTime() + "<br/>");
                out.println("ระดับความชอบ : " + movie.getMovie1() + "<br/>");
                out.println("ราคาตั๋วหนัง : " + movie.getMoviePrice() + "<br/>");
                out.println("<input type='submit' value='แก้ไข'>");
                out.println("</form></body></html>");
            } 
            // รับข้อมูลครั้งต่อมาจาก AddNewCar
            //
            else {
                // แสดงข้อมูล car เดิม
                out.println("<html><body><h1>แก้ไขข้อมูล Movie<h1>");
                out.println("<form action='AddNewMovie'>");
                out.println("ชื่อเรื่อง : <input type='text' name='movieName' value='"
                        + movie.getMovieName()+ "'>" + "<br/>");
                out.println("ประเภทหนังที่ชอบ : <input type='text' name='movieType' value='"
                        + movie.getMovieType() + "'>" + "<br/>");
                out.println("ช่วงเวลาที่ชอบดู : <input type='text' name='movieTime' value='"
                        + movie.getMovieTime() + "'>" + "<br/>");
                out.println("ระดับความชอบ : <input type='text' name='movie1' value='"
                        + movie.getMovie1() + "'>" + "<br/>");
                out.println("ราคาตั๋วหนัง : <input type='text' name='moviePrice' value='"
                        + movie.getMoviePrice() + "'>" + "<br/>");
                out.println("<input type='submit' value='แก้ไข'>");
                out.println("</form></body></html>");

                session.removeAttribute("movie");
            }

        } catch (Exception e) {
            //session.setAttribute("addNewMovie.jsp");
            response.sendRedirect("addNewMovieSuccess.jsp");
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
