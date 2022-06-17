package com.example.music_list.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.music_list.R;
import com.example.music_list.frag.FragThree;
import com.example.music_list.frag.FragFour;
import com.example.music_list.frag.FragFive;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class SingerActivity extends AppCompatActivity {
    private TextView tv3;
    private FragmentManager fm;
    private FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singer_main);
        //绑定控件
        tv3 = (TextView) findViewById(R.id.menu3);
        //设置监听器，固定写法
        fm = getSupportFragmentManager();
        //fm可以理解为Fragment显示的管理者，ft就是它的改变者
        ft = fm.beginTransaction();
        //默认情况下就显示frag3
        ft.replace(R.id.content2, new FragThree());
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        //切换选项卡
        switch (bundle.getInt("number")) {
            case 1:
                ft.replace(R.id.content2, new FragThree());
                break;
            case 2:
                ft.replace(R.id.content2, new FragFour());
                break;
            case 3:
                ft.replace(R.id.content2, new FragFive());
                break;
            default:
                break;
        }
        //提交改变的内容
        ft.commit();
    }
}
