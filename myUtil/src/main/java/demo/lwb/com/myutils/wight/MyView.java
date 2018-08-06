package demo.lwb.com.myutils.wight;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import demo.lwb.com.myutils.R;


/**
 * Created by Administrator on 2017/6/17.
 * 自定义控件  魔板
 *
 * 当在子线层刷新画布时  需new Thread(MyView控件的名).stard();
 */

public class MyView extends View implements Runnable{
    private int mRadius=5;
    private Paint mpaint;
    private int color;

    /**
     * 代码中实现
     * @param context
     */
    public MyView(Context context) {
        super(context);
    }

    /**
     * 布局中实现
     * @param context
     * @param attrs
     */
    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);

        initAttribute(context,attrs);
        //初始化画笔
        initPaint();
//        autoPlay();
    }

    /**
     * 自定义属性值
     * @param context
     * @param attrs
     */
    private void initAttribute(Context context,AttributeSet attrs) {
        // 获取属性值
        TypedArray typedArray = context.
                obtainStyledAttributes(attrs, R.styleable.CostomView);
        // 根据属性名称获取属性值 默认值
        mRadius = typedArray.getInteger(R.styleable.CostomView_radius, 200);
        color = typedArray.getColor(R.styleable.CostomView_bg, Color.BLUE);
        // 释放资源
        typedArray.recycle();
    }

    /**
     * 动态变化
     */
    private void autoPlay() {
        post(new Runnable() {
            @Override
            public void run() {
                if(mRadius>300){
                    mRadius=5;
                }
                mRadius+=10;
                postDelayed(this,100);
                //刷新画布
                invalidate();
            }
        });
    }

    /**
     * 初始化画笔
     */
    private void initPaint() {
        //创建画笔
        mpaint = new Paint();
        //设置画笔颜色
        mpaint.setColor(Color.BLUE);
        //风格 填充：fill 描边：stroke
        mpaint.setStyle(Style.FILL);
        //描边的宽度 单位：px像素
        mpaint.setStrokeWidth(5);
        //抗锯齿
        mpaint.setAntiAlias(true);
        //设置文本大小
        mpaint.setTextSize(50);
        //文本居中方式
        mpaint.setTextAlign(Paint.Align.CENTER);
    }

    /**
     * 绘制控件 canvas :画布
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画布的宽
        int width = canvas.getWidth();
        //画布的高
        int height = canvas.getHeight();
        canvas.drawCircle(width/2,height/2,mRadius,mpaint);
        //绘制图形
//        shape(canvas, width, height);

        //坐标系   旋转 移动 保存原来状态  回复
//        initBase(canvas, width, height);

    }

    /**
     * 触碰事件
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch (action){
            case MotionEvent.ACTION_DOWN://按下
                break;
            case MotionEvent.ACTION_HOVER_MOVE://移动
                break;
            case MotionEvent.ACTION_UP://恢复
                break;
            default:
                break;
        }

        return true;
    }

    /**
     * 坐标系
     * @param canvas
     * @param width
     * @param height
     */
    private void initBase(Canvas canvas, int width, int height) {
        //绘制圆形
        canvas.drawCircle(0,0,100,mpaint);
        //移动
        canvas.translate(200,200);
        //旋转
        canvas.rotate(45);
        //保存当前状态
        canvas.save();
        //恢复到保存的状态
        canvas.restore();
    }

    /**
     * 绘制图形
     * @param canvas
     * @param width
     * @param height
     */
    private void shape(Canvas canvas, int width, int height) {
        //绘制圆形 xy:圆心的坐标 radius：半径  paint :画笔
        canvas.drawCircle(width/2,height/2,200,mpaint);
        //绘制线 起始点 终止点 画笔
        canvas.drawLine(100,400,500,700,mpaint);
        //绘制矩形
        canvas.drawRect(100,100,400,400,mpaint);
        //绘制文本  X取决于文本的居中方式  Y到内容下划线的距离
        canvas.drawText("绘制内容",100,200,mpaint);
        //绘制图片
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        //left top 图片的位置
        canvas.drawBitmap(bitmap,100,300,mpaint);
    }

    @Override
    public void run() {
        if(mRadius>300){
            mRadius=5;
        }
        mRadius+=10;
        postDelayed(this,100);
        //子线程刷新画布
        postInvalidate();
    }

}
