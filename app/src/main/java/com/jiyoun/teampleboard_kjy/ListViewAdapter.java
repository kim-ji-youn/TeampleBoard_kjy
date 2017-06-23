package com.jiyoun.teampleboard_kjy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by kim Ji Youn on 2017-06-23.
 */

public class ListViewAdapter extends BaseAdapter{

    private ArrayList<ListViewItem> listViewItemList = new ArrayList<ListViewItem>();
    public ListViewAdapter(){}

    @Override
    public int getCount() {
        return listViewItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_item,parent, false);
        }

        TextView nameTextView = (TextView)convertView.findViewById(R.id.name);
        TextView dateTextView = (TextView)convertView.findViewById(R.id.date);

        ListViewItem listViewItem = listViewItemList.get(position);

        nameTextView.setText(listViewItem.getName());
        dateTextView.setText(listViewItem.getDate());

        return convertView;
    }

    public void addItem(String name, String date) {
        ListViewItem item = new ListViewItem();
        item.setName(name);
        item.setDate(date);

        listViewItemList.add(item);
    }
}
