package com.iot.a20220712_customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private KaTalkListView listView;
    private KatalkAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (KaTalkListView)findViewById(R.id.listView);

        adapter = new KatalkAdapter(this);

        adapter.addItem(R.drawable.image_1,"onekick","Hello, Good Day!");
        adapter.addItem(R.drawable.image_2,"홍길동","나쁜 탐관오리들");
        adapter.addItem(R.drawable.image_3,"모모랜드","뿜뿜");
        adapter.addItem(R.drawable.image_4,"김태희","비온다");
        adapter.addItem(R.drawable.image_5,"복분자","라즈베리파이");
        adapter.addItem(R.drawable.image_6,"로즈마리","과외 받으러 오세요");
        adapter.addItem(R.drawable.image_7,"android21","네이버 까페");
        adapter.addItem(R.drawable.image_8,"강태공","낚시하러 갑시다.");

        listView.setAdapter(adapter);

        adapter.notifyDataSetChanged();
    }
}