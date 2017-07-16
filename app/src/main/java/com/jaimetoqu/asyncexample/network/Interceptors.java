package com.jaimetoqu.asyncexample.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jaime on 3/22/17.
 */

public class Interceptors {

    private static final String BASE_URL = "https://www.mindicador.cl/";

    public Miindicador getBasic() {
        Retrofit interceptor = new Retrofit.Builder()
                .baseUrl(BASE_URL)
            /*Never forget about adding the converter, otherwise you can not parse the data*/
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Miindicador someRequest = interceptor.create(Miindicador.class);
        return someRequest;
    }
}
