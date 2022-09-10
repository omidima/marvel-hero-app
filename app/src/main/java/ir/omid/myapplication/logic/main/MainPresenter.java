package ir.omid.myapplication.logic.main;

import java.util.List;

import ir.omid.myapplication.model.dto.MarvelHeroDto;
import ir.omid.myapplication.model.repository.MainRepo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements MainContract.Presenter{
    private MainRepo repo =new MainRepo();
    public MainContract.View view;
    public MainPresenter(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void getHeros() {
        repo.getHeros(new Callback<List<MarvelHeroDto>>() {
            @Override
            public void onResponse(Call<List<MarvelHeroDto>> call, Response<List<MarvelHeroDto>> response) {
                view.updateList(response.body());
            }

            @Override
            public void onFailure(Call<List<MarvelHeroDto>> call, Throwable t) {

            }
        });
    }

    @Override
    public void goToPage(MarvelHeroDto item) {
        view.goToPage(item);
    }
}
