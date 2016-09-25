package com.project.hyemdooly.workreminder;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private View dialogView;
    public static Context context;
    public static FragmentManager fragmentManager;
    public ArrayList<dataSetClass> listViewData = new ArrayList<dataSetClass>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        context = MainActivity.this;
        fragmentManager = getSupportFragmentManager();

        listViewData.add(new dataSetClass("Work Title", "Category", "8", "30", "2016", "9", "30"));
        listViewData.add(new dataSetClass("Work Title", "Category", "8", "30", "2016", "9", "30"));
        listViewData.add(new dataSetClass("Work Title", "Category", "8", "30", "2016", "9", "30"));
        listViewData.add(new dataSetClass("Work Title", "Category", "8", "30", "2016", "9", "30"));
        listViewData.add(new dataSetClass("Work Title", "Category", "8", "30", "2016", "9", "30"));
        listViewData.add(new dataSetClass("Work Title", "Category", "8", "30", "2016", "9", "30"));
        listViewData.add(new dataSetClass("Work Title", "Category", "8", "30", "2016", "9", "30"));
        listViewData.add(new dataSetClass("Work Title", "Category", "8", "30", "2016", "9", "30"));
        listViewData.add(new dataSetClass("Work Title", "Category", "8", "30", "2016", "9", "30"));
        listViewData.add(new dataSetClass("Work Title", "Category", "8", "30", "2016", "9", "30"));
        listViewData.add(new dataSetClass("Work Title", "Category", "8", "30", "2016", "9", "30"));

        ListViewAdapter adapter = new ListViewAdapter(context, R.layout.listview_item, listViewData);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.add_work_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Add your Work!", Toast.LENGTH_SHORT);
                // getApplicationContext : 현재 실행되고 있는 앱의 실행 환경

                LayoutInflater inflater = getLayoutInflater();
                dialogView = inflater.inflate(R.layout.add_work_dialog, null);
                // null 자리는 ViewGroup root

                DialogAddWork dialogAddWork = new DialogAddWork();
                dialogAddWork.showDialog(dialogView);


            }
        });

    }





}

