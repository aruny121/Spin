package com.example.arunyadav.wheelrotation.Retrofit;

import com.example.arunyadav.wheelrotation.Model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    String BASE_URL = "USE_YOUR_OWN_API";

    @GET("api_tag")
    Call<List<User>> getSpeed();

    //crash will be thrown since i comented out the api link for security reason .. you must
    // use our own api and app will work smoothly
}
