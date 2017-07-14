package com.zly.account.view;

/**
 * 滑动菜单项
 */

public class SlideMenuItem {
    private int itemId;
    private String title;

    public SlideMenuItem(int i, String s) {
        this.itemId = i;
        this.title = s;
    }


    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
