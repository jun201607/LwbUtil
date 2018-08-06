package demo.lwb.com.myutils.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;
import demo.lwb.com.myutils.R;
import demo.lwb.com.myutils.Utils.BitmapUtils;
import demo.lwb.com.myutils.Utils.FileUtils;
import demo.lwb.com.myutils.Utils.TimeUtil;
import demo.lwb.com.myutils.base.BaseAdapter;
import demo.lwb.com.myutils.bean.MediaBean;

/**
 * Created by lwb on 2018/6/21.
 */

public class LocalVideoAdapter extends BaseAdapter<LocalVideoAdapter.LocalVideoViewHolder>{

    private Context mContext;
    public LocalVideoAdapter(Context context, List data) {
        super(context, data);
        this.mContext = context;
    }

    @Override
    public LocalVideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.adapter_local_video, parent, false);
        return new LocalVideoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(LocalVideoViewHolder holder, final int position) {
        final MediaBean media = (MediaBean) datas.get(position);
        holder.name.setText(media.getName());
        holder.size.setText(FileUtils.size(media.getSize()));
        holder.time.setText(TimeUtil.getSmartTime(media.getTime()));
        holder.caption.setBackground(BitmapUtils.bitmap2Drawable(media.getBitmap()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(v,media);
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                onItemLongClickListener.onItemLongClick(v,media);
                return true;
            }
        });

        holder.img_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayVideo.playVideo(media,position);
            }
        });
    }


    class LocalVideoViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView time;
        TextView size;
        LinearLayout caption;
        ImageView img_play;
        public LocalVideoViewHolder(View v) {
            super(v);
            name = (TextView) v.findViewById(R.id.tv_twoAdapter_name);
            time = (TextView) v.findViewById(R.id.tv_twoAdapter_time);
            size = (TextView) v.findViewById(R.id.tv_twoAdapter_size);
            caption = (LinearLayout) v.findViewById(R.id.img_twoAdapter_caption);
            img_play = (ImageView) v.findViewById(R.id.img_twoAdapter_play);

        }
    }

    private OnPlayVideo onPlayVideo;

    public void setOnPlayVideoListen(OnPlayVideo Video){
        onPlayVideo=Video;
    }

    public interface OnPlayVideo{
        void playVideo(MediaBean media,int pos);
    }
    private  OnItemClickListener onItemClickListener;
    private  OnItemLongClickListener onItemLongClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
    }

    public  interface OnItemClickListener<E> {
        void onItemClick(View view, E bean);
    }
    public  interface OnItemLongClickListener<E> {
        void onItemLongClick(View view, E bean);

    }
}
