package com.example.lizandra.projectdetectalzheimer_2.view;

import android.content.Intent;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;

import com.example.lizandra.projectdetectalzheimer_2.R;
/**
 * Created by LIZANDRA on 01/07/2017.
 */

public class MenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

    private int position;
    private View view;

    public MenuItemClickListener(View view, int position){
        this.position = position;
        this.view = view;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {

        switch(item.getItemId()){
            case (R.id.item_teste):
            {
                view.getContext().startActivity(new Intent(view.getContext(), Meem.class));
                break;
            }
            case (R.id.item_visualizar_cadastro):
            {
            }
        }

        return false;
    }
}
