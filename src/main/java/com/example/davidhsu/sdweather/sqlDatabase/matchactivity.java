//package com.example.davidhsu.sdweather.sqlDatabase;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.view.View;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.example.davidhsu.sdweather.R;
//
///**
// * Created by Jorden on 2015/12/22.
// */
//public class matchactivity extends AppCompatActivity {
//
//    private TextView matv1;
//    private TextView matv2;
//    private ImageView maiv1;
//    private ImageView maiv2;
//    private ImageView maiv3;
//    private Button mabtn1;
//    private Button mabtn2;
//    private Button mabtn3;
//    private Button mabtn4;
//    private Button mabtn5;
//    private Button mabtn6;
//    /**
//     * ATTENTION: This was auto-generated to implement the App Indexing API.
//     * See https://g.co/AppIndexing/AndroidStudio for more information.
//     */
//
//
//
//    @Override
//    public void onCreate(Bundle saveInstancestate) {
//        super.onCreate(saveInstancestate);
//        setContentView(R.layout.matchactivity);
//        //抓天氣給   matv 1 2
//
//        matv1 = (TextView) findViewById(R.id.textView5);
//        matv2 = (TextView) findViewById(R.id.textView6);
//
//        maiv1 = (ImageView) findViewById(R.id.imageView2);
//        maiv2 = (ImageView) findViewById(R.id.imageView3);
//        maiv3 = (ImageView) findViewById(R.id.imageView4);
//
//        mabtn1 = (Button) findViewById(R.id.button);
//        mabtn2 = (Button) findViewById(R.id.button2);
//        mabtn3 = (Button) findViewById(R.id.button3);
//
//
//        mabtn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intent = new Intent(matchactivity.this, closet1.class);
//
//                startActivityForResult(intent, 0);
//            }
//        });
//        mabtn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intent = new Intent(matchactivity.this, closet2.class);
//
//                startActivityForResult(intent, 0);
//            }
//        });
//        mabtn3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intent = new Intent(matchactivity.this, closet3.class);
//
//                startActivityForResult(intent, 0);
//            }
//        });
//
//
//
//
//
//
//    }
//
//    @Override
//    public void onStart() {
//        super.onStart();
//
//
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//
//
//    }
//}
