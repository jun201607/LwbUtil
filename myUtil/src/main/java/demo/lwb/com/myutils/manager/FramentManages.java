package demo.lwb.com.myutils.manager;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import demo.lwb.com.myutils.R;
import demo.lwb.com.myutils.base.BaseFragment;
import demo.lwb.com.myutils.base.BaseFragmentActivity;
import demo.lwb.com.myutils.mvp.fragment.AidlFragment;
import demo.lwb.com.myutils.mvp.fragment.AnimationTextViewFragment;
import demo.lwb.com.myutils.mvp.fragment.BottomNavigationBarFragment;
import demo.lwb.com.myutils.mvp.fragment.CardViewFragment;
import demo.lwb.com.myutils.mvp.fragment.ContentProviderFragment;
import demo.lwb.com.myutils.mvp.fragment.DownloadFragment;
import demo.lwb.com.myutils.mvp.fragment.DrawerLayoutFragment;
import demo.lwb.com.myutils.mvp.fragment.EventBusFragment;
import demo.lwb.com.myutils.mvp.fragment.FloatingActionFragment;
import demo.lwb.com.myutils.mvp.fragment.HomeTab1DetailFragment;
import demo.lwb.com.myutils.mvp.fragment.JellyViewPagerFragment;
import demo.lwb.com.myutils.mvp.fragment.LabelViewFragment;
import demo.lwb.com.myutils.mvp.fragment.Local_VideoDetailFragment;
import demo.lwb.com.myutils.mvp.fragment.Local_VideoFragment;
import demo.lwb.com.myutils.mvp.fragment.MagicindicatorFragment;
import demo.lwb.com.myutils.mvp.fragment.MessengerFragment;
import demo.lwb.com.myutils.mvp.fragment.MyFragment;
import demo.lwb.com.myutils.mvp.fragment.OpenGl_SquareFragment;
import demo.lwb.com.myutils.mvp.fragment.OpenGl_TriangleFragment;
import demo.lwb.com.myutils.mvp.fragment.SmartRefreshLayoutFragment;
import demo.lwb.com.myutils.mvp.fragment.SwipeCardFragment;
import demo.lwb.com.myutils.mvp.fragment.TitanicFragment;
import demo.lwb.com.myutils.mvp.fragment.ToolbarFragment;


/**
 * 对所有片段操作的管理
 * @author WESTAKE
 *
 */
public class FramentManages
{
	private ArrayList<BaseFragment> list_Frament;// 保存当前Activity的Frament
	public FragmentManager fm;// 片段管理器
	/**
	 *  片段名
	 */
	public final static String MyFragment="我的片段";
	public final static String UtilsDetail="工具详情";
	public final static String Titanic="水波纹TextView";
	public final static String AnimationTextView="动画TextView";
	public final static String LabelView="标签LabelView";
	public final static String EventBus="EventBus";
	public final static String DownloadUtils="DownloadUtils";
	public final static String Toolbar="Toolbar";
	public final static String DrawerLayout="滑动菜单DrawerLayout";
	public final static String FloatingActionButton="悬浮按钮FloatingActionButton";
	public final static String CardView="卡片式布局CardView";
	public final static String SmartRefreshLayout="下拉刷新上拉加载SmartRefreshLayout";
	public final static String Messenger="使用Messenger跨进程通信";
	public final static String AIDL="使用AIDL跨进程通信";
	public final static String ContentProvider="使用ContentProvider跨进程通信";
	public final static String BottomNavigationBar="底部导航栏BottomNavigationBar";
	public final static String Magicindicator="指示器Magicindicator";
	public final static String jellyViewPager="可拖动jellyViewPager";
	public final static String SwipeCard="层叠式卡片SwipeCard";
	public final static String OpenGl_Triangle="OpenGl三角形";
	public final static String OpenGl_Square="OpenGl矩形";
	public final static String Local_Video="本地视频";
	public final static String Local_VideoDetail="视频播放";

	/**
	 * 这个在Fragment中不能new出来,只能在Activity中new，每个Activity对应一个List_fragment来管理
	 */
	public FramentManages(BaseFragmentActivity activity)
	{
		list_Frament = new ArrayList<>();
		fm = activity.getSupportFragmentManager();
	}

