package com.gfd.express.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.gfd.express.R;
import com.gfd.express.adapter.CompanyAdapter;
import com.gfd.express.entity.CompanyInfo;

public class ExpressCompanyActivity extends Activity {

    private CompanyInfo[] datas = {
            new CompanyInfo("顺丰",R.drawable.shunfeng),
            new CompanyInfo("中通",R.drawable.zhongtong),
            new CompanyInfo("申通",R.drawable.shengtong),
            new CompanyInfo("圆通",R.drawable.yuantong),
            new CompanyInfo("韵达",R.drawable.yunda),
            new CompanyInfo("EMS",R.drawable.ems1),
            new CompanyInfo("宅急送",R.drawable.zhaijisong),
            new CompanyInfo("百世汇通",R.drawable.huitong)
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_express_company);
        ListView mlist = (ListView) findViewById(R.id.list_express_compay);
        mlist.setAdapter(new CompanyAdapter(this,datas));
        mlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent data = new Intent();
                data.putExtra("name",datas[position].name);
                setResult(2, data);
                finish();
            }
        });
    }
}
