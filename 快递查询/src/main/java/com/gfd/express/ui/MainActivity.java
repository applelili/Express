package com.gfd.express.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.gfd.express.R;
import com.gfd.express.entity.ExpressBean;
import com.gfd.express.net.RetrofitApi;
import com.syd.oden.circleprogressdialog.core.CircleProgressDialog;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText mEdExpressNumber;
    private EditText mEdExpressCompany;
    private static final int REQUEST_CODE_COMPANY = 1;
    private CircleProgressDialog circleProgressDialog;
    private Map<String,String> expressInfo = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expressInfo.put("百世汇通","huitongkuaidi");
        expressInfo.put("中通","zhongtong");
        expressInfo.put("德邦","debangwuliu");
        expressInfo.put("天天快递","tiantian");
        expressInfo.put("宅急送","zhaijisong");
        expressInfo.put("韵达","yunda");
        expressInfo.put("圆通","yuantong");
        expressInfo.put("EMS","ems");
        initView();
    }

    private void initView() {
        mEdExpressNumber = (EditText) findViewById(R.id.ed_express_number);
        mEdExpressCompany = (EditText) findViewById(R.id.ed_express_name);
        ImageView mImgClear = (ImageView) findViewById(R.id.img_mian_clear);
        ImageView mImgRight = (ImageView) findViewById(R.id.img_mian_right);
        mImgClear.setOnClickListener(this);
        mImgRight.setOnClickListener(this);
    }

    /** 查询按钮 */
    public void bt_query(View view){
        //获取输入的数据
        String companyName = mEdExpressCompany.getText().toString().trim();
        String expressNumber = mEdExpressNumber.getText().toString().trim();
        //做非空判断
        if(TextUtils.isEmpty(companyName) || TextUtils.isEmpty(expressNumber)){
            Toast.makeText(this, "查询数据不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        //输入的有数据，网络查询
        //显示对话框
        circleProgressDialog = new CircleProgressDialog(this);
        circleProgressDialog.setProgressColor(Color.parseColor("#FFFFFF"));
        circleProgressDialog.setTextColor(Color.parseColor("#FFFFFF"));
        circleProgressDialog.showDialog();
        circleProgressDialog.changeText("正在查询.....");
        //访问网络
        Map<String,String> params = new HashMap<>();
        //通过快递公司获取对应的快递号
        String s = expressInfo.get(companyName);
        params.put("type",s);
        params.put("postid",expressNumber);
        RetrofitApi.getInstance().getRetrofitService().getExpressInfo(params).enqueue(new Callback<ExpressBean>() {
            @Override
            public void onResponse(Call<ExpressBean> call, Response<ExpressBean> response) {
                if(response.code() == 200 && response.isSuccessful()){
                    //判断查询是否成功
                    ExpressBean expressBean = response.body();
                    if(expressBean.message.equals("ok")){//查询成功
                        Intent intent = new Intent(MainActivity.this, ExpressInfoActivity.class);
                        intent.putExtra("info",expressBean);
                        startActivity(intent);
                    }else{
                        Toast.makeText(MainActivity.this, "请检查查询的数据", Toast.LENGTH_SHORT).show();
                    }
                    circleProgressDialog.dismiss();
                }

            }

            @Override
            public void onFailure(Call<ExpressBean> call, Throwable t) {
                Toast.makeText(MainActivity.this, "访问网络失败", Toast.LENGTH_SHORT).show();
                circleProgressDialog.dismiss();

            }
        });




    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.img_mian_clear://清楚快递单号
                mEdExpressNumber.setText("");
                break;
            case R.id.img_mian_right://选择快递公司
                startActivityForResult(new Intent(MainActivity.this,ExpressCompanyActivity.class),REQUEST_CODE_COMPANY);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE_COMPANY && resultCode == 2 && data != null){
            String companyName = data.getStringExtra("name");
            mEdExpressCompany.setText(companyName);
        }
    }
}
