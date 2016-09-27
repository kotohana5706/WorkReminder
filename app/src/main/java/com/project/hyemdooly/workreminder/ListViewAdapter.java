package com.project.hyemdooly.workreminder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by songhyemin on 2016. 9. 25..
 */

public class ListViewAdapter extends BaseAdapter {
    Context context;
    int layout;
    ArrayList<DataSetClass> dataset;
    LayoutInflater inflater;

    public ListViewAdapter(Context context, int layout, ArrayList<DataSetClass> dataset){
        this.context = context;
        this.layout = layout;
        this.dataset = dataset;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void remove(int position){
        dataset.remove(position);
        dataChange();
    }

    public void dataChange(){
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return dataset.size();
    }

    @Override
    public Object getItem(int position){
        return dataset.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView == null){
            convertView = inflater.inflate(this.layout, null);

        }
        TextView title = (TextView) convertView.findViewById(R.id.list_title);
        TextView category = (TextView) convertView.findViewById(R.id.list_category);
        TextView datetime = (TextView) convertView.findViewById(R.id.list_datetime);
        TextView soon = (TextView) convertView.findViewById(R.id.list_soon);

        title.setText(dataset.get(position).workTitle.toString());
        category.setText(dataset.get(position).workCategory.toString());
        datetime.setText(dataset.get(position).year.toString()+"."+dataset.get(position).month.toString()+"."+dataset.get(position).day.toString()
                            +" "+dataset.get(position).hour.toString()+":"+dataset.get(position).minute.toString());
        // if(날짜가가까워질때) soon.setText("Soon");


        return convertView;
    }


}
