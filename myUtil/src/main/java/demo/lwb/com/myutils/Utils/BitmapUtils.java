package demo.lwb.com.myutils.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ThumbnailUtils;
import android.text.TextUtils;
import android.view.View;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;

/**
 * TODO 图片处理工具类
 * @author CPC
 * 1、Bitmap转化为Drawable
 * 2、Drawable转化为Bitmap
 * 3、获得Resources的Bitmap资源
 * 4、byte[] 字节 吗转为 Bitmap
 * 5、Bitmap 转为字节码 byte[]
 * 6、通过文件路径获取到bitmap
 * 7、压缩图片
 * 8、缩放/裁剪图片
 * 9、获得本地的图片
 * 10、获取当前屏幕截图，不包含状态栏
 * 11、根据资源id获取指定大小的Bitmap对象
 * 12、根据文件路径获取指定大小的Bitmap对象
 * 13、获取指定大小的Bitmap对象
 */
public class BitmapUtils
{
	/**
	 * 1、Bitmap转化为Drawable
	 * 
	 * @param bmp
	 * @return
	 */
	public static Drawable bitmap2Drawable(Bitmap bmp)
	{
		BitmapDrawable bd = new BitmapDrawable(bmp);
		return bd;
	}

	/**
	 * 2、Drawable转化为Bitmap
	 * @param d
	 * @return
	 */
	public static Bitmap drawable2Bitmap(Drawable d)
	{
		BitmapDrawable bd = (BitmapDrawable) d;
		Bitmap bm = bd.getBitmap();
		return bm;
	}

	/**
	 * 3、获得Resources的Bitmap资源
	 * 
	 * @param act
	 * @param resId
	 * @return
	 */
	public static Bitmap getBitmapFromResources(Activity act, int resId)
	{
		Resources res = act.getResources();
		return BitmapFactory.decodeResource(res, resId);
	}

	/**
	 * 4、byte[] 字节 吗转为 Bitmap
	 * 
	 * @param b
	 * @return
	 */
	public static Bitmap convertBytes2Bimap(byte[] b)
	{
		if (b.length == 0)
		{
			return null;
		}
		return BitmapFactory.decodeByteArray(b, 0, b.length);
	}

	/**
	 * 5、Bitmap 转为字节码 byte[]
	 * 
	 * @param bm
	 * @return
	 */
	public static byte[] convertBitmap2Bytes(Bitmap bm)
	{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		bm.compress(Bitmap.CompressFormat.PNG, 100, baos);
		return baos.toByteArray();
	}

	/**
	 * 6、通过文件路径获取到bitmap
	 * 
	 * @param path
	 * @param w
	 *            显示 的 宽
	 * @param h
	 *            显示的 高
	 * @return
	 */
	public static Bitmap getBitmapFromPath(String path, int w, int h)
	{
		BitmapFactory.Options opts = new BitmapFactory.Options();
		// 设置为ture只获取图片大小
		opts.inJustDecodeBounds = true;
		opts.inPreferredConfig = Bitmap.Config.ARGB_8888;
		// 返回为空
		BitmapFactory.decodeFile(path, opts);
		int width = opts.outWidth;
		int height = opts.outHeight;
		float scaleWidth = 0.f, scaleHeight = 0.f;
		if (width > w || height > h)
		{
			// 缩放
			scaleWidth = ((float) width) / w;
			scaleHeight = ((float) height) / h;
		}
		opts.inJustDecodeBounds = false;
		float scale = Math.max(scaleWidth, scaleHeight);
		opts.inSampleSize = (int) scale;
		WeakReference<Bitmap> weak = new WeakReference<Bitmap>(BitmapFactory.decodeFile(path, opts));
		return Bitmap.createScaledBitmap(weak.get(), w, h, true);
	}

	/**
	 * 7、压缩图片
	 * 
	 * @param srcPath
	 *            图片路径
	 * @param width
	 *            压缩的宽
	 * @param height
	 *            压缩的高
	 * @return
	 */
	public static Bitmap compressImageFromFile(String srcPath, int width, int height)
	{
		BitmapFactory.Options newOpts = new BitmapFactory.Options();
		newOpts.inJustDecodeBounds = true;// 只读边,不读内容
		Bitmap bitmap = BitmapFactory.decodeFile(srcPath, newOpts);

		newOpts.inJustDecodeBounds = false;
		// 读取出图片实际的宽高
		int w = newOpts.outWidth;
		int h = newOpts.outHeight;
		int be = 1;
		if (w > h && w > width)
		{
			be = (int) (w / width);
		}
		else if (w < h && h > height)
		{
			be = (int) (h / height);
		}
		if (be <= 0)
			be = 1;
		newOpts.inSampleSize = be;// 设置压缩比例

		newOpts.inPreferredConfig = Config.ARGB_8888;// 该模式是默认的,可不设
		newOpts.inPurgeable = true;// 同时设置才会有效
		newOpts.inInputShareable = true;// 当系统内存不够时候图片自动被回收

		bitmap = BitmapFactory.decodeFile(srcPath, newOpts);
		return bitmap;
	}

