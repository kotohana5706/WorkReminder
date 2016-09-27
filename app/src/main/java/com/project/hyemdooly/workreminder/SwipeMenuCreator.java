package com.project.hyemdooly.workreminder;

import android.content.Context;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuItem;

/**
 * Created by songhyemin on 2016. 9. 27..
 */

public class SwipeMenuCreator implements com.baoyz.swipemenulistview.SwipeMenuCreator{
    Context context;

    public SwipeMenuCreator(Context context){
        this.context = context;
    }


    @Override
    public void create(SwipeMenu menu){
        // Create EditButton
        SwipeMenuItem editItem = new SwipeMenuItem(context);
        editItem.setBackground(R.color.colorEditButton);
        editItem.setIcon(R.drawable.ic_edit_button);
        editItem.setWidth(180);

        menu.addMenuItem(editItem);

        // Create DeleteButton
        SwipeMenuItem deleteItem = new SwipeMenuItem(context);
        deleteItem.setBackground(R.color.colorDeleteButton);
        deleteItem.setIcon(R.drawable.ic_delete_button);
        deleteItem.setWidth(180);

        menu.addMenuItem(deleteItem);

    }

}
