package com.iot.a20220712_customlistview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Point;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class KatalkAdapter extends BaseAdapter {

    private static final String TAG = "KaTalkAdapter";
    private final Activity activity;
    private ArrayList<ItemData> arrayList = new ArrayList<>();

    public KatalkAdapter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }
    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("SimpleDateFormat")
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @NonNull

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Log.i(TAG,"getView called position : " + position);
        if (convertView==null) {
            Log.i(TAG,"getView: convertView==null");
            LayoutInflater inflater = activity.getLayoutInflater();
            convertView = inflater.inflate(R.layout.layout_item,parent,false);
        }

        LinearLayout linearLayout = (LinearLayout)convertView;

        Display display = activity.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        int itemHeight = size.x/5;
        ViewGroup.LayoutParams param = linearLayout.getLayoutParams();
        param.height = itemHeight;
        linearLayout.setLayoutParams(param);

        ItemData itemData = arrayList.get(position);
        ImageView imageView = linearLayout.findViewById(R.id.imageView);
        TextView textViewName = linearLayout.findViewById(R.id.textViewName);
        TextView textViewTime = linearLayout.findViewById(R.id.textViewTime);
        TextView textViewMessage = linearLayout.findViewById(R.id.textViewMessage);

        imageView.setImageResource(itemData.getImage());
        textViewName.setText(itemData.getName());
        Date date = new Date(itemData.getTime());

        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd");
        textViewTime.setText(""+simpleFormat.format(date));
        textViewMessage.setText(itemData.getMessage());

        return linearLayout;
    }

    public void addItem(int rid, String name, String message) {
        ItemData item = new ItemData(rid, name, System.currentTimeMillis(), message);
        arrayList.add(item);
    }
}