	private BaseFragment getFrament(Activity activity, String alias)
	{
		switch (alias)
		{
			default:
				return null;
			case FramentManages.MyFragment://主界面
				return new MyFragment();
			case FramentManages.UtilsDetail://工具详情界面
				return new HomeTab1DetailFragment();
			case FramentManages.Titanic://水波纹TextView
				return new TitanicFragment();
			case FramentManages.AnimationTextView://动画TextView
				return new AnimationTextViewFragment();
			case FramentManages.LabelView:
				return new LabelViewFragment();
			case FramentManages.EventBus:
				return new EventBusFragment();
			case FramentManages.DownloadUtils:
				return new DownloadFragment();
			case FramentManages.Toolbar:
				return new ToolbarFragment();
			case FramentManages.DrawerLayout:
				return new DrawerLayoutFragment();
			case FramentManages.FloatingActionButton:
				return new FloatingActionFragment();
			case FramentManages.CardView:
				return new CardViewFragment();
			case FramentManages.SmartRefreshLayout:
				return new SmartRefreshLayoutFragment();
			case FramentManages.Messenger:
				return new MessengerFragment();
			case FramentManages.AIDL:
				return new AidlFragment();
			case FramentManages.ContentProvider:
				return new ContentProviderFragment();
			case FramentManages.BottomNavigationBar:
				return new BottomNavigationBarFragment();
			case FramentManages.Magicindicator:
				return new MagicindicatorFragment();
			case FramentManages.jellyViewPager:
				return new JellyViewPagerFragment();
			case FramentManages.SwipeCard:
				return new SwipeCardFragment();
			case FramentManages.OpenGl_Triangle:
				return new OpenGl_TriangleFragment();
			case FramentManages.OpenGl_Square:
				return new OpenGl_SquareFragment();
			case FramentManages.Local_Video:
				return new Local_VideoFragment();
			case FramentManages.Local_VideoDetail:
				return new Local_VideoDetailFragment();
		}
	}

	/**
	 * 替换Frament 这里先删除再添加，完成替换操作
	 *
	 * @param viewId
	 *            Frament 放置的FramentLayout
	 * @param activity
	 * @param alias
	 *            别名
	 */
	public void replaceFrament(int viewId, BaseFragmentActivity activity, String alias)
	{

		BaseFragment base = getFrament(activity, alias);
		if (base == null)
		{
			return;
		}
		popBackStack();
		list_Frament.add(base);
		fm.beginTransaction()
				// 添加Frament
				.add(viewId, base).addToBackStack(null)
				// 提交
				.commit();

	}

	/**
	 * 添加Frament
	 *
	 * @param viewId
	 *            Frament 放置的FramentLayout的id
	 * @param activity
	 *            对应的Activity
	 * @param alias
	 *            别名，用于管理Fragment的名字
	 * @param bundle
	 *            传递的参数，如果不传，设置null即可
	 * @param isAnim
	 *            是否添加动画
	 */
	public void addFrament(int viewId, BaseFragmentActivity activity, String alias,
						   Bundle bundle, boolean isAnim)
	{
		BaseFragment base = getFrament(activity, alias);
		if (base == null)
		{
			return;
		}
		list_Frament.add(base);
		if (bundle != null)
		{
			base.setArguments(bundle);
		}
		FragmentTransaction bt = fm.beginTransaction();
		if (isAnim)
		{
			// 添加动画
			bt.setCustomAnimations(R.anim.push_left_in, R.anim.push_left_out,
					R.anim.push_right_in, R.anim.push_right_out);
		}
		// 添加Frament
		bt.add(viewId, base)
				// 添加到后退栈中
				.addToBackStack(null)
				// 提交
				.commitAllowingStateLoss();
	}

	public void popBackStack()
	{

		if (list_Frament.size() > 1)
		{
			// 从后退栈中弹出
			fm.popBackStack();
			list_Frament.remove(list_Frament.size() - 1);
		}
	}

	/**
	 * 获取上一个片段
	 *
	 * @return
	 */
	public BaseFragment getLastFrament()
	{
		if (list_Frament.size() - 1 >= 0)
		{
			return list_Frament.get(list_Frament.size() - 1);
		} else
		{
			return null;
		}
	}

	/**
	 * 获取当前Activity的所有片段 Fragment
	 *
	 * @return
	 */
	public ArrayList<BaseFragment> getAllFrament()
	{
		return list_Frament;
	}

	/**
	 * 清除当前Activity的所有片段 Fragment
	 */
	public void clearAllFrament()
	{
		for (int i = 0; i < list_Frament.size(); i++)
		{
			popBackStack();
		}
		list_Frament.clear();
	}
}
