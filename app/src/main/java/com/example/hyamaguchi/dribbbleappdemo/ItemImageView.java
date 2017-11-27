package com.example.hyamaguchi.dribbbleappdemo;
import android.widget.ImageView;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.content.res.TypedArray;
import static java.sql.DriverManager.println;

/**
 * Created by h.yamaguchi on 2017/11/27.
 */

public class ItemImageView extends ImageView {

    public ItemImageView(Context context) {
        this(context, null);

        Log.d("tag","初期化1");
    }

    public ItemImageView(Context context, AttributeSet attrs) {
        this(context, attrs,0);

        Log.d("tag","初期化2");
    }

    public ItemImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        // このへんで初期化処理

        Log.d("tag","初期化3");

//        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ItemImageView);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        Log.d("tag","サイズ変更");
        int sideLength = 0;
        sideLength = getMeasuredWidth();
        setMeasuredDimension(sideLength, sideLength / 3);
    }
}