	/**
	 *  8、缩放/裁剪图片
	 * 
	 * @param bm
	 * @param newWidth
	 * @param newHeight
	 * @return
	 */
	public static Bitmap zoomImg(Bitmap bm, int newWidth, int newHeight)
	{
		// 获得图片的宽高
		int width = bm.getWidth();
		int height = bm.getHeight();
		// 计算缩放比例
		float scaleWidth = ((float) newWidth) / width;
		float scaleHeight = ((float) newHeight) / height;
		// 取得想要缩放的matrix参数
		Matrix matrix = new Matrix();
		matrix.postScale(scaleWidth, scaleHeight);
		// 得到新的图片
		Bitmap newbm = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, true);
		return newbm;
	}

	/**
	 *  9、获得本地的图片
	 * 
	 * @param url
	 * @return
	 */
	public static Bitmap getLoacalBitmap(String url)
	{

		try
		{
			FileInputStream fis = new FileInputStream(url);
			return BitmapFactory.decodeStream(fis); // /把流转化为Bitmap图片

		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 10获取当前屏幕截图，不包含状态栏
	 * 
	 * @param activity
	 * @return
	 */
	public static Bitmap snapShotWithoutStatusBar(Activity activity)
	{
		View view = activity.getWindow().getDecorView();
		view.setDrawingCacheEnabled(true);
		view.buildDrawingCache();
		Bitmap bmp = view.getDrawingCache();
		Rect frame = new Rect();
		activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
		int statusBarHeight = frame.top;

		int width = ScreenUtil.getScreenWidth(activity);
		int height = ScreenUtil.getScreenHeight(activity);
		Bitmap bp = null;
		bp = Bitmap.createBitmap(bmp, 0, statusBarHeight, width, height - statusBarHeight);
		view.destroyDrawingCache();
		return bp;
	}

	/**
	 *  11、根据资源id获取指定大小的Bitmap对象
	 * @param context   应用程序上下文
	 * @param id        资源id
	 * @param height    高度
	 * @param width     宽度
	 * @return
	 */
	public static Bitmap getBitmapFromResource(Context context, int id, int height, int width){
		BitmapFactory.Options options = new BitmapFactory.Options();
		options.inJustDecodeBounds = true;//只读取图片，不加载到内存中
		BitmapFactory.decodeResource(context.getResources(), id, options);
		options.inSampleSize = calculateSampleSize(height, width, options);
		options.inJustDecodeBounds = false;//加载到内存中
		Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), id, options);
		return bitmap;
	}
	/**
	 *  12、根据文件路径获取指定大小的Bitmap对象
	 * @param path      文件路径
	 * @param height    高度
	 * @param width     宽度
	 * @return
	 */
	public static Bitmap getBitmapFromFile(String path, int height, int width){
		if (TextUtils.isEmpty(path)) {
			throw new IllegalArgumentException("参数为空，请检查你选择的路径:" + path);
		}
		BitmapFactory.Options options = new BitmapFactory.Options();
		options.inJustDecodeBounds = true;//只读取图片，不加载到内存中
		BitmapFactory.decodeFile(path, options);
		options.inSampleSize = calculateSampleSize(height, width, options);
		options.inJustDecodeBounds = false;//加载到内存中
		Bitmap bitmap = BitmapFactory.decodeFile(path, options);
		return bitmap;
	}
	/**
	 *  13、获取指定大小的Bitmap对象
	 * @param bitmap    Bitmap对象
	 * @param height    高度
	 * @param width     宽度
	 * @return
	 */
	public static Bitmap getThumbnailsBitmap(Bitmap bitmap, int height, int width){
		if (bitmap == null) {
			throw new IllegalArgumentException("图片为空，请检查你的参数");
		}
		return ThumbnailUtils.extractThumbnail(bitmap, width, height);
	}
	/**
	 * 计算所需图片的缩放比例
	 * @param height    高度
	 * @param width     宽度
	 * @param options   options选项
	 * @return
	 */
	private static int calculateSampleSize(int height, int width, BitmapFactory.Options options){
		int realHeight = options.outHeight;
		int realWidth = options.outWidth;
		int heigthScale = realHeight / height;
		int widthScale = realWidth / width;
		if(widthScale > heigthScale){
			return widthScale;
		}else{
			return heigthScale;
		}
	}
}
