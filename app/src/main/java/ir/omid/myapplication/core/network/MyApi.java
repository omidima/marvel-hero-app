package ir.omid.myapplication.core.network;

import java.util.List;

import ir.omid.myapplication.model.dto.MarvelHeroDto;
import retrofit2.Call;
import retrofit2.http.GET;

public interface MyApi {

    @GET("marvel")
    Call<List<MarvelHeroDto>> getHero();
}
