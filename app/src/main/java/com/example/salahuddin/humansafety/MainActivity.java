package com.example.salahuddin.humansafety;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.slahTextViewId);
        imageView = (ImageView) findViewById(R.id.slashScreenLogoId);


        Animation myAnimation = AnimationUtils.loadAnimation(this,R.anim.mytransition);

        textView.setAnimation(myAnimation);
        imageView.setAnimation(myAnimation);

        final Intent intent = new Intent(this,LoginActivity.class);

        Thread timer = new Thread(){

            public void run(){
                try{
                    sleep(2000);
                }catch (Exception e){
                    e.printStackTrace();
                }finally {

                    startActivity(intent);
                    finish();
                }
            }
        };
        timer.start();

    }
}
