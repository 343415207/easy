package com.moon.library.utils.statusbar;

import android.content.Context;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;

/**
 * 颜色工具类
 */

public class ColorUtils {
    @ColorInt
    public static int getColor(@NonNull Context context, @ColorRes int id) {
        return ResourcesCompat.getColor(context.getResources(), id, null);
    }
}
