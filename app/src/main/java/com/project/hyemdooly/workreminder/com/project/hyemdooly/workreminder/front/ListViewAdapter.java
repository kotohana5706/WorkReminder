package com.project.hyemdooly.workreminder.com.project.hyemdooly.workreminder.front;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.project.hyemdooly.workreminder.R;
import com.project.hyemdooly.workreminder.com.project.hyemdooly.workreminder.model.Work;

import io.realm.OrderedRealmCollection;
import io.realm.RealmBaseAdapter;

/**
 * Created by songhyemin on 2016. 9. 25..
 */

public class ListViewAdapter extends RealmBaseAdapter<Work> implements ListAdapter {
    int layout;
    LayoutInflater inflater;


    public ListViewAdapter(Context context, OrderedRealmCollection<Work> realmResults){
        super(context, realmResults);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView == null){
            convertView = inflater.inflate(this.layout, null);

        }
        TextView title = (TextView) convertView.findViewById(R.id.list_title);
        TextView category = (TextView) convertView.findViewById(R.id.list_category);
        TextView date = (TextView) convertView.findViewById(R.id.list_date);
        // TextView soon = (TextView) convertView.findViewById(R.id.list_soon);

        title.setText(adapterData.get(position).getTitle().toString());
        category.setText(adapterData.get(position).getCategory().toString());
        date.setText(adapterData.get(position).getDate().toString());

        return convertView;
    }
}
