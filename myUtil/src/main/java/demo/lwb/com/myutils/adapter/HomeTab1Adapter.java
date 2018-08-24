package demo.lwb.com.myutils.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import demo.lwb.com.myutils.R;
import demo.lwb.com.myutils.base.BaseAdapter;

/**
 * Created by Administrator on 2017/12/24.
 * 工具
 */

public class HomeTab1Adapter extends BaseAdapter<HomeTab1Adapter.HomeTab1Holder> {


    public HomeTab1Adapter(Context context, List<String> data) {
        super(context, data);
    }

    @Override
    public HomeTab1Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_tab1, null);
        HomeTab1Holder myViewHolder = new HomeTab1Holder(view);
        return myViewHolder;
    }


    @Override
    public void onBindViewHolder(HomeTab1Holder holder, int position) {
        List<String> data = getData();
        holder.tvItemHomeName.setText((position+1)+"→"+data.get(position));
        super.bindOnClickListener(holder, position);
        super.bindOnLongClickListener(holder, position);

    }


    @Override
    public int getItemCount() {
        return datas.size();
    }


    class HomeTab1Holder extends RecyclerView.ViewHolder {
        TextView tvItemHomeName;
        public HomeTab1Holder(View view) {
            super(view);
            tvItemHomeName = (TextView) view.findViewById(R.id.tv_item_home_name);
        }
    }
}
