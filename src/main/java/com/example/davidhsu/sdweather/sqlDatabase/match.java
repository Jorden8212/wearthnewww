package com.example.davidhsu.sdweather.sqlDatabase;

/**
 * Created by David Hsu on 2015/9/19.
 */
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import android.content.ContentValues;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.davidhsu.sdweather.R;
import com.example.davidhsu.sdweather.sqlDatabase.MySQLiteOpenHelper;
import com.example.davidhsu.sdweather.sqlDatabase.Spot;


public class match extends AppCompatActivity {
    private ImageView ivSpot;
    private TextView tvId;
    private MySQLiteOpenHelper helper;
    private final int tem = 21;
    private List<Spot> spotList1;
    private List<Spot> spotList2;
    private List<Spot> spotList3;
    private int index;
    private TextView tvClothes;
    private TextView tvType;
    private TextView tvColor;
    private TextView tvSleeve;
    private TextView tvMaterial;
    private TextView tvRowCount;
    private List<Spot> spotList;
    String name="";
    private Button btn1;
    private Button btn2;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.match_layout);

        if (helper == null) {
            helper = new MySQLiteOpenHelper(this);
        }
        spotList1 =helper.getTopSpots();
        btn1= (Button) findViewById(R.id.button7);
        btn2= (Button) findViewById(R.id.button);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTopNextClickMatch(v);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTopBackClickMatch(v);
            }
        });


//        spotList2 =helper.getMidSpots();
//        spotList3 =helper.getBotSpots();
        showTopMatch(0);
//        showMidMatch(0);
//        showBotMatch(0);

    }

    private void showTopMatch(int index) {
        ivSpot = (ImageView) findViewById(R.id.ivSpot);
        tvId = (TextView) findViewById(R.id.tvId);
        int temp =23;

        if (helper == null) {
            helper = new MySQLiteOpenHelper(this);
        }
        if (spotList1.size() > 0) {
            Spot spot = spotList1.get(index);
            String clothes = "";
            String type = "";
            String color = "";
            String sleeve = "";
            name = "";

            if (spot.getClothes().equals("上衣")) {
                clothes = "t";
            } else if (spot.getClothes().equals("褲子")) {

                clothes = "m";

            } else if (spot.getClothes().equals("鞋子")) {
                clothes = "b";
            }

            if (spot.getType().equals("OL服")) {
                type = "o";
            } else if (spot.getType().equals("女用T桖")) {
                type = "w";
            } else if (spot.getType().equals("圖案T桖")) {
                type = "p";
            } else if (spot.getType().equals("毛衣")) {
                type = "s";
            } else if (spot.getType().equals("外套")) {
                type = "c";
            } else if (spot.getType().equals("夾克")) {
                type = "j";
            } else if (spot.getType().equals("洋裝")) {
                type = "d";
            } else if (spot.getType().equals("牛仔褲")) {
                type = "j";
            } else if (spot.getType().equals("卡其褲")) {
                type = "k";
            } else if (spot.getType().equals("素短裙")) {
                type = "c";
            } else if (spot.getType().equals("圖案短裙")) {
                type = "p";
            } else if (spot.getType().equals("短褲")) {
                type = "s";
            } else if (spot.getType().equals("帆布鞋")) {
                type = "e";
            } else if (spot.getType().equals("馬靴")) {
                type = "b";
            } else if (spot.getType().equals("短筒平鞋")) {
                type = "a";
            }

            if (spot.getColor().equals("黑")) {
                color = "d";
            } else if (spot.getColor().equals("白")) {
                color = "w";
            } else if (spot.getColor().equals("紅")) {
                color = "r";
            } else if (spot.getColor().equals("黃")) {
                color = "y";
            } else if (spot.getColor().equals("藍")) {
                color = "b";
            } else if (spot.getColor().equals("綠")) {
                color = "g";
            } else if (spot.getColor().equals("紫")) {
                color = "p";
            }
            if (spot.getSleeve().equals("長")) {
                sleeve = "l";
            } else if (spot.getSleeve().equals("短")) {
                sleeve = "s";
            } else if (spot.getSleeve().equals("")) {
                sleeve = "";
            }
            name = clothes + type + color + sleeve;
            Context context = ivSpot.getContext();

            int id = context.getResources().getIdentifier(name, "drawable", context.getPackageName());
            ivSpot.setImageResource(id);
//            if (temp<=26){
//                if(sleeve.equals("l")){
//                    temp+=2;
//                    if (temp<=26){
//                        if (type.equals("j")||type.equals("s")||type.equals("c")){
//                            temp+=4;
//                                    if (temp>26){Context context = ivSpot.getContext();
//                                        int id = context.getResources().getIdentifier(name, "drawable", context.getPackageName());
//                                        ivSpot.setImageResource(id);}
//                        }
//                    }else{Context context = ivSpot.getContext();
//                        int id = context.getResources().getIdentifier(name, "drawable", context.getPackageName());
//                        ivSpot.setImageResource(id);}
//                }
//            }else {if (sleeve.equals("s")){
//                temp-=2;
//                if (temp<26){Context context = ivSpot.getContext();
//                    int id = context.getResources().getIdentifier(name, "drawable", context.getPackageName());
//                    ivSpot.setImageResource(id);}
//            }
            }
        }

