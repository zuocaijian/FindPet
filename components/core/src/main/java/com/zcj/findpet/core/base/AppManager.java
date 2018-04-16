package com.zcj.findpet.core.base;

import android.app.Activity;

import java.util.Stack;

/**
 * Created by cj_zu on 2018/4/3.
 */

public class AppManager {

    private final Stack<Activity> STACK;

    private AppManager() {
        STACK = new Stack<>();
    }

    public static AppManager getInstance() {
        return InstanceHolder.HOLDER;
    }

    public void push(Activity activity) {
        STACK.add(activity);
    }

    public Activity pop() {
        return STACK.pop();
    }

    public void pop(Activity activity) {
        if (!isEmpty()) {
            STACK.remove(activity);
            activity.finish();
        }
    }

    public boolean isEmpty() {
        return STACK == null || STACK.isEmpty();
    }

    private static class InstanceHolder {
        public static final AppManager HOLDER = new AppManager();
    }
}
