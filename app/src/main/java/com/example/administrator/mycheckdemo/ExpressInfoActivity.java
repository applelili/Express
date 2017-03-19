package com.example.administrator.mycheckdemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.example.administrator.mycheckdemo.entity.Model;

public class ExpressInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_express_info);

        Model model= (Model) getIntent().getSerializableExtra("info");
        Toast.makeText(this, ""+model.data.size(), Toast.LENGTH_SHORT).show();

    }

}
