package com.example.davidhsu.sdweather.ResideMenu;

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

import java.util.List;

/**
 * User: special
 * Date: 13-12-22
 * Time: 下午1:31
 * Mail: specialcyci@gmail.com
 */
public class CameraFragment extends Fragment {

    private View cameraParentView;

    private ImageView ivSpot;
    private TextView tvRowCount;
    private TextView tvId;
    private TextView tvClothes;
    private TextView tvType;
    private TextView tvColor;
    private TextView tvSleeve;
    private TextView tvMaterial;
    private List<Spot> spotList;
    private int index;
    private MySQLiteOpenHelper helper;
    String name="";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        cameraParentView = inflater.inflate(R.layout.camera_activity, container, false);

        findViews();
        if (helper == null) {
            helper = new MySQLiteOpenHelper(getActivity());
        }
        spotList = helper.getAllSpots();
        showSpots(0);

        return cameraParentView;
    }

    @Override
        public void onStart() {
        super.onStart();
        spotList = helper.getAllSpots();
        showSpots(index);
    }

    private void findViews() {
        ivSpot = (ImageView) cameraParentView.findViewById(R.id.ivSpot);
        tvRowCount = (TextView) cameraParentView.findViewById(R.id.tvRowCount);
        tvId = (TextView) cameraParentView.findViewById(R.id.tvId);
        tvClothes = (TextView) cameraParentView.findViewById(R.id.tvClothes);
        tvType = (TextView) cameraParentView.findViewById(R.id.tvType);
        tvColor = (TextView) cameraParentView.findViewById(R.id.tvColor);
        tvSleeve = (TextView) cameraParentView.findViewById(R.id.tvSleeve);
        tvMaterial = (TextView) cameraParentView.findViewById(R.id.tvMaterial);

        ImageButton onNextClick = (ImageButton)cameraParentView.findViewById(R.id.btNext);
        onNextClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index++;
                if (index >= spotList.size()) {
                    index = 0;
                }
                showSpots(index);
            }
        });

        ImageButton onBackClick = (ImageButton)cameraParentView.findViewById(R.id.btBack);
        onBackClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index--;
                if (index < 0) {
                    index = spotList.size() - 1;
                }
                showSpots(index);
            }
        });

        ImageButton onInsertClick = (ImageButton)cameraParentView.findViewById(R.id.btInsert);
        onInsertClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), InsertActivity.class);
                startActivity(intent);
            }
        });


        ImageButton onDeleteClick = (ImageButton)cameraParentView.findViewById(R.id.btDelete);
        onDeleteClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (spotList.size() <= 0) {
                    Toast.makeText(getActivity(), R.string.msg_NoDataFound,
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                int id = Integer.parseInt(tvId.getText().toString());
                int count = helper.deleteById(id);
                Toast.makeText(getActivity(), count + " " + getString(R.string.msg_RowDeleted),
                        Toast.LENGTH_SHORT).show();
                spotList = helper.getAllSpots();
                showSpots(index-1);
            }
        });



    }

    private void showSpots(int index) {
        if (spotList.size() > 0) {
            Spot spot = spotList.get(index);
            String clothes="";
            String type="";
            String color ="";
            String sleeve="";
            name="";

            if (spot.getClothes().equals("上衣")){
                clothes =  "t";
            }else if(spot.getClothes().equals("褲子")){

                clothes="m";

            }else if(spot.getClothes().equals("鞋子")){
                clothes="b";
            }

            if (spot.getType() .equals("OL服")){
                type =  "o";
            }else if (spot.getType() .equals( "女用T桖")){
                type =  "w";
            }else if(spot.getType() .equals( "圖案T桖")){
                type =  "p";
            }else if(spot.getType() .equals( "毛衣")){
                type =  "s";
            }else if(spot.getType() .equals( "外套")){
                type =  "c";
            }else if(spot.getType() .equals( "夾克")){
                type =  "j";
            }else if(spot.getType() .equals( "洋裝")){
                type =  "d";
            }else if(spot.getType() .equals( "牛仔褲")){
                type =  "j";
            }else if(spot.getType() .equals( "卡其褲")){
                type =  "k";
            }else if(spot.getType() .equals( "素短裙")){
                type =  "c";
            }else if(spot.getType() .equals( "圖案短裙")){
                type =  "p";
            }else if(spot.getType() .equals( "短褲")){
                type =  "s";
            }else if(spot.getType().equals( "帆布鞋")){
                type ="e";
            }else if(spot.getType().equals( "馬靴")){
                type ="b";
            }else if(spot.getType().equals( "短筒平鞋")){
                type ="a";
            }

            if (spot.getColor() .equals("黑")){
                color =  "d";
            }else if (spot.getColor() .equals("白")){
                color =  "w";
            }else if(spot.getColor() .equals("紅")){
                color =  "r";
            }else if(spot.getColor() .equals("黃")){
                color =  "y";
            }else if(spot.getColor() .equals("藍")){
                color =  "b";
            }else if(spot.getColor() .equals("綠")){
                color =  "g";
            }else if(spot.getColor() .equals("紫")){
                color =  "p";
            }
            if (spot.getSleeve().equals("長")){
                sleeve =  "l";
            }else if(spot.getSleeve().equals( "短")){
                sleeve =  "s";
            }else if(spot.getSleeve().equals( "")){
                sleeve =  "";}
            name=clothes+type+ color +sleeve;

            Context context = ivSpot.getContext();

            int id = context.getResources().getIdentifier(name, "drawable", context.getPackageName());
            ivSpot.setImageResource(id);


            tvId.setText(Integer.toString(spot.getId()));
            tvClothes.setText(spot.getClothes());
            tvType.setText(spot.getType());
            tvColor.setText(spot.getColor());
            tvSleeve.setText(spot.getSleeve());
            tvMaterial.setText(spot.getMaterial());
            tvRowCount.setText((index + 1) + "/" + spotList.size());
        } else {
            ivSpot.setImageResource(R.drawable.ic_launcher);
            tvId.setText(null);
            tvClothes.setText(null);
            tvType.setText(null);
            tvColor.setText(null);
            tvSleeve.setText(null);
            tvMaterial.setText(null);
            tvRowCount.setText(" 0/0 " + getString(R.string.msg_NoDataFound));
        }
    }

   /* public void onNextClick(View view) {
        index++;
        if (index >= spotList.size()) {
            index = 0;
        }
        showSpots(index);
    }

    public void onBackClick(View view) {
        index--;
        if (index < 0) {
            index = spotList.size() - 1;
        }
        showSpots(index);
    }

    public void onInsertClick(View view) {
        Intent intent = new Intent(getActivity(), InsertActivity1.class);
        startActivity(intent);
    }

    public void onUpdateClick(View view) {
        if (spotList.size() <= 0) {
            Toast.makeText(getActivity(), R.string.msg_NoDataFound,
                    Toast.LENGTH_SHORT).show();
            return;
        }
        int id = Integer.parseInt(tvId.getText().toString());
        Intent intent = new Intent(getActivity(), UpdateActivity1.class);
        Bundle bundle = new Bundle();
        bundle.putInt("id", id);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void onDeleteClick(View view) {
        if (spotList.size() <= 0) {
            Toast.makeText(getActivity(), R.string.msg_NoDataFound,
                    Toast.LENGTH_SHORT).show();
            return;
        }
        int id = Integer.parseInt(tvId.getText().toString());
        int count = helper.deleteById(id);
        Toast.makeText(getActivity(), count + " " + getString(R.string.msg_RowDeleted),
                Toast.LENGTH_SHORT).show();
        spotList = helper.getAllSpots();
        showSpots(0);
    }

*/
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (helper != null) {
            helper.close();
        }
    }


}
