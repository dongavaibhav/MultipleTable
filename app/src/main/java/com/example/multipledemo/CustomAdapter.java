package com.example.multipledemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    // declare the variable
    private Context mContext;
    private ArrayList<UserModel> mUsermodelArrayList;

    public CustomAdapter(Context context, ArrayList<UserModel> userModelArrayList) {
        this.mContext = context;
        this.mUsermodelArrayList = userModelArrayList;
    }

    @Override
    public int getCount() {
        return mUsermodelArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return mUsermodelArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.lv_item, null, true);

            holder.tvname = (TextView) convertView.findViewById(R.id.name);
            holder.tvhobby = (TextView) convertView.findViewById(R.id.hobby);
            holder.tvcity = (TextView) convertView.findViewById(R.id.city);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }
        holder.tvname.setText(mUsermodelArrayList.get(position).getName());
        holder.tvhobby.setText(mUsermodelArrayList.get(position).getHobby());
        holder.tvcity.setText(mUsermodelArrayList.get(position).getCity());
        return convertView;
    }

    private class ViewHolder {
        protected TextView tvname, tvhobby, tvcity;
    }
}
