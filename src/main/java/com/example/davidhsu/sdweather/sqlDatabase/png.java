package com.example.davidhsu.sdweather.sqlDatabase;

import java.util.List;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.davidhsu.sdweather.R;
import com.example.davidhsu.sdweather.sqlDatabase.InsertActivity;
import com.example.davidhsu.sdweather.sqlDatabase.MySQLiteOpenHelper;
import com.example.davidhsu.sdweather.sqlDatabase.Spot;

/**
 * Created by Jorden on 2015/12/23.
 */
public class png extends Fragment {
    private List<Spot> spotList;
    private int index;

    public String iden(String name) {

        if (spotList.size() > 0) {
            Spot spot = spotList.get(index);
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


        }
        return name;
    }
}
