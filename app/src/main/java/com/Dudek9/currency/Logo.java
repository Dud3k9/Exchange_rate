package com.Dudek9.currency;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class Logo extends BaseAdapter {
    List<String> list;
    Context context;
    LayoutInflater layoutInflater;

    public Logo(List<String> list, Context context) {
        this.list = list;
        this.context = context;

        layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=layoutInflater.inflate(android.R.layout.simple_list_item_1,parent,false);
        TextView textView=(TextView)view.findViewById(android.R.id.text1);

        textView.setText(list.get(position));

        return  view;
    }
}
