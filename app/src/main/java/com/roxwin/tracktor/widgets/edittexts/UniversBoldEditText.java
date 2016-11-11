package com.roxwin.tracktor.widgets.edittexts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

import com.roxwin.tracktor.utils.TypefaceUtils;


public class UniversBoldEditText
        extends EditText {
    public UniversBoldEditText(Context paramContext) {
        super(paramContext);
        setTypeface(getTypeface(paramContext));
    }

    public UniversBoldEditText(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        setTypeface(getTypeface(paramContext));
    }

    public UniversBoldEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        setTypeface(getTypeface(paramContext));
    }

    private Typeface getTypeface(Context paramContext) {
        return TypefaceUtils.getUniversBold(paramContext, isInEditMode());
    }
}
