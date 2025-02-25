package Movie;

//File: src/Prog.java
import java.util.*;

public class Prog {
 public static void main(String[] args) {
     // Create a list of Movie objects
     List<Movie> movies = new ArrayList<>();
     movies.add(new Movie(8.5, "Inception", 2010));
     movies.add(new Movie(9.0, "The Dark Knight", 2008));
     movies.add(new Movie(7.8, "Interstellar", 2014));
     movies.add(new Movie(8.2, "The Prestige", 2006));
     movies.add(new Movie(9.8, "The Bahubali 2", 2018));

     // Display before sorting
     System.out.println("Before sorting by year:");
     for (Movie movie : movies) {
         System.out.println(movie);
     }

     // Sort the movies by year using Comparable
     Collections.sort(movies);

     // Display after sorting
     System.out.println("\nAfter sorting by year:");
     for (Movie movie : movies) {
         System.out.println(movie);
     }
 }
}

