package com.example.flixster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class movie {
    String backdrop_path;
    String posterPath;
    String title;
    String overView;

    public movie(JSONObject jsonObject) throws JSONException {
        posterPath = jsonObject.getString("poster_path");
        backdrop_path = jsonObject.getString("backdrop_path");
        title = jsonObject.getString("title");
        overView = jsonObject.getString("overview");

    }
    public static List<movie> fromJasonArray(JSONArray movieJsonArray) throws JSONException {
        List<movie> movies = new ArrayList<>();
        for(int i = 0; i < movieJsonArray.length(); i++){
            movies.add(new movie(movieJsonArray.getJSONObject(i)));
        }
        return  movies;
    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }
    public  String getBackdrop_path(){
        return String.format("https://image.tmdb.org/t/p/w342/%s", backdrop_path);
    }

    public String getTitle() {
        return title;
    }

    public String getOverView() {
        return overView;
    }
}
