package com.iet.lucknow.encore;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerButton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by abhishek on 24-09-2016.
 */
public class Notif extends Fragment {
    View v;TextView tv;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.notif,container,false);
        getActivity().setTitle("Notifications -");

        return v;
    }



    @Override
    public void onResume() {
        super.onResume();
        tv= (TextView) getView().findViewById(R.id.textView14);
        //tv.setVisibility(View.INVISIBLE);
        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        String s=sharedPref.getString("notif","No data , Press GET");
        tv.setText(s);

        ShimmerButton tv2=(ShimmerButton) getView().findViewById(R.id.button);
        Shimmer shimmer2 = new Shimmer();
        shimmer2.setDuration(2000);
        shimmer2.start(tv2);

        Button button = (Button)getView().findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(v.getContext(), "Fetching Data...Please Wait...", Toast.LENGTH_LONG).show();
                new LoadTextFileTask(tv).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "https://drive.google.com/uc?export=download&id=0B8XO8v084szyeG81LThCQ3RIdlE");

            }});
    }

    @Override
    public void onStop() {
        super.onStop();
        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("notif",tv.getText().toString());
        editor.commit();
    }


    class LoadTextFileTask extends AsyncTask<String, Void, String> {
        private TextView txtView;
        ProgressDialog dialog ;
        public LoadTextFileTask(TextView txtView) {
            this.txtView = txtView;
        }

        protected String doInBackground(String... urls) {
            String url = urls[0];
            //Log.d(TAG, "fetching: " + url);
            try {
                URL obj = new URL(url);
                HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                con.setRequestMethod("GET");
                con.setRequestProperty("User-Agent", "Mozilla/5.0");
                if (con.getResponseCode() != 200)
                    throw new IOException();
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null)
                {response.append(inputLine);response.append('\n');}
                in.close();
                return response.toString();
            } catch (IOException e) {
                e.printStackTrace();
                //Log.e(TAG, "error downloading file", e);
            }
            return null;
        }
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            // show progress dialog when downloading
            // dialog = ProgressDialog.show(, null, "Downloading...");
        }
        protected void onPostExecute(String text) {
            if (text != null) {
                txtView.setText(text);



            }
        }
}}
