
package com.hnlc.tyswipelayout;

import android.app.Activity;
import android.app.ActivityOptions;
import android.os.Build;

import java.lang.reflect.Method;

/**
 * Created by Chaojun Wang on 6/9/14.
 */
public class Utils {
    private Utils() {
    }

    /**
     * Convert a translucent themed Activity
     * {@link android.R.attr#windowIsTranslucent} to a fullscreen opaque
     * Activity.
     * <p>
     * Call this whenever the background of a translucent Activity has changed
     * to become opaque. Doing so will allow the {@link android.view.Surface} of
     * the Activity behind to be released.
     * <p>
     * This call has no effect on non-translucent activities or on activities
     * with the {@link android.R.attr#windowIsFloating} attribute.
     */
    public static void convertActivityFromTranslucent(Activity activity) {
        try {
            Method method = Activity.class.getDeclaredMethod("convertFromTranslucent");
            method.setAccessible(true);
            method.invoke(activity);
        } catch (Throwable t) {
        }
    }

    /**
     * Convert a translucent themed Activity
     * {@link android.R.attr#windowIsTranslucent} back from opaque to
     * translucent following a call to
     * {@link #convertActivityFromTranslucent(Activity)} .
     * <p>
     * Calling this allows the Activity behind this one to be seen again. Once
     * all such Activities have been redrawn
     * <p>
     * This call has no effect on non-translucent activities or on activities
     * with the {@link android.R.attr#windowIsFloating} attribute.
     */
    public static void convertActivityToTranslucent(Activity activity) {
        try {
            Class<?>[] classes = Activity.class.getDeclaredClasses();
            Class<?> translucentConversionListenerClazz = null;
            for (Class clazz : classes) {
                if (clazz.getSimpleName().contains("TranslucentConversionListener")) {
                    translucentConversionListenerClazz = clazz;
                }
            }
            Method[] methods = Activity.class.getDeclaredMethods();
            //判断是否小于Android 5.0,解决Android5.0以上返回黑屏
            if (Build.VERSION.SDK_INT < 21) {
                Method method = Activity.class.getDeclaredMethod(
                        "convertToTranslucent",
                        translucentConversionListenerClazz);
                method.setAccessible(true);
                method.invoke(activity, new Object[] { null });
            } else {
                Method method = Activity.class.getDeclaredMethod(
                        "convertToTranslucent",
                        translucentConversionListenerClazz,
                        ActivityOptions.class);
                method.setAccessible(true);
                method.invoke(activity, new Object[] { null, null });
            }
        } catch (Throwable t) {
        }
    }
}
