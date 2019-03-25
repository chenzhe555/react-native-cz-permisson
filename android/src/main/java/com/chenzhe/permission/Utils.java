package com.chenzhe.permission;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.content.ContextCompat;

import com.facebook.react.bridge.Callback;
import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.AndPermission;
import java.util.List;

public class Utils {

    public static final String PERMISSION_CAMERA = Manifest.permission.CAMERA;


    /**
     * 请求权限
     *
     * @param activity
     * @param permission
     * @param callback
     */
    public static void requestPermission(final Activity activity, final String permission, final Callback callback) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                AndPermission.with(activity)
                        .runtime()
                        .permission(permission)
                        .onGranted(new Action<List<String>>() {
                            @Override
                            public void onAction(List<String> data) {
                                if(callback != null){
                                    callback.invoke(1);
                                }
                            }
                        })
                        .onDenied(new Action<List<String>>() {
                            @Override
                            public void onAction(List<String> data) {
                                if(callback != null){
                                    callback.invoke(2);
                                }
                            }
                        })
                        .start();
            }
        });

    }


    private static boolean checkPermission(Activity activity, String permission) {
        return ContextCompat.checkSelfPermission(activity, permission)
                == PackageManager.PERMISSION_GRANTED;
    }


    /**
     * 是否有相机权限
     *
     * @param activity
     * @return
     */
    public static boolean hasCameraPermission(Activity activity) {
        return checkPermission(activity, PERMISSION_CAMERA);
    }

    /**
     * 是否有通知栏权限
     *
     * @param context
     * @return
     */
    public static boolean hasNotificationPermission(Context context) {
        return NotificationManagerCompat.from(context).areNotificationsEnabled();
    }


    /**
     * 打开通知栏权限设置页面
     *
     * @param
     * @return
     * @author yangxinyu
     * @date 2019.2.21 13:03:20
     */
    public static boolean openNotificationSetting(Context context) {
        String packageName = context.getPackageName();
        try {
            Intent intent = new Intent();
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O) {
                intent.setAction(Settings.ACTION_APP_NOTIFICATION_SETTINGS);
                intent.putExtra(Settings.EXTRA_APP_PACKAGE, packageName);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            } else if (Build.VERSION.SDK_INT == Build.VERSION_CODES.O) {
                intent.setAction(Settings.ACTION_APP_NOTIFICATION_SETTINGS);
                intent.putExtra("android.provider.extra.APP_PACKAGE", packageName);
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                intent.putExtra("app_package", packageName);
                intent.putExtra("app_uid", context.getApplicationInfo().uid);
            } else if (Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT) {
                intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                intent.addCategory(Intent.CATEGORY_DEFAULT);
                intent.setData(Uri.parse("package:" + packageName));
            } else {
                return false;
            }
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 是否有网络
     *
     * @param context
     * @return
     */
    public static boolean hasNetwork(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context
                .getApplicationContext().getSystemService(
                        Context.CONNECTIVITY_SERVICE);
        if (manager == null) {
            return false;
        }
        NetworkInfo networkinfo = manager.getActiveNetworkInfo();
        return networkinfo != null && networkinfo.isAvailable();
    }


    /**
     * 打开网络设置页面
     *
     * @param context
     */
    public static void openNetwork(Context context) {
        Intent intent = new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS);
        context.startActivity(intent);
    }

}
