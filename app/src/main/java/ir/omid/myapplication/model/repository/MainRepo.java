package ir.omid.myapplication.model.repository;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;

import ir.omid.myapplication.core.network.MyApi;
import ir.omid.myapplication.core.network.RetrofitClient;
import ir.omid.myapplication.model.dao.MarvelHeroDao;
import ir.omid.myapplication.model.dto.MarvelHeroDto;
import ir.omid.myapplication.model.entities.MarvelHeroEntity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainRepo {
    MyApi restApi;
    MarvelHeroDao dao;
    public MainRepo() {
        dao = new MarvelHeroDao();
        restApi = RetrofitClient.RetrofitClient();
    }


    public void getHeros(Callback<List<MarvelHeroDto>> callback) {
        List<MarvelHeroDto> items = dao.getAllData();
        if (items.size() > 0) {
            callback.onResponse(null, Response.success(items));
        }

        restApi.getHero().enqueue(new Callback<List<MarvelHeroDto>>() {
            @Override
            public void onResponse(Call<List<MarvelHeroDto>> call, Response<List<MarvelHeroDto>> response) {
                for (MarvelHeroDto item : response.body()) {
                    dao.createData(new MarvelHeroEntity(
                            item.name,
                            item.realName,
                            item.team,
                            item.imageUrl,
                            item.bio
                    ));
                }
                callback.onResponse(call,response);
            }

            @Override
            public void onFailure(Call<List<MarvelHeroDto>> call, Throwable t) {

            }
        });
    }


}
