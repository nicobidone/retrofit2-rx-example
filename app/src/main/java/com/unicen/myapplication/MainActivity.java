package com.unicen.myapplication;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

import okhttp3.ResponseBody;
import rx.Subscriber;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Repository repository = Repository.getInstance();

        repository.makeReactiveQuery().subscribe(
                new Subscriber<ResponseBody>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        Log.d(TAG, "onChanged: this is a live data response!");
                        try {
                            Log.d(TAG, "onChanged: " + responseBody.string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
//        repository.makeReactiveQuery().subscribe(new Consumer<ResponseBody>() {
//            @Override
//            public void accept(ResponseBody responseBody) {
//                Log.d(TAG, "onChanged: this is a live data response!");
//                try {
//                    Log.d(TAG, "onChanged: " + responseBody.string());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//    });
    }
}
