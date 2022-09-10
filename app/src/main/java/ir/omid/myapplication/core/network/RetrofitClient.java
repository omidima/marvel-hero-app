package ir.omid.myapplication.core.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    public final static String BASE_URL = "https://simplifiedcoding.net/demos/";

    public static MyApi RetrofitClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(MyApi.class);
    }
}
