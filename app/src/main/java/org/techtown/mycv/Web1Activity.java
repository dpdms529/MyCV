package org.techtown.mycv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.VideoView;

public class Web1Activity extends AppCompatActivity {
    ImageButton backBtn;
    Button gitBtn;
    VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web1);

        backBtn = findViewById(R.id.back_btn);
        gitBtn = findViewById(R.id.git_btn);
        video = findViewById(R.id.videoView);

        backBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                finish();
            }
        });

        gitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/dpdms529/IT_TIME"));
                startActivity(intent);
            }
        });

        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.ittime);
        video.setVideoURI(uri);
        video.setMediaController(new MediaController(this));
        video.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent){
                if(video.isPlaying()){
                    video.pause();
                    return false;
                }else{
                    video.start();
                    return false;
                }
            }
        });
    }
    @Override
    protected void onStart(){
        super.onStart();
        video.seekTo(1);
    }
}