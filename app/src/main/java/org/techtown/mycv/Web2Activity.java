package org.techtown.mycv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Web2Activity extends AppCompatActivity {
    ImageButton backBtn;
    Button gitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web2);

        backBtn = findViewById(R.id.back_btn);
        gitBtn = findViewById(R.id.git_btn);

        backBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                finish();
            }
        });

        gitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/dpdms529/Coala_Spring_Study"));
                startActivity(intent);
            }
        });

    }
}