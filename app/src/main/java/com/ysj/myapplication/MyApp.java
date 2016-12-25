package com.ysj.myapplication;

import android.app.Activity;
import android.app.Application;
import java.util.Stack;

/**
 * MyApp用来管理整个软件的栈
 * Created by pig on 2016/12/25.
 */

public class MyApp extends Application {
    //单例MyApp
    private static MyApp mInstance;
    private Stack<Activity> activityStack;
    private static MyApp getmInstance(){
        if (mInstance ==null){
            mInstance = new MyApp();
        }
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
       activityStack = new Stack<>();
    }



    //控制activity的事件

    public void pushInActivity(Activity activity){
        if (activityStack == null){
            activityStack = new Stack<>();
        }
        activityStack.add(activity);
    }
    public void pushOutActivity(Activity activity){
        if (activityStack !=null&&activityStack.size()>0){
            if (activity!=null){
                activityStack.remove(activity);
            }
        }
    }
    public Activity getLastActivity(){
        return activityStack.lastElement();
    }
    public void finishAllExcept(Activity exceptActivity){
        while (activityStack!=null){
            if (activityStack.size()>1){
                Activity activity = getLastActivity();
                if (activity == null){
                    break;
                }
                if (activity!=exceptActivity){
                    pushOutActivity(activity);
                }

            }
        }
    }
    public void finishAll(){
        if (activityStack!=null){
            while (activityStack.size()>0){
                Activity activity =getLastActivity();
                if (activity==null){
                    break;
                }
                pushOutActivity(activity);
            }
        }
    }

}
