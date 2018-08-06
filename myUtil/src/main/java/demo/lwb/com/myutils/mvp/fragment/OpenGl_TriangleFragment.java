package demo.lwb.com.myutils.mvp.fragment;

import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.widget.Toast;

import butterknife.BindView;
import demo.lwb.com.myutils.R;
import demo.lwb.com.myutils.Utils.OpenGLUitl;
import demo.lwb.com.myutils.adapter.MyRenderer;
import demo.lwb.com.myutils.base.BaseFragment;
import demo.lwb.com.myutils.mvp.presenter.BasePresenter;

/**
 * Created by lwb on 2018/6/19.
 * OpenGl_三角形
 */

public class OpenGl_TriangleFragment extends BaseFragment {
    @BindView(R.id.gl_surface_view)
    GLSurfaceView glSurfaceView;
    private boolean rendererSet=false;
    /**
     * Frament退栈监听
     *
     * @param returnCode 返回码
     * @param bundle
     */
    @Override
    public void popBackListener(int returnCode, Bundle bundle) {

    }

    /**
     * 中心的标题设置
     */
    @Override
    public void setMiddleTitle() {

    }

    /**
     * 绑定P层
     *
     * @return
     */
    @Override
    protected BasePresenter bindPresenter() {
        return null;
    }

    /**
     * 绑定界面
     *
     * @return
     */
    @Override
    protected int bindLayout() {
        return R.layout.fragment_opengl_triangle;
    }

    /**
     * UI显示方法，必须在子类onCreateView方法内调用
     */
    @Override
    public void initView() {
        if (OpenGLUitl.supportGLEs2(activity)) {
            glSurfaceView.setEGLContextClientVersion(2);
//            glSurfaceView.setRenderer(new MyRenderer(this));
            MyRenderer myRenderer = new MyRenderer(activity);
            glSurfaceView.setRenderer(myRenderer);
            rendererSet = true;
        } else {
            Toast.makeText(activity, R.string.No_SupportOpenGL2, Toast.LENGTH_SHORT).show();
            return;
        }
    }

    /**
     * data数据方法，必须在子类onCreateView方法内调用
     */
    @Override
    public void initData() {

    }

    /**
     * listener事件监听方法，必须在子类onCreateView方法内调用
     */
    @Override
    public void initListener() {

    }

    @Override
    public void onResume() {
        super.onResume();
        if (rendererSet) {
            glSurfaceView.onResume();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (rendererSet) {
            glSurfaceView.onPause();
        }
    }

}
