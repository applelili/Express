package com.gfd.express.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gfd.express.R;
import com.gfd.express.entity.CompanyInfo;

/**
 * 类描述：
 * 作者：郭富东
 * 创建日期： 2017/3/17 0017 下午 4:38
 * 更新日期：
 */
public class CompanyAdapter extends BaseAdapter {

    private final Context context;
    private final CompanyInfo[] data;

    public CompanyAdapter(Context context, CompanyInfo[] data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data == null ? 0 : data.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View itemView = View.inflate(context, R.layout.item_company, null);
        ImageView imgIcon = (ImageView) itemView.findViewById(R.id.img_item_icon);
        TextView tvName = (TextView) itemView.findViewById(R.id.tv_item_name);
        CompanyInfo companyInfo = data[position];
        imgIcon.setBackgroundResource(companyInfo.icon);
        tvName.setText(companyInfo.name);
        return itemView;
    }
}
