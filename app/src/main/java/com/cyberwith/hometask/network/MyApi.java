package com.cyberwith.hometask.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyApi {

    private static final String BASE_URL = "http://unionint.net/api/";

    private static ApiInterface apiInterface = null;

    public static ApiInterface getApiData(){
        if (apiInterface == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            apiInterface = retrofit.create(ApiInterface.class);
        }

        return apiInterface;
    }
}
