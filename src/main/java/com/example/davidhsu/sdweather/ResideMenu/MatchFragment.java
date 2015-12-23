package com.example.davidhsu.sdweather.ResideMenu;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.davidhsu.sdweather.GPSTracker;
import com.example.davidhsu.sdweather.R;
import com.example.davidhsu.sdweather.sqlDatabase.MySQLiteOpenHelper;
import com.example.davidhsu.sdweather.sqlDatabase.Spot;
import com.example.davidhsu.sdweather.sqlDatabase.png;
import com.example.davidhsu.sdweather.weather.AlertDialogFragment;
import com.example.davidhsu.sdweather.weather.CurrentWeather;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

/**
 * User: special
 * Date: 13-12-22
 * Time: 下午3:28
 * Mail: specialcyci@gmail.com
 */
public class MatchFragment extends Fragment {

    private View matchParentView;
    private double doubleLongitude;
    private double doubleLatitude;
    private TextView mTextView;
    private TextView matv1;
    private ImageView maiv1;
    private ImageView maiv2;
    private ImageView maiv3;
    private Button mabtn1;
    private Button mabtn2;
    private Button mabtn3;
    private Button mabtn4;
    private Button mabtn5;
    private Button mabtn6;
    private ImageView ivSpot;
    private TextView tvId;
    private MySQLiteOpenHelper helper;
    private byte[] image;
    private final int tem = 21;
    private List<Spot> spotList4;
    private List<Spot> spotList5;
    private List<Spot> spotList6;



    private int index;

    String name="";


    public static final String TAG = MatchFragment.class.getSimpleName();

    private CurrentWeather mCurrentWeather;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        matchParentView = inflater.inflate(R.layout.matchactivity, container, false);

//        mTextView = (TextView)matchParentView.findViewById(R.id.tvTemp);

//        maiv1 = (ImageView) matchParentView.findViewById(R.id.imageView2);
//        maiv2 = (ImageView) matchParentView.findViewById(R.id.imageView3);
//        maiv3 = (ImageView) matchParentView.findViewById(R.id.imageView4);

        mabtn1 = (Button) matchParentView.findViewById(R.id.button);
        mabtn2 = (Button) matchParentView.findViewById(R.id.button2);
        mabtn3 = (Button) matchParentView.findViewById(R.id.button3);
        mabtn4 = (Button) matchParentView.findViewById(R.id.button7);
        mabtn5 = (Button) matchParentView.findViewById(R.id.button8);
        mabtn6 = (Button) matchParentView.findViewById(R.id.button9);

        matv1 = (TextView) matchParentView.findViewById(R.id.textView5);

        spotList4 =helper.getTopSpots();
//        spotList2 =helper.getMidSpots();
//        spotList3 =helper.getBotSpots();
        showTopMatch(0);
//        showMidMatch(0);
//        showBotMatch(0);




//        Context context = maiv1.getContext();
//
//        int id = context.getResources().getIdentifier(name, "drawable", context.getPackageName());


        //TrackGPS
        GPSTracker gpsTracker = new GPSTracker(getActivity().getApplicationContext());
        if (gpsTracker.getIsGPSTrackingEnabled())
        {
            doubleLatitude = gpsTracker.getLatitude();
            //latitude = doubleLatitude;
            doubleLongitude = gpsTracker.getLongitude();
            //longitude = doubleLongitude;
        }



        getForecast(doubleLatitude, doubleLongitude); //latitude, longitude


        Log.d(TAG, "Main UI is running!!");


//        if (helper == null) {
//            helper = new MySQLiteOpenHelper(getActivity());
//        }
//        spotList1 =helper.getShortSpots();
//        spotList2 =helper.getLongSpots();
//        showSpotsMatch(0);

//        Button btnMatchNext = (Button)matchParentView.findViewById(R.id.btnMatchNext);
//        btnMatchNext.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                index++;
//                if (index >= spotList1.size()) {
//                    index = 0;
//                }
//                showSpotsMatch(index);
//            }
//        });
//
//        Button btnMatchBack = (Button)matchParentView.findViewById(R.id.btnMatchBack);
//        btnMatchBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                index--;
//                if (index < 0) {
//                    index = spotList1.size() - 1;
//                }
//                showSpotsMatch(index);
//            }
//        });

