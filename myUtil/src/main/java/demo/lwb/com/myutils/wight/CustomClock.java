package demo.lwb.com.myutils.wight;

import java.util.Calendar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;

public class CustomClock extends View {

	private Paint mPaint;
	private float mRadius = 200;
	private int second;
	private int minute;
	private int hour;

	public CustomClock(Context context, AttributeSet attrs) {
		super(context, attrs);

		// 初始化画笔
		initPaint();
		getTime();
	}

	private void getTime() {
		post(new Runnable() {

			@Override
			public void run() {
				// 获取实际时间
				Calendar calendar = Calendar.getInstance();
				hour = calendar.get(Calendar.HOUR_OF_DAY);
				minute = calendar.get(Calendar.MINUTE);
				second = calendar.get(Calendar.SECOND);
				// 刷新画布
				invalidate();
				postDelayed(this, 1000);
			}
		});
	}

	private void initPaint() {
		mPaint = new Paint();
		mPaint.setStyle(Style.STROKE);
		mPaint.setStrokeWidth(2);
		mPaint.setTextSize(20);
		mPaint.setAntiAlias(true);
		mPaint.setTextAlign(Align.CENTER);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		mPaint.setColor(Color.BLACK);
		// 获取画布的宽高
		int w = canvas.getWidth();
		int h = canvas.getHeight();
		// 移动画布
		canvas.translate(w / 2, h / 2);

		// 绘制静态表盘
		canvas.drawCircle(0, 0, mRadius, mPaint);

		// 绘制刻度
		for (int i = 0; i < 60; i++) {
			mPaint.setStrokeWidth(2);
			mPaint.setColor(Color.BLACK);

			if (i % 5 == 0) {// 绘制时针
				// 绘制时间文本
				int num = i / 5;
				if (num == 0) {
					num = 12;
				}
				// 保存画布坐标系
				canvas.save();
				canvas.translate(0, -(mRadius - 50));
				canvas.rotate(-30 * num);
				canvas.drawText(num + "", 0, 10, mPaint);
				// 恢复坐标系
				canvas.restore();
				canvas.drawLine(mRadius - 2, 0, mRadius - 20, 0, mPaint);
			} else {// 绘制秒针
				mPaint.setStrokeWidth(1);
				mPaint.setColor(Color.GRAY);
				canvas.drawLine(mRadius - 2, 0, mRadius - 15, 0, mPaint);
			}
			// 旋转画布 绘制刻度
			canvas.rotate(6);

		}

		mPaint.setStrokeWidth(5);
		mPaint.setColor(Color.BLUE);
		// 保存坐标系
		canvas.save();
		// 实际时间扣除当前坐标系已经转动的时间 +分钟走动的比例（角度）
		canvas.rotate((hour - 3) * 30 + (minute * 30 / 60));
		// 绘制时针
		canvas.drawLine(-10, 0, mRadius - 80, 0, mPaint);
		// 恢复坐标系
		canvas.restore();

		canvas.save();
		mPaint.setStrokeWidth(5);
		mPaint.setColor(Color.GREEN);
		canvas.rotate((minute - 15) * 6 + (second * 6 / 60));
		// 绘制分针
		canvas.drawLine(-10, 0, mRadius - 60, 0, mPaint);
		canvas.restore();

		canvas.save();
		mPaint.setStrokeWidth(3);
		mPaint.setColor(Color.RED);
		canvas.rotate((second - 15) * 6);
		// 绘制秒针
		canvas.drawLine(-10, 0, mRadius - 60, 0, mPaint);
		canvas.restore();

	}

}
