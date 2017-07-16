package com.jaimetoqu.asyncexample;

import android.os.AsyncTask;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by jaime on 3/22/17.
 */

public class AsyncCount extends AsyncTask<Integer, Integer, String> {

    @Override
    protected String doInBackground(Integer... integers) {
        for (int number : integers) {
            publishProgress(number);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        return "termino";
    }
}
