package com.example.guojian.zhuhuribao.util;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by guojian on 2017/5/19.
 */

public class LogToastUtils {

    private static Toast toast;
    private static String TAG = "ZhuhuLogUtils";

    /**
     * 短时间显示  Toast
     *
     * @param context
     * @param sequence
     */
    public static void showShort(Context context, CharSequence sequence) {

        if (toast == null) {
            toast = Toast.makeText(context, sequence, Toast.LENGTH_SHORT);

        } else {
            toast.setText(sequence);
        }
        toast.show();

    }


    public static void logUtils(String msg) {
        Log.i(TAG,msg);
    }
}