//        Context context = ivSpot.getContext();
//        int id = context.getResources().getIdentifier(name, "drawable", context.getPackageName());
//        ivSpot.setImageResource(id);
//        Context context =ivSpot.getContext();
//
//        int id = context.getResources().getIdentifier(name, "drawable", context.getPackageName());
//
//        ivSpot.setImageResource(id);

//    private void showMidMatch(int index) {
//        ivSpot = (ImageView) findViewById(R.id.ivSpot);
//        tvId = (TextView) findViewById(R.id.tvId);
//
//        if (helper == null) {
//            helper = new MySQLiteOpenHelper(this);
//        }
//    }

//
//    private void showBotMatch(int index) {
//        ivSpot = (ImageView) findViewById(R.id.ivSpot);
//        tvId = (TextView) findViewById(R.id.tvId);
//
//        if (helper == null) {
//            helper = new MySQLiteOpenHelper(this);
//        }
//    }




//
//        if (tem<=24){
//            Spot spot = spotList1.get(index);
//            image = spot.getImage();
//            Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0,
//                    spot.getImage().length);
//            ivSpot.setImageBitmap(bitmap);
//            tvId.setText(Integer.toString(spot.getId()));
//        }
//        else if (tem>=24) {
//            Spot spot = spotList2.get(index);
//            image = spot.getImage();
//            Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0,
//                    spot.getImage().length);
//            ivSpot.setImageBitmap(bitmap);
//            tvId.setText(Integer.toString(spot.getId()));
//        }
//
//    }

    public void onTopNextClickMatch(View view) {
        index++;
        if (index >= spotList1.size()) {
            index = 0;
        }
        showTopMatch(index);
    }

    public void onTopBackClickMatch(View view) {
        index--;
        if (index < 0) {
            index = spotList1.size() - 1;
        }
        showTopMatch(index);
    }

//    public void onMidNextClickMatch(View view) {
//        index++;
//        if (index >= spotList2.size()) {
//            index = 0;
//        }
//        showMidMatch(index);
//    }
//
//    public void onMidBackClickMatch(View view) {
//        index--;
//        if (index < 0) {
//            index = spotList2.size() - 1;
//        }
//        showMidMatch(index);
//    }

//    public void onBotNextClickMatch(View view) {
//        index++;
//        if (index >= spotList3.size()) {
//            index = 0;
//        }
//        showBotMatch(index);
//    }
//
//    public void onBotBackClickMatch(View view) {
//        index--;
//        if (index < 0) {
//            index = spotList3.size() - 1;
//        }
//        showBotMatch(index);
//    }


    public void onCancelClick(View view) {
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (helper != null) {
            helper.close();
        }
    }

}
