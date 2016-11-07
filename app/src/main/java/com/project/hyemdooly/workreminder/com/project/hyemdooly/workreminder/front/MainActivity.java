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
import com.project.hyemdooly.workreminder.com.project.hyemdooly.workreminder.model.Work;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {
    private View dialogView;
    public static Context context;
    public static FragmentManager fragmentManager;
    private Realm realm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        realm = Realm.getDefaultInstance();
        final RealmTouchData controller = new RealmTouchData(context);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        context = MainActivity.this;
        fragmentManager = getSupportFragmentManager();

        RealmResults<Work> works = realm.where(Work.class).findAll();

        final ListViewAdapter adapter = new ListViewAdapter(context, works);
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
                        // remove data
                        // notify data change
                        controller.deleteuserData(adapter.getItem(position).getTitle().toString());

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

    @Override
    protected void onDestroy(){
        super.onDestroy();
        realm.close();
    }


}
