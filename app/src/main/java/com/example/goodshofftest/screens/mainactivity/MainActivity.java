package com.example.goodshofftest.screens.mainactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.goodshofftest.R;
import com.example.goodshofftest.screens.hoffgoodsactivity.HoffGoodsList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btn_go_to_screen_hoff_goods_list = findViewById(R.id.go_to_screen_list_of_goods);
        btn_go_to_screen_hoff_goods_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HoffGoodsList.class);
                MainActivity.this.startActivity(intent);
            }
        });

    }

}