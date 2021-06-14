package org.techtown.mycv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button phoneBtn, emailBtn, gitBtn, appBtn, webBtn1, webBtn2, chatbotBtn, guiBtn;
    TextView person[];
    ProgressBar pb[];
    final int perN = 8, pbN = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phoneBtn = findViewById(R.id.phone_btn);
        emailBtn = findViewById(R.id.email_btn);
        gitBtn = findViewById(R.id.git_btn);
        appBtn = findViewById(R.id.app_btn1);
        webBtn1 = findViewById(R.id.web_btn1);
        webBtn2 = findViewById(R.id.web_btn2);
        chatbotBtn = findViewById(R.id.chatbot_btn1);
        guiBtn = findViewById(R.id.gui_btn1);
        person = new TextView[perN];
        pb = new ProgressBar[pbN];


        for(int i = 1;i<=perN;i++){
            int id = getResources().getIdentifier("person" + i,"id",getApplicationContext().getPackageName());
            person[i-1] = findViewById(id);
        }

        for(int i = 1;i<=pbN;i++){
            int id = getResources().getIdentifier("progressBar" + i,"id",getApplicationContext().getPackageName());
            pb[i-1] = findViewById(id);
        }

        int idx = 0;
        for(int i = 0;i<pbN;i++){
            if(pb[i].getProgress()==5){
                person[idx].setTypeface(person[idx].getTypeface(), Typeface.BOLD);
                person[idx + 1].setTypeface(person[idx + 1].getTypeface(),Typeface.BOLD);
            }else if(pb[i].getProgress()>5){
                person[idx].setTypeface(person[idx].getTypeface(),Typeface.BOLD);
            }else{
                person[idx + 1].setTypeface(person[idx + 1].getTypeface(),Typeface.BOLD);
            }
            idx += 2;
        }

        phoneBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-8383-8246"));
                startActivity(intent);
            }
        });

        emailBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Intent.ACTION_SENDTO,Uri.parse("mailto:musiclove529@gmail.com"));
                startActivity(intent);
            }
        });

        gitBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/dpdms529"));
                startActivity(intent);
            }
        });

        appBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), AppActivity.class);
                startActivity(intent);
            }
        });

        webBtn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), Web1Activity.class);
                startActivity(intent);
            }
        });

        webBtn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), Web2Activity.class);
                startActivity(intent);
            }
        });

        chatbotBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), ChatbotActivity.class);
                startActivity(intent);
            }
        });

        guiBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), GuiActivity.class);
                startActivity(intent);
            }
        });
    }
}