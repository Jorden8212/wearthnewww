package com.example.davidhsu.sdweather.sqlDatabase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.davidhsu.sdweather.R;

/**
 * Created by Jorden on 2015/12/22.
 */
public class InsertActivity extends AppCompatActivity {
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn10;
    private MySQLiteOpenHelper helper;

    @Override
    public void onCreate(Bundle saveInstancestate) {
        super.onCreate(saveInstancestate);
        setContentView(R.layout.insert_activity);

        btn1 = (Button) findViewById(R.id.button4);
        btn2 = (Button) findViewById(R.id.button5);
        btn3 = (Button) findViewById(R.id.button6);
        btn10 = (Button) findViewById(R.id.button10);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InsertActivity.this, InsertActivity1.class);
                startActivity(intent);
                finish();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InsertActivity.this, InsertActivity2.class);
                startActivity(intent);
                finish();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InsertActivity.this, InsertActivity3.class);
                startActivity(intent);
                finish();
            }

        });
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InsertActivity.this, match.class);
                startActivity(intent);
                finish();
            }

        });

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (helper != null) {
            helper.close();
        }
    }


}
