package com.android.bmoblibrary;

import android.app.Application;

/**
 * author: Rea.X
 * date: 2017/12/18.
 */

public class Library {

    public static void init(Application app){
        Library.app = app;
    }

    private static Application app;
    public static Application get(){
        return app;
    }

    public static boolean isDebug() {
        return true;
    }
}
