package ir.omid.myapplication.logic.main;

import java.util.List;

import ir.omid.myapplication.model.dto.MarvelHeroDto;

public class MainContract {
    public interface View {
        void loading(boolean isLoading);
        void updateList(List<MarvelHeroDto> items);
        void goToPage(MarvelHeroDto item);
    }

    public interface Presenter{
        void getHeros();
        void goToPage(MarvelHeroDto item);
    }
}
