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
 * Created by lwb on 2018/3/30.
 */

public class CardViewAdapter extends BaseAdapter<CardViewAdapter.CardViewHolder> {
    private Context mContext;
    public CardViewAdapter(Context context, List data) {
        super(context, data);
        this.mContext = context;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_cardview,parent,false);
        return new CardViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        String date= (String) datas.get(position);
        holder.tv_cardview_title.setText(date);
    }

    class CardViewHolder extends RecyclerView.ViewHolder {
        TextView tv_cardview_title;
        public CardViewHolder(View itemView) {
            super(itemView);
            tv_cardview_title = (TextView) itemView.findViewById(R.id.tv_cardview_title);
        }
    }
}
