/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Danai
 */
public class Movie {
    private String movieName;
    private String movieType;
    private String movieTime;
    private String movieLevel;
    private int moviePrice;

    public void setMovieLevel(String movieLevel) {
        this.movieLevel = movieLevel;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    public void setMovieTime(String movieTime) {
        this.movieTime = movieTime;
    }

    public void setMoviePrice(int moviePrice) {
        this.moviePrice = moviePrice;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getMovieType() {
        return movieType;
    }

    public String getMovieTime() {
        return movieTime;
    }

    public int getMoviePrice() {
        return moviePrice;
    }
    
    public String getMovieLevel() {
        return movieLevel;
    }
}
