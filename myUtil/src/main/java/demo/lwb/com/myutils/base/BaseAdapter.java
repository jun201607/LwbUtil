package demo.lwb.com.myutils.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

/**
 * Created by Administrator on 2017/11/13.
 */

public abstract class BaseAdapter<T extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<T>{
	public Context mycontext;
	public List datas;
	public BaseAdapter(Context context, List data) {
		this.datas=data;
		this.mycontext=context;
	}
	private static OnItemClickListener onItemClickListener;
	private static OnItemLongClickListener onItemLongClickListener;

	@Override
	public int getItemCount() {
		return datas.size();
	}

	public static interface OnItemClickListener<E> {
		void onItemClick(View view, E bean);
	}
	public static interface OnItemLongClickListener<E> {
		void onItemLongClick(View view, E bean);

	}
	public static interface OnItemClickListener1 {
		void onItemClick(View view,int pos);
	}
	public static interface OnItemLongClickListener1 {
		void onItemLongClick(View view, int pos);

	}

	public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
		this.onItemClickListener = onItemClickListener;
	}

	public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
		this.onItemLongClickListener = onItemLongClickListener;
	}

	public List getData(){
		return datas;
	}

	public void bindOnClickListener(final RecyclerView.ViewHolder holder, final int position){
		holder.itemView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (onItemClickListener != null) {
					onItemClickListener.onItemClick(holder.itemView, datas.get(position));
				}
			}
		});

	}
	public void bindOnLongClickListener(final RecyclerView.ViewHolder holder, final int position){
		holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				if (onItemLongClickListener != null) {
					onItemLongClickListener.onItemLongClick(holder.itemView, datas.get(position));
				}
				return true;
			}
		});
	}
}
