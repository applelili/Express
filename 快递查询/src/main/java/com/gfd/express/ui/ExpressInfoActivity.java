package com.gfd.express.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.gfd.express.R;
import com.gfd.express.entity.ExpressBean;

public class ExpressInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_express_info);
        ExpressBean expressBean = (ExpressBean) getIntent().getSerializableExtra("info");
        Toast.makeText(this, "" + expressBean.data.size(), Toast.LENGTH_SHORT).show();
    }
}
