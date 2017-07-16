package com.jaimetoqu.asyncexample.network;

import android.os.AsyncTask;

import com.jaimetoqu.asyncexample.models.Wrapper;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by jaime on 3/22/17.
 */

public class GetUfByDate extends AsyncTask<String, Void, Wrapper> {

    @Override
    protected Wrapper doInBackground(String... strings) {
        Miindicador miindicador = new Interceptors().getBasic();
        Call<Wrapper> call = miindicador.ufByDate(strings[0]);
        try {
            Response<Wrapper> response = call.execute();
            if (200 == response.code() && response.isSuccessful()) {
                return response.body();
            } else {
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
