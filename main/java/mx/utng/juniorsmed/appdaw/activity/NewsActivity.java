package mx.utng.juniorsmed.appdaw.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import mx.utng.juniorsmed.appdaw.ReadRss;

public class NewsActivity extends AppCompatActivity implements
        View.OnClickListener
{
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mx.utng.juniorsmed.appdaw.R.layout.activity_news);
        recyclerView = (RecyclerView) findViewById(mx.utng.juniorsmed.appdaw.R.id.recyclerview);
        //Call Read rss asyntask to fetch rss
        ReadRss readRss = new ReadRss(this, recyclerView);
        readRss.execute();
    }

    public void onClick(View view){
        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (view.getId()){
            case mx.utng.juniorsmed.appdaw.R.id.thumb_img:
                Uri url = Uri.parse("http://www.rubyflow.com/");
                Intent intent = new Intent(Intent.ACTION_VIEW, url);
                startActivity(intent);
                break;

        }
    }

}