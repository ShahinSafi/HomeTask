package com.cyberwith.hometask.network;

import com.cyberwith.hometask.models.Report;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("home_page.php")
    Call<Report> getReport();
}
