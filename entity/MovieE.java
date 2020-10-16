package entity;

import java.lang.*;

public class MovieE
{
	private String movieName;
	private String showtime;
	private double ticket;
	
	public MovieE(){}
	public MovieE(String movieName, String showtime, int ticket)
	{
		this.movieName = movieName;
		this.showtime = showtime;
		this.ticket = ticket;
	}
	
	public void setMovieName(String movieName){this.movieName = movieName;}
	public void setShowtime(String showtime){this.showtime = showtime;}
	public void setTicket(int ticket){this.ticket = ticket;}
	
	public String getMovieName(){return movieName;}
	public String getShowtime(){return showtime;}
	public double getTicket(){return ticket;}
}