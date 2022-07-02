package com.example.music_list.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.example.music_list.R;

import androidx.appcompat.app.AppCompatActivity;

public class SearchMusicActivity extends AppCompatActivity {
    private View view;
    int flag = 0;
    //创建歌曲的String数组和歌手图片的int数组
    public String[] name = {"knowknow——Mr.Bentley", "刘聪——Hey kong", "梨冻紧/Wiz_H——Follow", "刘聪——单身公寓", "SHE——你曾是少年",
            "TWICE——Feel Special", "房东的猫——New Boy", "高进——下雪哈尔滨", "刘大拿——匿名的朋友", "True Damages——GIANT", "TWICE——TT"};
    public static int[] icons = {R.drawable.knowknow, R.drawable.liucong, R.drawable.follow, R.drawable.hotel, R.drawable.young,
            R.drawable.feelspecial, R.drawable.newboy, R.drawable.snowhaerbin, R.drawable.anoymousfriend, R.drawable.giant, R.drawable.tt};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_main);
        AutoCompleteTextView textView =
                (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, name);
        textView.setAdapter(adapter);
        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 11; i++) {
                    if ((textView.getText().toString()).equals(name[i])) {
                        flag += 1;
                    }
                }
                if (flag == 0) {
                    Toast.makeText(SearchMusicActivity.this, "您搜索的歌曲不存在",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(SearchMusicActivity.this, SearchActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("music", textView.getText().toString());
                    intent.putExtras(bundle);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}




