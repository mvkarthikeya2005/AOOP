package main;

import java.util.*;

//Movie class representing each movie object
class Movie {
 private double rating;
 private String name;
 private int year;

 public Movie(double rating, String name, int year) {
     this.rating = rating;
     this.name = name;
     this.year = year;
 }

 public double getRating() {
     return rating;
 }

 public String getName() {
     return name;
 }

 public int getYear() {
     return year;
 }

 @Override
 public String toString() {
     return rating + " " + name + " " + year;
 }
}

//Comparator to sort by rating
class RatingComparator implements Comparator<Movie> {
 @Override
 public int compare(Movie m1, Movie m2) {
     return Double.compare(m1.getRating(), m2.getRating());
 }
}

//Comparator to sort by name
class NameComparator implements Comparator<Movie> {
 @Override
 public int compare(Movie m1, Movie m2) {
     return m1.getName().compareTo(m2.getName());
 }
}

//Comparator to sort by year
class YearComparator implements Comparator<Movie> {
 @Override
 public int compare(Movie m1, Movie m2) {
     return Integer.compare(m1.getYear(), m2.getYear());
 }
}

//Main class to demonstrate sorting
public class MovieComparatorApp {
 public static void main(String[] args) {
     // Sample movie list
     List<Movie> movies = new ArrayList<>();
     movies.add(new Movie(8.4, "Return of the Jedi", 1983));
     movies.add(new Movie(8.8, "Empire Strikes Back", 1980));
     movies.add(new Movie(8.3, "Force Awakens", 2015));
     movies.add(new Movie(8.7, "Star Wars", 1977));

     // Sorting by rating
     Collections.sort(movies, new RatingComparator());
     System.out.println("Sorted by rating:");
     for (Movie movie : movies) {
         System.out.println(movie);
     }

     // Sorting by name
     Collections.sort(movies, new NameComparator());
     System.out.println("\nSorted by name:");
     for (Movie movie : movies) {
         System.out.println(movie.getName() + " " + movie.getRating() + " " + movie.getYear());
     }

     // Sorting by year
     Collections.sort(movies, new YearComparator());
     System.out.println("\nSorted by year:");
     for (Movie movie : movies) {
         System.out.println(movie.getYear() + " " + movie.getRating() + " " + movie.getName());
     }
 }
}

