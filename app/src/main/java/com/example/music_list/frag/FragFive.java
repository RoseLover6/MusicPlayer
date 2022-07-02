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

import com.example.music_list.R;
import com.example.music_list.Activity.SongeasonActivity;

import androidx.fragment.app.Fragment;

public class FragFive extends Fragment {
    private View view;
    //创建歌曲的String数组和歌手图片的int数组
    public String[] name = {"十年", "淘汰", "爱情转移", "孤勇者"};
    public static int[] icons = {R.drawable.eason1, R.drawable.eason2, R.drawable.eason3, R.drawable.eason4};

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //绑定布局，只不过这里是用inflate()方法
        view = inflater.inflate(R.layout.music_list, null);
        //创建listView列表并且绑定控件
        ListView listView = view.findViewById(R.id.lv);
        //实例化一个适配器
        MyBaseAdapter adapter = new MyBaseAdapter();
        //列表设置适配器
        listView.setAdapter(adapter);
        //列表元素的点击监听器
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //创建Intent对象，参数就是从frag1跳转到MusicActivity
                Intent intent = new Intent(FragFive.this.getContext(), SongeasonActivity.class);
                //将歌曲名和歌曲的下标存入Intent对象
                intent.putExtra("name", name[position]);
                intent.putExtra("position", String.valueOf(position));
                //开始跳转
                startActivity(intent);
            }
        });
        return view;
    }

    //这里是创建一个自定义适配器
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
            View view = View.inflate(FragFive.this.getContext(), R.layout.item_layout, null);
            TextView tv_name = view.findViewById(R.id.item_name);
            ImageView iv = view.findViewById(R.id.iv);
            //设置控件显示的内容，就是获取的歌曲名和歌手图片
            tv_name.setText(name[i]);
            iv.setImageResource(icons[i]);
            return view;
        }
    }
}

