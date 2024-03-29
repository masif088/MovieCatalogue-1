package com.himasif.myf.favouritemovies;

import android.graphics.Color;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    public static final String POSTER_URL_W500 = "http://image.tmdb.org/t/p/w500"; // image for details
    public static final String EXTRA_MOVIE = "extra_movie";
    private Movie movie;
    @BindView(R.id.img_poster_detail)
    ImageView imgPoster;
    @BindView(R.id.tv_title_detail)
    TextView tvTitle;
    @BindView(R.id.tv_rating_detail)
    TextView tvRating;
    @BindView(R.id.tv_releaseDate_detail)
    TextView tvReleaseDate;
    @BindView(R.id.tv_orilang_detail)
    TextView tvOriLang;
    @BindView(R.id.tv_overview_detail)
    TextView tvOverview;
    @BindView(R.id.collapsing_toolbar_detail)
    CollapsingToolbarLayout collapsingToolbarLayout;
    @BindView(R.id.toolbar)
    android.support.v7.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        movie = (Movie) getIntent().getSerializableExtra(EXTRA_MOVIE);

        setAll();
    }

    private void setAll() {
        Glide.with(this)
                .load(POSTER_URL_W500 + movie.getPosterPath())
                .fitCenter()
                .into(imgPoster);
        collapsingToolbarLayout.setTitle(movie.getTitle());
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.parseColor("#ffffff"));
        tvTitle.setText(movie.getTitle());
        tvRating.setText(tvRating.getText().toString() + " " + movie.getVoteAvg());
        tvReleaseDate.setText(tvReleaseDate.getText().toString() + " " + movie.getReleaseDate());
        tvOriLang.setText(tvOriLang.getText().toString() + " " + movie.getOriginalLanguage());
        tvOverview.setText(movie.getOverview());
    }
}
