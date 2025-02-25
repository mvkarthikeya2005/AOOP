package Movie;

//File: src/Movie.java
public class Movie implements Comparable<Movie> {
 private double rating;
 private String name;
 private int year;

 // Constructor
 public Movie(double rating, String name, int year) {
     this.rating = rating;
     this.name = name;
     this.year = year;
 }

 // Getters
 public double getRating() { return rating; }
 public String getName() { return name; }
 public int getYear() { return year; }

 // Override compareTo() to sort by year
 @Override
 public int compareTo(Movie other) {
     return Integer.compare(this.year, other.year);
 }

 // Override toString() for display
 @Override
 public String toString() {
     return name + " (" + year + ") - Rating: " + rating;
 }
}

