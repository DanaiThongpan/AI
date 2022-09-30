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
            
        // รับข้อมูลครั้งแรกจาก addNewMovie.html
            //
            if (movie == null) {
                String movieName = request.getParameter("movieName");
                String movieType = request.getParameter("movieType");
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
                movie.setMoviePrice(moviePrice);
        

                session.setAttribute("movie", movie);
                out.println("<html><body>");
                out.println("<form action='AddNewMovie'>");
                out.println("ชื่อเรื่อง : " + movie.getMovieName()
                        + "ประเภทหนังที่ชอบ : " + movie.getMovieType() 
                        + "ช่วงเวลาที่ชอบดู : " + movie.getMovieTime() 
                        + "ราคาตั๋วหนังตอนเข้าโรงภาพยนต์ : " + movie.getMoviePrice() 
                        + "<br/>");
                out.println("<input type='submit' value='แก้ไข'>");
                out.println("</form></body></html>");
            } 
            // รับข้อมูลครั้งต่อมาจาก AddNewMovie
            else {
                // แสดงข้อมูล Movie เดิม
                out.println("<form action='AddNewMovie'>");
                out.println("ชื่อเรื่อง: <input type='text' name='movieName' value='"
                        + movie.getMovieName()+ "'>");
                out.println("ประเภทหนังที่ชอบ: <input type='text' name='movieType' value='"
                        + movie.getMovieType() + "'>");
                out.println("ช่วงเวลาที่ชอบดู: <input type='text' name='movieTime' value='"
                        + movie.getMovieTime() + "'>");
                out.println("ราคาตั๋วหนังตอนเข้าโรงภาพยนต์: <input type='text' name='moviePrice' value='"
                        + movie.getMoviePrice() + "'>");
                out.println("<input type='submit' value='แก้ไข'>");
                out.println("</form></body></html>");

                session.removeAttribute("movie");
            }

        } catch (Exception e) {
            response.sendRedirect("error.html");
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
