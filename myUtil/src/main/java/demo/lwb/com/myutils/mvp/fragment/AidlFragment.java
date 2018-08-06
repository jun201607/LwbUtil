package demo.lwb.com.myutils.mvp.fragment;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import demo.lwb.com.myutils.R;
import demo.lwb.com.myutils.Utils.LogUtils;
import demo.lwb.com.myutils.aidl.BinderPool;
import demo.lwb.com.myutils.aidl.IBookImpl;
import demo.lwb.com.myutils.aidl.IcomputeImpl;
import demo.lwb.com.myutils.base.BaseFragment;
import demo.lwb.com.myutils.bean.Book;
import demo.lwb.com.myutils.bean.IBookManager;
import demo.lwb.com.myutils.bean.Icompute;
import demo.lwb.com.myutils.mvp.presenter.BasePresenter;

/**
 * Created by lwb on 2018/4/18.
 * 使用AIDL跨进程通信
 */

public class AidlFragment extends BaseFragment {
    @BindView(R.id.et_number)
    EditText etNumber;
    @BindView(R.id.et_book_name)
    EditText etBookName;
    @BindView(R.id.ll_content)
    LinearLayout llContent;
    @BindView(R.id.btn_add)
    Button btnAdd;
    @BindView(R.id.ll_add)
    LinearLayout llAdd;

    private IBookManager iBookManager;

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
        return R.layout.fragment_aidl;
    }

    /**
     * UI显示方法，必须在子类onCreateView方法内调用
     */
    @Override
    public void initView() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                startAidl();
            }
        }).start();
    }

    private void startAidl() {
        BinderPool instance = BinderPool.getInstance(activity);
        IBinder iBinder = instance.queryBinder(BinderPool.BINDER_BOOK);
        iBookManager = IBookImpl.asInterface(iBinder);

        IBinder Binder_compute = instance.queryBinder(BinderPool.BINDER_COMPUTE);
        Icompute icompute = IcomputeImpl.asInterface(Binder_compute);
        try {
            LogUtils.e("iBookManager1"+ icompute.add(5,6));
        } catch (RemoteException e) {
            e.printStackTrace();
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

    @OnClick({R.id.btn_add, R.id.ll_add})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_add:
                Book book = new Book(Integer.parseInt(etNumber.getText().toString()), etBookName.getText().toString());
                try {
                    iBookManager.addBook(book);
                    List<Book> bookList = iBookManager.getBookList();
                    TextView textView = new TextView(activity);
                    textView.setText("序号：" + bookList.get(0).bookId + "\n" + "书名：" + bookList.get(0).bookName);
                    llAdd.addView(textView);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.ll_add:
                break;
        }
    }
}
