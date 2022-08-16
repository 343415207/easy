package com.moon.library.utils;

import android.content.Context;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;

/**
 * {@link android.graphics.Color}工具类
 */

public class ColorUtils {

    public static int getColor(@NonNull Context context, @ColorRes int id) {
        return ResourcesCompat.getColor(context.getResources(), id, null);
    }

}
