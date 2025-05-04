package Krish.src.Java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableExample {
    public static void main(String[] args) {
        List<Movie> l = new ArrayList<>();
        l.add(new Movie("Star Wars", 8.7, 1977));
        l.add(new Movie("Empire Strikes Back", 8.8, 1980));
        l.add(new Movie("Return of the Jedi", 8.4, 1983));

        //Sort movies using Comparable's compareTo method by year
        Collections.sort(l);

        System.out.println("Movies after sorting by year:");
        for (Movie m : l) {
            System.out.println(m.getName() + " " + m.getRating() + " " + m.getYear());
        }
    }

    static class Movie implements Comparable<Movie> {
        private String name;
        private double rating;
        private int year;

        public Movie(String name, double rating, int year) {
            this.name = name;
            this.rating = rating;
            this.year = year;
        }

        //Implementation of the compareTo method for default sorting by year
        public int compareTo(Movie m) {
            return this.year - m.year;
        }

        public String getName() {
            return name;
        }

        public double getRating() {
            return rating;
        }

        public int getYear() {
            return year;
        }
    }
}