        return matchParentView;
    }


    private void showTopMatch(int index) {
        maiv1 = (ImageView) matchParentView.findViewById(R.id.imageView2);
//       tvId = (TextView) matchParentView.findViewById(R.id.tvId);
        if (helper == null) {
            helper = new MySQLiteOpenHelper(getActivity());

            if (spotList4.size() > 0) {
                Spot spot = spotList4.get(index);
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
            Context context = maiv1.getContext();

            int id = context.getResources().getIdentifier(name, "drawable", context.getPackageName());

            maiv1.setImageResource(id);
        }
    }

    private void showMidMatch(int index) {
        maiv2 = (ImageView) matchParentView.findViewById(R.id.imageView3);
//        tvId = (TextView) matchParentView.findViewById(R.id.tvId);

        if (helper == null) {
            helper = new MySQLiteOpenHelper(getActivity());
        }
    }


    private void showBotMatch(int index) {
        maiv3 = (ImageView) matchParentView.findViewById(R.id.imageView4);
//        tvId = (TextView) matchParentView.findViewById(R.id.tvId);

        if (helper == null) {
            helper = new MySQLiteOpenHelper(getActivity());
        }
    }


    public void onTopNextClickMatch(View view) {
        index++;
        if (index >= spotList4.size()) {
            index = 0;
        }
        showTopMatch(index);
    }

    public void onTopBackClickMatch(View view) {
        index--;
        if (index < 0) {
            index = spotList4.size() - 1;
        }
        showTopMatch(index);
    }

    public void onMidNextClickMatch(View view) {
        index++;
        if (index >= spotList5.size()) {
            index = 0;
        }
        showMidMatch(index);
    }

    public void onMidBackClickMatch(View view) {
        index--;
        if (index < 0) {
            index = spotList5.size() - 1;
        }
        showMidMatch(index);
    }

    public void onBotNextClickMatch(View view) {
        index++;
        if (index >= spotList6.size()) {
            index = 0;
        }
        showBotMatch(index);
    }

    public void onBotBackClickMatch(View view) {
        index--;
        if (index < 0) {
            index = spotList6.size() - 1;
        }
        showBotMatch(index);
    }


    public void onCancelClick(View view) {
        closefragment();
    }
    private void closefragment() {
        getActivity().getFragmentManager().popBackStack();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (helper != null) {
            helper.close();
        }
    }







    private void getForecast(double latitude, double longitude) {
        String apiKey = "d405c6cfa70d6a1489f2a63e7d484bf1";

        String forecastUrl = "https://api.forecast.io/forecast/" + apiKey + "/"+ latitude + "," + longitude;



        if (isNetworkAvailable()) {

            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(forecastUrl)
                    .build();

            Call call = client.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Request request, IOException e) {

                }

                @Override
                public void onResponse(Response response) throws IOException {

                    try {

                        String jsonData = response.body().string();
                        Log.v(TAG, jsonData);

                        if (response.isSuccessful()) {
                            mCurrentWeather = getCurrentDetails(jsonData);
                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    //updateDisplay();
                                }
                            });


                        } else {
                            alertUserAboutError();
                        }
                    } catch (IOException e) {
                        Log.e(TAG, "Exception caught: ", e);
                    }
                    catch (JSONException e)
                    {
                        Log.e(TAG, "Exception caught: ", e);
                    }

                }
            });

        }else{
            Toast.makeText(getActivity(), R.string.network_unavailable_message, Toast.LENGTH_LONG).show();
        }
    }

//    private void updateDisplay() {
//        mTextView.setText("現在的溫度是 : " + mCurrentWeather.getTemperature() + " 度，比較適合穿....");
//
//
//    }

    private CurrentWeather getCurrentDetails(String jsonData) throws JSONException{
        JSONObject forecast = new JSONObject(jsonData);
        String timezone = forecast.getString("timezone");
        Log.i(TAG,"From JSON : " + timezone);

        //從JSON資料中的currently 找資料
        JSONObject currently = forecast.getJSONObject("currently");

        //已經進入currently了  現在要從currently中獲取currently類別的資料
        CurrentWeather currentWeather = new CurrentWeather();
        currentWeather.setHumidity(currently.getDouble("humidity"));  //"" 中打的資料名稱必須和 原本JSON資料來源中的一樣
        currentWeather.setIcon(currently.getString("icon"));
        currentWeather.setTime(currently.getLong("time"));
        currentWeather.setPrecipChance(currently.getDouble("precipProbability"));
        currentWeather.setSummary(currently.getString("summary"));
        currentWeather.setTemperature(currently.getDouble("temperature"));
        currentWeather.setTimeZone(timezone);

        Log.d(TAG, currentWeather.getFormattedTime());

        return currentWeather;
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager manager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        boolean isAvailable = false;

        if (networkInfo != null && networkInfo.isConnected())
        {
            isAvailable = true;
        }

        return isAvailable;
    }

    private void alertUserAboutError() {
        AlertDialogFragment dialog = new AlertDialogFragment();
        dialog.show(getActivity().getFragmentManager(), "error_dialog");
    }



}