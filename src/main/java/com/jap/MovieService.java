package com.jap;

import java.util.*;

public class MovieService {

    public Map<Movie,Integer> getMovieWithRating(){

        //create five movie object by calling Movie class parameterized constructor
        Movie movie1 = new Movie(101,"Baap Baap Hota Hai 1","comedy","12/01/1200");
        Movie movie2 = new Movie(106,"Baap Baap Hota Hai 2","comedy","1/11/1900");
        Movie movie3 = new Movie(107,"Baap Baap Hota Hai 3","comedy","12/10/8000");
        Movie movie4 = new Movie(108,"Baap Baap Hota Hai 4","comedy","5/06/1400");
        Movie movie5 = new Movie(110,"Baap Baap Hota Hai 5","comedy","4/8/1050");
        //create HashMap object and add all the Movie object inside it
        Map<Movie,Integer> movieMap = new HashMap();
        //Key will be movie object and value will be rating ranging from 1 to 5
        movieMap.put(movie1,5);
        movieMap.put(movie4,3);
        movieMap.put(movie5,5);
        movieMap.put(movie3,2);
        movieMap.put(movie2,4);
        //return the HashMap object
        Map map = new HashMap();

        return map;
    }

    public Set<String> getMovieNameWithRating4(Map<Movie,Integer> map,int rating){
        //Create a TreeSet object
        TreeSet<String> movieTreeSet = new TreeSet<>();

        //Use entrySet() method to iterate through the map object
        Set<Map.Entry<Movie, Integer>> entries = map.entrySet();
        for (Map.Entry<Movie, Integer> entry : map.entrySet()) {
            if(entry.getValue() == rating){
                movieTreeSet.add(entry.getKey().getMovieName());
            }
        }

        //retrieve all the movies name having rating as 4

        //Store the movie name in TreeSet object

        //return the TreeSet object

        return movieTreeSet;
    }

    public List<String> getMovieWithHighestRating(Map<Movie,Integer> map){
        //Create a ArrayList object of type String
        List<String> movieArrayList = new ArrayList();
        movieArrayList.add(map.entrySet().iterator().next().getKey().getMovieName());

        //get the first value from the map and store it in the variable max

        // Use entrySet().iterator().next() method to retrieve the first value of Map object
        int max = map.entrySet().iterator().next().getValue();
        for(Map.Entry<Movie,Integer> entry : map.entrySet()){

            if(entry.getValue() > max){
                movieArrayList.set(0,entry.getKey().getMovieName());
            }
        }

        //get the name of the movie with the highest rating and add it in the List created

        //return the List object
        return movieArrayList;
    }
    public Map<String,String> getAllMoviesWithComedy(Map<Movie,Integer> map){
        //Create a Map object
        Map<String,String > map1 = new HashMap();
        //use entrySet to iterate through the Map object
        for (Map.Entry<Movie, Integer> entry : map.entrySet()) {
            //get all the movies name and their released date for the movie of genre "comedy"
            if(entry.getKey().getGenre().equalsIgnoreCase("comedy")){
                map1.put(entry.getKey().getMovieName(),entry.getKey().getReleaseDate());
            }
        }
        //store movie name with release date in the above created Map object and return the Map object
        return map1;

    }

    public static void main(String[] args) {
        MovieService movieService = new MovieService();
        Map <Movie,Integer> map = movieService.getMovieWithRating();
        Set set = movieService.getMovieNameWithRating4(map,4);
        System.out.println("Rating 4" + set);
        Map map1 = movieService.getAllMoviesWithComedy(map);
        System.out.println("Comedy Movie " + map1);
        List list = movieService.getMovieWithHighestRating((Map<Movie, Integer>) map);
        System.out.println("--------------");
        System.out.println("Highest Rating " +list);
    }
}
