package demo.lwb.com.myutils.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import demo.lwb.com.myutils.R;
import demo.lwb.com.myutils.base.BaseAdapter;

/**
 * Created by lwb on 2018/3/30.
 */

public class SmartRefreshLayoutAdapter extends BaseAdapter<SmartRefreshLayoutAdapter.SmartRefreshHolder>{

    private  Context mContext;

    public SmartRefreshLayoutAdapter(Context context, List data) {
        super(context, data);
        mContext = context;
    }

    @Override
    public SmartRefreshHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_smart_refreshlayout, parent, false);
        return new SmartRefreshHolder(inflate);
    }

    @Override
    public void onBindViewHolder(SmartRefreshHolder holder, int position) {

    }

    class SmartRefreshHolder extends RecyclerView.ViewHolder{
        public SmartRefreshHolder(View itemView) {
            super(itemView);
        }
    }
}
