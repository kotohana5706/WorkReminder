package com.project.hyemdooly.workreminder.com.project.hyemdooly.workreminder.front;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.project.hyemdooly.workreminder.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private View dialogView;
    public static Context context;
    public static FragmentManager fragmentManager;
    public static ArrayList<DataSetClass> listViewData = new ArrayList<DataSetClass>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        context = MainActivity.this;
        fragmentManager = getSupportFragmentManager();


        final ListViewAdapter adapter = new ListViewAdapter(context, R.layout.listview_item, listViewData);
        final com.baoyz.swipemenulistview.SwipeMenuListView listView = (SwipeMenuListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);


        com.baoyz.swipemenulistview.SwipeMenuCreator creator = new SwipeMenuCreator(context);
        listView.setMenuCreator(creator);

        listView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                switch (index) {
                    case 0:

                        break;
                    case 1:
                        listViewData.remove(position);
                        adapter.dataChange();
                        break;

                }
                return false;
            }
        });




        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.add_work_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Add your Work!", Toast.LENGTH_SHORT);
                // getApplicationContext : 현재 실행되고 있는 앱의 실행 환경

                LayoutInflater inflater = getLayoutInflater();
                dialogView = inflater.inflate(R.layout.add_work_dialog, null);
                // null 자리는 ViewGroup root

                DialogAddWork dialogAddWork = new DialogAddWork(adapter);
                dialogAddWork.showDialog(dialogView);


            }
        });

    }

}

