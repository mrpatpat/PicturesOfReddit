package de.curlse.mrpatpat.picturesofreddit.view;

/**
 * Created by Adrian Endrich on 14.10.14.
 */

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class RectImageView extends ImageView {
    public RectImageView(final Context context) {
        super(context);
    }

    public RectImageView(final Context context,
                         final AttributeSet attrs) {
        super(context, attrs);
    }

    public RectImageView(final Context context,
                         final AttributeSet attrs, final int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(final int widthMeasureSpec,
                             final int heightMeasureSpec) {
        int width = getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec);
        setMeasuredDimension(width, width);
    }

    @Override
    protected void onSizeChanged(final int w, final int h, final int oldw,
                                 final int oldh) {
        super.onSizeChanged(w, w, oldw, oldh);
    }
}