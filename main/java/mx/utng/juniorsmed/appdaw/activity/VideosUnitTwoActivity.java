package mx.utng.juniorsmed.appdaw.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import mx.utng.juniorsmed.appdaw.VideoAdapter;
import mx.utng.juniorsmed.appdaw.YouTubeVideos;

import java.util.Vector;

public class VideosUnitTwoActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Vector<YouTubeVideos> youtubeVideos = new Vector<YouTubeVideos>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mx.utng.juniorsmed.appdaw.R.layout.activity_videos_unit_one);

        recyclerView = (RecyclerView) findViewById(mx.utng.juniorsmed.appdaw.R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));
        youtubeVideos.add( new YouTubeVideos("Ejercicio Ruby","<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/rQGS94s4fzg\" frameborder=\"0\" allowfullscreen></iframe>", "Promedio de números") );
        youtubeVideos.add( new YouTubeVideos("Método Ruby","<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/vU9mpb0hFZY\" frameborder=\"0\" allowfullscreen></iframe>", "Ejercicio con Initialize") );
        VideoAdapter videoAdapter = new VideoAdapter(youtubeVideos);
        recyclerView.setAdapter(videoAdapter);
    }
}
