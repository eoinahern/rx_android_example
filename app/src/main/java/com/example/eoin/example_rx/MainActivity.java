package com.example.eoin.example_rx;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.drawable.DrawableUtils;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public Observable<AppInfo> getApps()
    {

        return Observable.create(subscriber -> {

            List<AppInfoRich> apps = new ArrayList<>();

            final Intent mainIntent = new Intent(Intent.ACTION_MAIN,
                    null);

            mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
            List<ResolveInfo> infos = getPackageManager().queryIntentActivities(mainIntent,0);


            for(ResolveInfo info: infos)
            {
                apps.add(new AppInfoRich(this, info));
            }


                for(AppInfoRich appinfo :apps)
                {
                    Bitmap icon = Utils.drawableToBitmap(appinfo.getIcon());
                    String name = appinfo.getName();
                    String iconPath = mFilesDir + "/" + name;
                    Utils.storeBitmap(App.instance, icon, name);
                }







        });


    }
}
