package com.nikolaj.android.lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnYes = (Button) findViewById(R.id.btnYes);
        Button btnNo = (Button) findViewById(R.id.btnNo);
        btnYes.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                AsyncHttpClient client = new AsyncHttpClient();
                client.get("http://207.154.250.228/lab/java.php?command=yes", new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        if(responseBody != null){
                            TextView txtResponse = (TextView) findViewById(R.id.txtResponse);
                            assert txtResponse != null;
                            txtResponse.setText(new String(responseBody));
                        }
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                    }
                });


            }
        });
        btnNo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // view.setEnabled(false);
                AsyncHttpClient client = new AsyncHttpClient();
                client.get("http://207.154.250.228/lab/java.php?command=no", new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        if(responseBody != null){
                            TextView txtResponse = (TextView) findViewById(R.id.txtResponse);
                            assert txtResponse != null;
                            txtResponse.setText(new String(responseBody));
                        }
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                    }
                });


            }
        });

    }

}

