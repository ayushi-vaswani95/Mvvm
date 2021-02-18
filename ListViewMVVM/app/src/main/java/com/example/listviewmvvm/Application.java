package com.example.listviewmvvm;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class Application extends android.app.Application {

    final String TAG = getClass().getSimpleName();
    private static Application mInstance;
    private static Retrofit retrofit = null;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static synchronized Application getInstance()
    {
      return mInstance;
    }


public static Retrofit getRetrofit()
{
    if (retrofit == null) {
        okhttp3.OkHttpClient client = new okhttp3.OkHttpClient.Builder().build();

        retrofit = new Retrofit.Builder()
                .client(client)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .build();
    }
    return retrofit;
}
}
