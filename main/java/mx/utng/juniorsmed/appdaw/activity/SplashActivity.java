package mx.utng.juniorsmed.appdaw.activity;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import mx.utng.juniorsmed.appdaw.R;

public class SplashActivity extends AppCompatActivity {
    private ImageView imgSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        imgSplash = (ImageView) findViewById(R.id.img_splash);

        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.my_transition);
        imgSplash.startAnimation(myanim);
        final Intent i = new Intent (this, HomeActivity.class);
        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(2000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    startActivity(i);
                    finish();
                }
            }
        };
        timer.start();
    }
}