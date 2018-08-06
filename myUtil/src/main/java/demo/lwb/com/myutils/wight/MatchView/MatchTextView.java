package demo.lwb.com.myutils.wight.MatchView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;

import demo.lwb.com.myutils.R;
import demo.lwb.com.myutils.wight.MatchView.util.MatchView;


/**
 * TextView动画效果
 */
public class MatchTextView extends MatchView {

    String mContent;
    float mTextSize;
    int mTextColor;

    public MatchTextView(Context context) {
        super(context);
        init();
    }

    public MatchTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttrs(attrs);
    }

    public MatchTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(attrs);
    }

    void initAttrs(AttributeSet attrs) {
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.MatchTextView);
        mTextSize = a.getDimension(R.styleable.MatchTextView_textSize, 25);
        mTextColor = a.getColor(R.styleable.MatchTextView_textColor, Color.WHITE);
        mContent = a.getString(R.styleable.MatchTextView_text);
        init();
    }

    void init() {
        this.setBackgroundColor(Color.TRANSPARENT);
        if (!TextUtils.isEmpty(mContent)) {
            setTextColor(mTextColor);
            setTextSize(mTextSize);
            initWithString(mContent);
            show();
        }
    }


    public void setText(String text) {
        this.mContent = text;
        init();
    }

}
