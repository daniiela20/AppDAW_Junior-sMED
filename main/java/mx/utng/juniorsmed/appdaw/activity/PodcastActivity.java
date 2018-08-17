package mx.utng.juniorsmed.appdaw.activity;

import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

public class PodcastActivity extends AppCompatActivity {
    private Button audioOne, audioTwo, audioThree, audioFour, audioFive;
    private MediaPlayer one, two, three, four, five;
    private SeekBar seekBar, seekBarTwo, seekBarThree, seekBarFour, seekBarFive;
    private Handler handler;
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mx.utng.juniorsmed.appdaw.R.layout.activity_podcast);

        audioOne = (Button)findViewById(mx.utng.juniorsmed.appdaw.R.id.btn_play_one);
        audioTwo = (Button)findViewById(mx.utng.juniorsmed.appdaw.R.id.btn_play_two);
        audioThree = (Button)findViewById(mx.utng.juniorsmed.appdaw.R.id.btn_play_three);
        audioFour = (Button)findViewById(mx.utng.juniorsmed.appdaw.R.id.btn_play_four);
        audioFive = (Button)findViewById(mx.utng.juniorsmed.appdaw.R.id.btn_play_five);
        seekBar = (SeekBar)findViewById(mx.utng.juniorsmed.appdaw.R.id.sb_one);
        seekBarTwo = (SeekBar)findViewById(mx.utng.juniorsmed.appdaw.R.id.sb_two);
        seekBarThree = (SeekBar)findViewById(mx.utng.juniorsmed.appdaw.R.id.sb_three);
        seekBarFour = (SeekBar)findViewById(mx.utng.juniorsmed.appdaw.R.id.sb_four);
        seekBarFive = (SeekBar)findViewById(mx.utng.juniorsmed.appdaw.R.id.sb_five);
        handler = new Handler();

        one = MediaPlayer.create(this, mx.utng.juniorsmed.appdaw.R.raw.ruby);
        two = MediaPlayer.create(this, mx.utng.juniorsmed.appdaw.R.raw.patrones);
        three = MediaPlayer.create(this, mx.utng.juniorsmed.appdaw.R.raw.tipos_app);
        four = MediaPlayer.create(this, mx.utng.juniorsmed.appdaw.R.raw.estructura);
        five = MediaPlayer.create(this, mx.utng.juniorsmed.appdaw.R.raw.ruby);

        one.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                seekBar.setMax(mediaPlayer.getDuration());
                changeSeekBar();
            }
        });

        two.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                seekBarTwo.setMax(mediaPlayer.getDuration());
                changeSeekBar();
            }
        });

        three.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                seekBarThree.setMax(mediaPlayer.getDuration());
                changeSeekBar();
            }
        });

        four.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                seekBarFour.setMax(mediaPlayer.getDuration());
                changeSeekBar();
            }
        });

        five.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                seekBarFive.setMax(mediaPlayer.getDuration());
                changeSeekBar();
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if(b){
                    one.seekTo(i);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarTwo.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if(b){
                    two.seekTo(i);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarThree.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if(b){
                    three.seekTo(i);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarFour.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if(b){
                    four.seekTo(i);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarFive.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if(b){
                    five.seekTo(i);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        audioOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){}
                if(one.isPlaying()){
                    one.pause();
                    audioOne.setBackgroundResource(mx.utng.juniorsmed.appdaw.R.drawable.ic_play);
                    Toast.makeText(PodcastActivity.this, "Pausa", Toast.LENGTH_SHORT).show();
                }else{
                    one.start();
                    audioOne.setBackgroundResource(mx.utng.juniorsmed.appdaw.R.drawable.ic_pause);
                    Toast.makeText(PodcastActivity.this, "Play", Toast.LENGTH_SHORT).show();
                    changeSeekBar();
                }
            }
        });

        audioTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(two.isPlaying()){
                    two.pause();
                    audioTwo.setBackgroundResource(mx.utng.juniorsmed.appdaw.R.drawable.ic_play);
                    Toast.makeText(PodcastActivity.this, "Pausa", Toast.LENGTH_SHORT).show();
                }else{
                    two.start();
                    audioTwo.setBackgroundResource(mx.utng.juniorsmed.appdaw.R.drawable.ic_pause);
                    Toast.makeText(PodcastActivity.this, "Play", Toast.LENGTH_SHORT).show();
                }
            }
        });

        audioThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){}
                if(three.isPlaying()){
                    three.pause();
                    audioThree.setBackgroundResource(mx.utng.juniorsmed.appdaw.R.drawable.ic_play);
                    Toast.makeText(PodcastActivity.this, "Pausa", Toast.LENGTH_SHORT).show();
                }else{
                    three.start();
                    audioThree.setBackgroundResource(mx.utng.juniorsmed.appdaw.R.drawable.ic_pause);
                    Toast.makeText(PodcastActivity.this, "Play", Toast.LENGTH_SHORT).show();
                    changeSeekBar();
                }
            }
        });

        audioFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){}
                if(four.isPlaying()){
                    four.pause();
                    audioFour.setBackgroundResource(mx.utng.juniorsmed.appdaw.R.drawable.ic_play);
                    Toast.makeText(PodcastActivity.this, "Pausa", Toast.LENGTH_SHORT).show();
                }else{
                    four.start();
                    audioFour.setBackgroundResource(mx.utng.juniorsmed.appdaw.R.drawable.ic_pause);
                    Toast.makeText(PodcastActivity.this, "Play", Toast.LENGTH_SHORT).show();
                    changeSeekBar();
                }
            }
        });

        audioFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){}
                if(five.isPlaying()){
                    five.pause();
                    audioFive.setBackgroundResource(mx.utng.juniorsmed.appdaw.R.drawable.ic_play);
                    Toast.makeText(PodcastActivity.this, "Pausa", Toast.LENGTH_SHORT).show();
                }else{
                    five.start();
                    audioFive.setBackgroundResource(mx.utng.juniorsmed.appdaw.R.drawable.ic_pause);
                    Toast.makeText(PodcastActivity.this, "Play", Toast.LENGTH_SHORT).show();
                    changeSeekBar();
                }
            }
        });
    }



    private void changeSeekBar() {
        seekBar.setProgress(one.getCurrentPosition());
        seekBarTwo.setProgress(two.getCurrentPosition());
        seekBarThree.setProgress(three.getCurrentPosition());
        seekBarFour.setProgress(four.getCurrentPosition());
        seekBarFive.setProgress(five.getCurrentPosition());

        if(one.isPlaying()){
            runnable = new Runnable() {
                @Override
                public void run() {
                    changeSeekBar();
                }
            };
            handler.postDelayed(runnable, 1000);
        }else if(two.isPlaying()){
            runnable = new Runnable() {
                @Override
                public void run() {
                    changeSeekBar();
                }
            };
            handler.postDelayed(runnable, 1000);
        }else if(three.isPlaying()) {
            runnable = new Runnable() {
                @Override
                public void run() {
                    changeSeekBar();
                }
            };
            handler.postDelayed(runnable, 1000);
        }else if (four.isPlaying()){
            runnable = new Runnable() {
                @Override
                public void run() {
                    changeSeekBar();
                }
            };
            handler.postDelayed(runnable, 1000);
        }else if(five.isPlaying()){
            runnable = new Runnable() {
                @Override
                public void run() {
                    changeSeekBar();
                }
            };
            handler.postDelayed(runnable, 1000);
        }
    }


    @Override
    protected void onDestroy(){
        super.onDestroy();
        if (one.isPlaying()){
            one.stop();
            one.release();
        }else if (two.isPlaying()){
            two.stop();
            two.release();
        }else if (three.isPlaying()){
            three.stop();
            three.release();
        }else if (four.isPlaying()) {
            four.stop();
            four.release();
        }else if (five.isPlaying()) {
            five.stop();
            five.release();
        }
    }


    @Override
    protected void onPause(){
        super.onPause();
        one.pause();
        two.pause();
        three.pause();
        four.pause();
        five.pause();
    }
}
