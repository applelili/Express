package com.example.administrator.mycheckdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.mycheckdemo.entity.ExpressBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/17.
 */

public class SecondActivity extends AppCompatActivity {
    @BindView(R.id.listView)
    ListView listView;
    private ListAllAdapter adapter;
    private List<ExpressBean> mChecks;
    private String[] names;
    private ExpressBean[] datas;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        ButterKnife.bind(this);
        initData();
        initView();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent data=new Intent();
                    data.putExtra("name",datas[position].getName());
                   Toast.makeText(SecondActivity.this, "获取名字"+datas[position].getName(), Toast.LENGTH_SHORT).show();
                    setResult(2, data);
                    finish();
            }
        });
    }

    private void initData() {
        datas = new ExpressBean[]{
                new ExpressBean("顺丰", R.mipmap.shunfeng),
                new ExpressBean("中通",R.mipmap.zhongtong),
                new ExpressBean("申通",R.mipmap.shengtong),
                new ExpressBean("圆通",R.mipmap.yuantong),
                new ExpressBean("韵达",R.mipmap.yunda),
                new ExpressBean("EMS",R.mipmap.ems1),
                new ExpressBean("宅急送",R.mipmap.zhaijisong),
                new ExpressBean("百世汇通",R.mipmap.huitong)

        };

      /*  int[] imgs={R.mipmap.shengtong,R.mipmap.shunfeng,R.mipmap.yuantong,R.mipmap.tiantian,R.mipmap.yunda,R.mipmap.zhaijisong,R.mipmap.zhongtong};
        names = new String[]{"盛通","顺丰","圆通","天天","韵达","宅急送","中通"};
        mChecks=new ArrayList<>();
        for (int i = 0; i <imgs.length ; i++) {
            ExpressBean check=new ExpressBean();
            check.setImg(imgs[i]);
            check.setName(names[i]);
            mChecks.add(check);
        }*/
    }

    //初始化视图
    private void initView() {

        adapter=new ListAllAdapter(SecondActivity.this,datas);
        listView.setAdapter(adapter);
    }


}
