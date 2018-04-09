package com.zcj.findpet.core.base;

import android.app.Activity;

import java.util.Stack;

/**
 * Created by cj_zu on 2018/4/3.
 */

public class AppManager {

    private Stack<Activity> mStack;

    private AppManager() {
        mStack = new Stack<>();
    }

    public static AppManager getInstance() {
        return InstanceHolder.sHolder;
    }

    public void push(Activity activity){
        mStack.add(activity);
    }

    public Activity pop(){
        return mStack.pop();
    }

    private static class InstanceHolder {
        public static AppManager sHolder = new AppManager();
    }
}
