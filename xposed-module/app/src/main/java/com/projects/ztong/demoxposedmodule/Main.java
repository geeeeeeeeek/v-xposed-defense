package com.projects.ztong.demoxposedmodule;

import android.app.AndroidAppHelper;
import android.content.Context;
import android.widget.Toast;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class Main implements IXposedHookLoadPackage {

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        if (!lpparam.packageName.equals("com.cockroach.hook_object"))
            return;
        XposedBridge.log("Loaded app: " + lpparam.packageName);

        XposedHelpers.findAndHookMethod("com.projects.ztong.demoapp.demoActivity",
                lpparam.classLoader, "onDemoButtonClick", new XC_MethodReplacement() {
                    @Override
                    protected Object replaceHookedMethod(MethodHookParam methodHookParam) throws Throwable {
                        Context context = (Context) AndroidAppHelper.currentApplication();

                        Toast.makeText(context, "The app is hooked.", Toast.LENGTH_LONG).show();
                        return null;
                    }
                });
    }
}
