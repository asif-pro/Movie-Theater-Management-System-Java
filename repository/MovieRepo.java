package repository;
import java.lang.*;
import java.util.ArrayList;
import entity.*;
import interfaces.*;

public class MovieRepo implements IMovieRepo
{
	DatabaseConnection dbc;
	
	public MovieRepo()
	{
		dbc = new DatabaseConnection();
	}
	
	public void insertMovie(MovieE v)
	{
		String query = "INSERT INTO Movie VALUES ('"+v.getMovieName()+"','"+v.getShowtime()+"',"+v.getTicket()+");";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	
	public MovieE getMovie(String movieName)
	{
		MovieE mov = null;
		String query = "SELECT Stime, Ticket FROM Movie WHERE Mname='"+movieName+"';";
		try
		{
			System.out.println(query);
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				mov = new MovieE();
				mov.setMovieName(movieName);
				mov.setShowtime(dbc.result.getString("Stime"));
				mov.setTicket(dbc.result.getInt("Ticket"));
			}
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
		dbc.closeConnection();
		return mov;
	}
	public void updateMovie(MovieE v)
	{
		String query = "UPDATE Movie SET Stime='"+v.getShowtime()+"',Ticket = "+v.getTicket()+" WHERE Mname='"+v.getMovieName()+"'";
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public void deleteMovie(String MovieName)
	{
		String query = "DELETE from Movie WHERE MName ='"+MovieName+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
}