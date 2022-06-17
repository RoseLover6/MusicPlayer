package com.example.music_list.frag;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.music_list.Activity.MusicActivity;
import com.example.music_list.R;

import androidx.fragment.app.Fragment;

public class FragOne extends Fragment {
    private View view;
    //创建歌曲的String数组和歌手图片的int数组
    public String[] name = {"knowknow——Mr.Bentley", "刘聪——Hey kong", "梨冻紧/Wiz_H——Follow", "刘聪——单身公寓", "SHE——你曾是少年",
            "TWICE——Feel Special", "房东的猫——New Boy", "高进——下雪哈尔滨", "刘大拿——匿名的朋友", "True Damages——GIANT", "TWICE——TT"};
    public static int[] icons = {R.drawable.knowknow, R.drawable.liucong, R.drawable.follow, R.drawable.hotel, R.drawable.young,
            R.drawable.feelspecial, R.drawable.newboy, R.drawable.snowhaerbin, R.drawable.anoymousfriend, R.drawable.giant, R.drawable.tt};

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //绑定布局，只不过这里是用inflate()方法
        view = inflater.inflate(R.layout.music_list, null);
        //创建listView列表并且绑定控件
        ListView listView = view.findViewById(R.id.lv);
        //实例化一个适配器
        FragOne.MyBaseAdapter adapter = new FragOne.MyBaseAdapter();
        //列表设置适配器
        listView.setAdapter(adapter);
        //列表元素的点击监听器
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //创建Intent对象，参数就是从frag1跳转到MusicActivity
                Intent intent = new Intent(FragOne.this.getContext(), MusicActivity.class);
                //将歌曲名和歌曲的下标存入Intent对象
                intent.putExtra("name", name[position]);
                intent.putExtra("position", String.valueOf(position));
                //开始跳转
                startActivity(intent);
            }
        });
        return view;
    }

    //自定义适配器
    class MyBaseAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return name.length;
        }

        @Override
        public Object getItem(int i) {
            return name[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup parent) {
            //绑定好VIew，然后绑定控件
            View view = View.inflate(FragOne.this.getContext(), R.layout.item_layout, null);
            TextView tv_name = view.findViewById(R.id.item_name);
            ImageView iv = view.findViewById(R.id.iv);
            //设置控件显示的内容，就是获取的歌曲名和歌手图片
            tv_name.setText(name[i]);
            iv.setImageResource(icons[i]);
            return view;
        }
    }

}



