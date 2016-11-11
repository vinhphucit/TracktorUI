package com.roxwin.tracktor.utils;

import android.content.Context;
import android.graphics.Typeface;

import com.roxwin.tracktor.RxApplication;


public class TypefaceUtils {

    public static final String REGULAR = "fonts/SanFranciscoDisplay-Regular.otf";
    public static final String BOLD = "fonts/SanFranciscoDisplay-Bold.otf";
    public static final String UNIVERS_BOLD = "fonts/UniversLTStd-BoldCn.otf";

    private static Typeface sUniversBold;
    private static Typeface sBold;
    private static Typeface sRegular;

    public TypefaceUtils() {
    }

    public static Typeface getBold() {
        return Typeface.createFromAsset(RxApplication.getContext().getAssets(), BOLD);
    }

    public static Typeface getBold(Context context) {
        return getBold(context, false);
    }

    public static Typeface getBold(Context context, boolean flag) {
        if (sBold == null) {
            if (flag) {
                sBold = Typeface.SANS_SERIF;
            } else {
                sBold = Typeface.createFromAsset(context.getAssets(), BOLD);
            }
        }
        return sBold;
    }

    public static Typeface getUniversBold() {
        return Typeface.createFromAsset(RxApplication.getContext().getAssets(), UNIVERS_BOLD);
    }

    public static Typeface getUniversBold(Context context) {
        return getBold(context, false);
    }

    public static Typeface getUniversBold(Context context, boolean flag) {
        if (sUniversBold == null) {
            if (flag) {
                sUniversBold = Typeface.SANS_SERIF;
            } else {
                sUniversBold = Typeface.createFromAsset(context.getAssets(), UNIVERS_BOLD);
            }
        }
        return sUniversBold;
    }

    public static Typeface getRegular() {
        return Typeface.createFromAsset(RxApplication.getContext().getAssets(), REGULAR);
    }

    public static Typeface getRegular(Context context) {
        return getRegular(context, false);
    }

    public static Typeface getRegular(Context context, boolean flag) {
        if (sRegular == null) {
            if (flag) {
                sRegular = Typeface.SANS_SERIF;
            } else {
                sRegular = Typeface.createFromAsset(context.getAssets(), REGULAR);
            }
        }
        return sRegular;
    }
}
