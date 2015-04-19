package primstudios.com.shipit.CustomComponents;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.EditText;

public class MyCustomEditText extends EditText {

    private Rect mRect;
    private Paint mPaint;

    public MyCustomEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        mRect = new Rect();
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        int aColor = Color.parseColor("#dedede");
        mPaint.setColor(aColor);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int height = getHeight();
        int line_height = getLineHeight();
        int count = height / line_height;
        if (getLineCount() > count) {
            count = getLineCount();
        }
        Rect r = mRect;
        Paint paint = mPaint;
        int baseline = getLineBounds(0, r);
        for (int i = 0; i < count - 1; i++) {
            canvas.drawLine(r.left, baseline + 1, r.right, baseline + 1, paint);
            baseline += getLineHeight();
        }
        super.onDraw(canvas);
    }
}