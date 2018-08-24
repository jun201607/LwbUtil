package demo.lwb.com.myutils.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

import demo.lwb.com.myutils.mvp.fragment.HomeTab1Fragment;
import demo.lwb.com.myutils.mvp.fragment.HomeTab2Fragment;
import demo.lwb.com.myutils.mvp.fragment.HomeTab3Fragment;

/**
 * Created by Administrator on 2017/12/23.
 * 首页viewPage适配
 */

public class ViewPagerHomeAdapter extends FragmentStatePagerAdapter{

    private List<Fragment> list_Fragment=new ArrayList<>();//viewpager中适配的 item

    public ViewPagerHomeAdapter(FragmentManager fm) {
        super(fm);
        list_Fragment.add(new HomeTab1Fragment());
        list_Fragment.add(new HomeTab2Fragment());
        list_Fragment.add(new HomeTab3Fragment());
    }

    @Override
    public Fragment getItem(int position) {
        return list_Fragment.get(position);
    }

    @Override
    public int getCount() {
        return list_Fragment.size();
    }
}
