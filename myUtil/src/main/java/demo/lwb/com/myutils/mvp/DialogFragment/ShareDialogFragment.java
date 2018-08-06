package demo.lwb.com.myutils.mvp.DialogFragment;

import android.app.Activity;
import android.app.DialogFragment;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import java.io.File;

import demo.lwb.com.myutils.R;

/**
 * 分享
 */
public class ShareDialogFragment extends DialogFragment implements View.OnClickListener {
    private final String TAG = "ShareDialogFragment";
    public ShareDialogFragment(){

    }

    public static final ShareDialogFragment newInstance(String url)
    {
        ShareDialogFragment fragment = new ShareDialogFragment();
        Bundle bundle = new Bundle();
//        bundle.putSerializable("OAuthUtils", OAuthUtils);
//        bundle.putString("url", url);
        fragment.setArguments(bundle);
        return fragment ;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        getDialog().getWindow().setBackgroundDrawable(new  ColorDrawable(Color.TRANSPARENT));//设置背景透明
        getDialog().getWindow().setWindowAnimations(R.style.menu_animation);//添加一组进出动画
        View view = inflater.inflate(R.layout.fragment_home_tab1, container, false);
        return view;
    }



    @Override
    public void onStart() {
        super.onStart();
        //设置弹出框宽屏显示，适应屏幕宽度
        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics( dm );
        getDialog().getWindow().setLayout( dm.widthPixels, getDialog().getWindow().getAttributes().height );
        //移动弹出菜单到底部
        WindowManager.LayoutParams wlp = getDialog().getWindow().getAttributes();
        wlp.gravity = Gravity.BOTTOM;
       // wlp.width = WindowManager.LayoutParams.MATCH_PARENT;
        getDialog().getWindow().setAttributes(wlp);
    }

    @Override
    public void onStop() {
        this.getView().setAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.menu_disappear));
        super.onStop();
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case 1:

                break;
        }
    }

}
