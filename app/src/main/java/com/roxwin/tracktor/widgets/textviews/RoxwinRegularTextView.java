package com.roxwin.tracktor.widgets.textviews;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.roxwin.tracktor.utils.TypefaceUtils;


public class RoxwinRegularTextView
        extends TextView {
    public RoxwinRegularTextView(Context paramContext) {
        super(paramContext);
        setTypeface(getTypeface(paramContext));
    }

    public RoxwinRegularTextView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        setTypeface(getTypeface(paramContext));
    }

    public RoxwinRegularTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        setTypeface(getTypeface(paramContext));
    }

    private Typeface getTypeface(Context paramContext) {
        return TypefaceUtils.getRegular(paramContext, isInEditMode());
    }
}
