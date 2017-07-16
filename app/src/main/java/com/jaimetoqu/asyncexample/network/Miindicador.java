package com.jaimetoqu.asyncexample.network;

import com.jaimetoqu.asyncexample.models.Wrapper;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by jaime on 3/22/17.
 */

public interface Miindicador {

    @GET("api")
    Call<Wrapper> base();

    @GET("api/uf/{date}")
    Call<Wrapper> ufByDate(@Path("date") String date);
}
