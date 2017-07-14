package com.zly.account.view;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.zly.account.R;
import com.zly.account.adapter.SlideMenuAdapter;

import java.util.ArrayList;
import java.util.List;

import static com.zly.account.util.DensityUtil.dip2px;

/**
 * 滑动菜单
 */

public class SlideMenuView {
    private Activity activity;//调用哪个Activity 就传哪个Activity
    private List<SlideMenuItem> menuList;
    private boolean isClosed;//是否关闭
    private RelativeLayout bottomBoxLayout;//include标签布局


    public SlideMenuView(Activity activity) {
        this.activity = activity;
        initVariable();
        initView();
        initListeners();
        close();
    }

    //初始化监听
    private void initListeners() {
        bottomBoxLayout.setOnClickListener(new OnSlideMenuClick());
    }

    //监听菜单的点击事件
    private class OnSlideMenuClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            toggle();
        }
    }

    //开关方法  控制打开、关闭
    private void toggle(){
        if (isClosed){
            open();
        }else {
            close();
        }
    }

    //添加菜单项
    public void add(SlideMenuItem slideMenuItem){
        menuList.add(slideMenuItem);
    }

    //绑定数据源
    public void bindList(){

        SlideMenuAdapter adapter = new SlideMenuAdapter(activity,menuList);
        ListView listView = (ListView) activity.findViewById(R.id.slide_list_lv);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new OnSlideMenuItemClick());
    }
    private class OnSlideMenuItemClick implements AdapterView.OnItemClickListener {


        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        }
    }

    //打开菜单
    private void open(){
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.
                LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);

        layoutParams.addRule(RelativeLayout.BELOW,R.id.include_title);
        bottomBoxLayout.setLayoutParams(layoutParams);
        isClosed = false;
    }

    //关闭菜单
    private void close(){
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.
                LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                dip2px(activity,68));

        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        bottomBoxLayout.setLayoutParams(layoutParams);
        isClosed = true;
    }



    //初始化控件
    private void initView() {
        bottomBoxLayout = (RelativeLayout) activity.findViewById(R.id.include_bottom);

    }

    //初始化变量
    private void initVariable() {
        menuList = new ArrayList<>();
        isClosed = false;
    }


}
