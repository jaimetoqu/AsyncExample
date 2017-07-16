package com.jaimetoqu.asyncexample;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.jaimetoqu.asyncexample.models.Wrapper;
import com.jaimetoqu.asyncexample.network.GetUfByDate;
import com.jaimetoqu.asyncexample.network.Interceptors;
import com.jaimetoqu.asyncexample.network.Miindicador;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //counter();
                //new Counter().execute(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
                Miindicador miindicador = new Interceptors().getBasic();
                Call<Wrapper> call = miindicador.base();
                call.enqueue(new Callback<Wrapper>() {
                    @Override
                    public void onResponse(Call<Wrapper> call, Response<Wrapper> response) {
                        int code = response.code();
                        if (200 == code && response.isSuccessful()) {
                            Wrapper wrapper = response.body();
                            Toast.makeText(MainActivity.this, String.valueOf(wrapper.getUf().getValor()), Toast.LENGTH_SHORT).show();
                        } else {
                            Log.d("PASO", "OTRA COSA");
                        }
                    }

                    @Override
                    public void onFailure(Call<Wrapper> call, Throwable t) {
                        Log.d("FALLO", "FALLO");
                    }
                });
                new BackgroundUf().execute("19-03-2017");
            }
        });
    }

    private void counter() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d("MAIN", String.valueOf(count));
                count++;
                if (count < 11) {
                    counter();
                }
            }
        }, 1000);
    }

    private class Counter extends AsyncCount {

        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressDialog.setMax(10);
            progressDialog.show();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            Log.d("BACKGROUNG", String.valueOf(values));
            progressDialog.setProgress(values[10]);
        }

        @Override
        protected void onPostExecute(String s) {
            progressDialog.dismiss();
            Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
        }


    }

    private class BackgroundUf extends GetUfByDate {

        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.show();
        }

        @Override
        protected void onPostExecute(Wrapper wrapper) {
            super.onPostExecute(wrapper);
            if (wrapper != null) {
                TextView textView = (TextView) findViewById(R.id.textView);
                textView.setText(String.valueOf(wrapper.getSerie()[0].getValor()));
            }
            progressDialog.dismiss();
        }
    }

}
