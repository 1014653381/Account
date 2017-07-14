package com.zly.account.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import com.zly.account.R;
import com.zly.account.activity.frame.FrameActivity;
import com.zly.account.adapter.AppGridAdapter;

public class MainActivity extends FrameActivity {

    private GridView main_body_gv;
    private AppGridAdapter gridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        appendMainBody(R.layout.main_body);
        initVariable();
        initView();
        initListeners();
        initData();
        createSlideMenu(R.array.SlideMenuActivityMain);
    }

    private void initData() {
        main_body_gv.setAdapter(gridAdapter);
    }

    private void initListeners() {
    }

    private void initVariable(){
        gridAdapter = new AppGridAdapter(this);
    }

    private void initView(){
        main_body_gv = (GridView) findViewById(R.id.main_body_gv);
    }
}
