package com.chamalwr.mtopicnewsreader.functions;

import android.os.AsyncTask;
import android.util.Log;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadTask extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... apiUrls) {
        StringBuffer result = null;
        URL url;
        HttpURLConnection urlConnection = null;

        try {
            url = new URL(apiUrls[0]);
            urlConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = urlConnection.getInputStream();
            InputStreamReader streamReader = new InputStreamReader(inputStream);
            int data = streamReader.read();

            while(data != -1){
                char currentChar = (char) data;
                result.append(currentChar);
                data = streamReader.read();
            }

            return String.valueOf(result);

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Log.i("JSON NEWS" ,s);
    }



    public void getDataToAdapter(){

    }

}
