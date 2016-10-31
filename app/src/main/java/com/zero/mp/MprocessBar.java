package com.zero.mp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2016/10/31.
 */

public class MprocessBar extends View{
    private Paint paint;
    int pressure=0;

    public MprocessBar(Context context) {
        super(context);
        init();
    }

    public MprocessBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MprocessBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint=new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(pressure<40){
            paint.setColor(Color.GREEN);
        }else if(pressure <80){
            paint.setColor(Color.YELLOW);
        }else{
            paint.setColor(Color.RED);
        }
        canvas.drawRect(50, 200-pressure, 100, 200, paint);//前面两参数是左上角的点，而
        canvas.drawText("当前压力值"+pressure, 50, 50, paint);
        paint.setTextSize(25);
    }
    //提供给外部类使用的方法。
    public void setPressure(int pressure){
        this.pressure = pressure;
        //invalidate只能在主线程调用 子线程用postInvalidate()
        //invalidate();
        postInvalidate();
    }
}
