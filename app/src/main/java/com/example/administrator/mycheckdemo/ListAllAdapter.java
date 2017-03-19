package com.example.administrator.mycheckdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.mycheckdemo.entity.ExpressBean;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/3/17.
 */

public class ListAllAdapter extends BaseAdapter {
    LayoutInflater inflater;
   private final ExpressBean[] data;

    public ListAllAdapter(Context context, ExpressBean[] data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public int getCount() {
        return data==null?0:data.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ExpressBean check=data[position];
        final ViewHolder viewHolder;
        if (convertView==null){
            convertView=inflater.inflate(R.layout.right_item,null);
           viewHolder=new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.image.setBackgroundResource(check.getImg());
        viewHolder.imgname.setText(check.getName());

        return convertView;
    }



    class ViewHolder {
        public View itemView;
        @BindView(R.id.image)
        ImageView image;
        @BindView(R.id.imgname)
        TextView imgname;

        public ViewHolder(View view) {
             this.itemView=view;
            image= (ImageView) itemView.findViewById(R.id.image);
            imgname= (TextView) itemView.findViewById(R.id.imgname);
        }
    }
}
