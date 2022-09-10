package ir.omid.myapplication.presentation.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import ir.omid.myapplication.R;
import ir.omid.myapplication.core.database.AppDatabase;
import ir.omid.myapplication.logic.main.MainContract;
import ir.omid.myapplication.logic.main.MainPresenter;
import ir.omid.myapplication.model.dto.MarvelHeroDto;
import ir.omid.myapplication.model.entities.UserEntity;
import ir.omid.myapplication.presentation.adapter.MarvelAdapter;

public class MainActivity extends AppCompatActivity implements MainContract.View, View.OnClickListener {

    MainPresenter presenter;
    RecyclerView list;
    public static AppDatabase db;
    MarvelAdapter adapter = new MarvelAdapter(new ArrayList<MarvelHeroDto>(), new MarvelAdapter.Actions() {
        @Override
        public void onClick(MarvelHeroDto item) {
            Log.i("TAG", "onClick: ");
            presenter.goToPage(item);
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new AppDatabase(this);

        setContentView(R.layout.activity_main);
        list =findViewById(R.id.list);
        presenter = new MainPresenter(this);
        findViewById(R.id.button).setOnClickListener(this);
        list.setAdapter(adapter);
        list.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button){
            presenter.getHeros();
        }
    }

    @Override
    public void loading(boolean isLoading) {

    }

    @Override
    public void updateList(List<MarvelHeroDto> items) {
        adapter.updateAdapter(items);
        findViewById(R.id.button).setVisibility(View.GONE);
    }

    @Override
    public void goToPage(MarvelHeroDto item) {
        Intent intent = new Intent(this, MovieDetails.class);
        intent.putExtra("name",item.name);
        intent.putExtra("bio",item.bio);
        intent.putExtra("imageurl",item.imageUrl);
        startActivity(intent);
    }
}