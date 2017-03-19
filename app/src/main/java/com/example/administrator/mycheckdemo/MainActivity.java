package com.example.administrator.mycheckdemo;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.mycheckdemo.entity.Model;
import com.example.administrator.mycheckdemo.net.RetrofitApi;
import com.google.gson.Gson;
import com.syd.oden.circleprogressdialog.core.CircleProgressDialog;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.right)
    ImageView right;
    @BindView(R.id.checkid)
    EditText checkid;
    @BindView(R.id.cha)
    ImageView cha;
    @BindView(R.id.button)
    Button button;
    @BindView(R.id.name)
    TextView name1;
    private Intent intent;
    private static final String URL_IMG = "https://www.kuaidi100.com/query?type=yuantong&postid=533934622848";

    private static final int REQUEST_CODE_COMPANY = 1;
//获取快递码
    private Map<String,String> expressInfo = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        expressInfo.put("百世汇通","huitongkuaidi");
        expressInfo.put("中通","zhongtong");
        expressInfo.put("德邦","debangwuliu");
        expressInfo.put("天天快递","tiantian");
        expressInfo.put("宅急送","zhaijisong");
        expressInfo.put("韵达","yunda");
        expressInfo.put("圆通","yuantong");
        expressInfo.put("EMS","ems");
    }


    @OnClick({R.id.right, R.id.cha, R.id.button})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.right:
                intent = new Intent(this, SecondActivity.class);
                startActivityForResult(intent,REQUEST_CODE_COMPANY);
                break;
            case R.id.cha:
                checkid.setText("");
                break;
            case R.id.button:
                //获取输入的数据
                String companyname=name1.getText().toString().trim();
                String chickid1 = checkid.getText().toString().trim();
                //判断是否为空
                if(TextUtils.isEmpty(companyname)||TextUtils.isEmpty(chickid1)){
                    Toast.makeText(this, "单号或名称不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                //如果不为空情况下访问网络
                final CircleProgressDialog circleProgressDialog=new CircleProgressDialog(this);
                circleProgressDialog.setDialogSize(15);
                circleProgressDialog.setProgressColor(Color.parseColor("#FFFFFF"));
                circleProgressDialog.setTextColor(Color.parseColor("#FFFFFF"));
                circleProgressDialog.changeText("正在查询:...");
                circleProgressDialog.showDialog();

                //访问网络
                Map<String,String> params=new HashMap<>();
                //通过快递公司获取对应的快递号
                String s=expressInfo.get(companyname);
                params.put("type",s);
                params.put("postid",chickid1);
                RetrofitApi.getInstance().getRetrofitService().getExpressInfo(params).enqueue(new Callback<Model>() {
                    @Override
                    public void onResponse(Call<Model> call, retrofit2.Response<Model> response) {
                        if(response.code()==200 && response.isSuccessful()){
                            //判断查询是否成功
                            Model model=response.body();
                            if(model.message.equals("ok")){//查询成功
                                Intent intent = new Intent(MainActivity.this, ExpressInfoActivity.class);
                                intent.putExtra("info",model);//许实现序列化接口
                                startActivity(intent);
                            }else {
                                Toast.makeText(MainActivity.this, "请检查查询的数据", Toast.LENGTH_SHORT).show();
                            }
                            circleProgressDialog.dismiss();//关闭对话框
                        }
                    }

                    @Override
                    public void onFailure(Call<Model> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "访问网络失败", Toast.LENGTH_SHORT).show();
                        circleProgressDialog.dismiss();

                    }
                });
                break;
        }
    }
        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if(requestCode==REQUEST_CODE_COMPANY && resultCode==2 && data !=null){
                String name2=data.getStringExtra("name");
                name1.setText(name2);
            }
    }
}
