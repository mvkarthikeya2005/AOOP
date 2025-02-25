package week6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class Movie implements Comparable<Movie> {
 private String name;
 private double rating;
 private int year;
 public Movie(String name, double rating, int year) {
 this.name = name;
 this.rating = rating;
 this.year = year;
 }
 public int compareTo(Movie other) {
 return Integer.compare(this.year, other.year);
 }
 @Override
 public String toString() {
 return "Movie{" +
 "name='" + name + '\'' +
 ", rating=" + rating +
 ", year=" + year +
 '}';
 }
}
public class MovieSorting {
 public static void main(String[] args) {
 List<Movie> movies = new ArrayList<>();
 movies.add(new Movie("Inception", 8.8, 2010));
 movies.add(new Movie("Interstellar", 8.6, 2014));
 movies.add(new Movie("The Shawshank Redemption", 9.3, 1994));
 movies.add(new Movie("The Godfather", 9.2, 1972));
 Collections.sort(movies);

 for (Movie movie : movies) {
 System.out.println(movie);
 }
 }
}