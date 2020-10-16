package interfaces;
import java.lang.*;
import entity.*;

public interface IMovieRepo
{
	MovieE getMovie(String MovieName);
	public void insertMovie(MovieE v);
	public void updateMovie(MovieE v);
	public void deleteMovie(String MovieName);
}