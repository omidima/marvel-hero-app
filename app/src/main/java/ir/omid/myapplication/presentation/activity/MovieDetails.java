package ir.omid.myapplication.presentation.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import ir.omid.myapplication.R;
import ir.omid.myapplication.databinding.ActivityMovieDetailsBinding;
import ir.omid.myapplication.model.dto.MarvelHeroDto;

public class MovieDetails extends AppCompatActivity {

    ActivityMovieDetailsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil
                .inflate(
                        getLayoutInflater(),
                        R.layout.activity_movie_details,
                        null,
                        false);

        Bundle data = getIntent().getExtras();
        binding.setHero(new MarvelHeroDto(
                data.getString("name"),
                null,
                null,
                data.getString("imageurl"),
                data.getString("bio")
        ));

        binding.image.setScaleType(ImageView.ScaleType.CENTER);
        Glide.with(this).load(data.getString("imageurl")).into(binding.image);

        setContentView(binding.getRoot());
    }
}