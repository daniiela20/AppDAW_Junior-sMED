package mx.utng.juniorsmed.appdaw.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import mx.utng.juniorsmed.appdaw.VideoAdapter;
import mx.utng.juniorsmed.appdaw.YouTubeVideos;

import java.util.Vector;

public class VideosUnitThreeActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Vector<YouTubeVideos> youtubeVideos = new Vector<YouTubeVideos>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mx.utng.juniorsmed.appdaw.R.layout.activity_videos_unit_one);

        recyclerView = (RecyclerView) findViewById(mx.utng.juniorsmed.appdaw.R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));
        youtubeVideos.add( new YouTubeVideos("Crear Proyecto con Ruby","<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/2rammIT1Yk4\" frameborder=\"0\" allowfullscreen></iframe>", "Pasos para su creación") );
        youtubeVideos.add( new YouTubeVideos("Arreglos","<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/51Vc-2h09Dw\" frameborder=\"0\" allowfullscreen></iframe>", "Ejercicio con Arreglos") );
        VideoAdapter videoAdapter = new VideoAdapter(youtubeVideos);
        recyclerView.setAdapter(videoAdapter);
    }
}
