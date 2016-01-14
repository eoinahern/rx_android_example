package com.example.eoin.example_rx;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created by Eoin on 13/01/2016.
 */


@Data
@Accessors(prefix = "m")
public class AppInfo implements Comparable<Object> {


    long mLastUpdateTime;
    String mName;
    String mIcon;


    public AppInfo(String name, String icon, long lastUpdateTime) {
        mName = name;
        mIcon = icon;
        mLastUpdateTime = lastUpdateTime;
    }

    @Override
    public int compareTo(Object another) {
        AppInfo f = (AppInfo) another;
        return getName().compareTo(f.getName());

    }

    public String getName()
    {
        return mName;
    }


}
