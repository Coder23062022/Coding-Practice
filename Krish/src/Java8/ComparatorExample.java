package Krish.src.Java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample {
    public static void main(String[] args) {
        List<Movie> m = new ArrayList<>();
        m.add(new Movie("Force Awakens", 8.3, 2015));
        m.add(new Movie("Star Wars", 8.7, 1977));
        m.add(new Movie("Empire Strikes Back", 8.8, 1980));

        // Sort movies by rating and display all
        m.sort(new Rating());
        System.out.println("Movies sorted by rating:");
        for (Movie m1 : m) {
            System.out.println(m1.getR() + " " + m1.getN() + " " + m1.getY());
        }

        // Sort movies by name and display all
        m.sort(new NameCompare());
        System.out.println("\nMovies sorted by name:");
        for (Movie m1 : m) {
            System.out.println(m1.getN() + " " + m1.getR() + " " + m1.getY());
        }
    }

    static class Movie {
        private String name;
        private double rating;
        private int year;

        public Movie(String name, double rating, int year) {
            this.name = name;
            this.rating = rating;
            this.year = year;
        }

        public String getN() {
            return name;
        }

        public double getR() {
            return rating;
        }

        public int getY() {
            return year;
        }
    }

    // Comparator to sort movies by rating
    static class Rating implements Comparator<Movie> {
        public int compare(Movie m1, Movie m2) {
            // Sort by rating in descending order
//            return Double.compare(m2.getR(), m1.getR());
            return Double.compare(m2.getR(), m1.getR());
        }
    }

    // Comparator to sort movies by name
    static class NameCompare implements Comparator<Movie> {
        public int compare(Movie m1, Movie m2) {
            // Sort by name in alphabetical order
            return m1.getN().compareTo(m2.getN());
        }
    }
}