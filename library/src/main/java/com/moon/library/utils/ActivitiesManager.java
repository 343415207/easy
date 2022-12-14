package com.moon.library.utils;

import android.app.Activity;
import android.app.ActivityManager;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class ActivitiesManager {

    private static final String TAG = "ActivitiesManager";
    private static Stack<Activity> mActivityStack;
    private static ActivitiesManager mActivitiesManager;

    private ActivitiesManager() {

    }

    public static ActivitiesManager getInstance() {
        if (null == mActivitiesManager) {
            mActivitiesManager = new ActivitiesManager();
            if (null == mActivityStack) {
                mActivityStack = new Stack<Activity>();
            }
        }
        return mActivitiesManager;
    }

    public int stackSize() {
        return mActivityStack.size();
    }

    public Activity getCurrentActivity() {
        Activity activity = null;

        try {
            activity = mActivityStack.lastElement();
        } catch (Exception e) {
            return null;
        }

        return activity;
    }

    public void popActivity() {
        Activity activity = mActivityStack.lastElement();
        if (null != activity) {
            activity.finish();
            mActivityStack.remove(activity);
            activity = null;
        }
    }

    public void popActivity(Activity activity) {
        if (null != activity) {
            mActivityStack.remove(activity);
            activity = null;
        }
    }

    public void pushActivity(Activity activity) {
        mActivityStack.add(activity);
    }

    public void popAllActivities() {
        while (!mActivityStack.isEmpty()) {
            Activity activity = getCurrentActivity();
            if (null == activity) {
                break;
            }
            activity.finish();
            popActivity(activity);
        }
    }

    public void popSpecialActivity(Class<?> cls) {
        try {
            Iterator<Activity> iterator = mActivityStack.iterator();
            Activity activity = null;
            while (iterator.hasNext()) {
                activity = iterator.next();
                if (activity.getClass().equals(cls)) {
                    activity.finish();
                    iterator.remove();
                    activity = null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * ??????cls??????????????????
     */
    public void popExceptActivity(Class<?> cls) {
        try {
            Iterator<Activity> iterator = mActivityStack.iterator();
            Activity activity = null;
            while (iterator.hasNext()) {
                activity = iterator.next();
                if (!activity.getClass().equals(cls)) {
                    activity.finish();
                    iterator.remove();
                    activity = null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void peekActivity() {
        for (Activity activity : mActivityStack) {
            if (null == activity) {
                break;
            }
        }
    }

    /**
     * ????????????activity??????????????????
     *
     * @param activity
     * @return
     */
    public static boolean isTopActivity(Activity activity) {
        ActivityManager manager = (ActivityManager) activity.getSystemService(Activity.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> runningTaskInfos = manager.getRunningTasks(1);
        if (runningTaskInfos != null && !runningTaskInfos.isEmpty()) {
            String name = runningTaskInfos.get(0).topActivity.getClassName();
            return name.equals(activity.getClass().getName());
        }
        return false;
    }

}
