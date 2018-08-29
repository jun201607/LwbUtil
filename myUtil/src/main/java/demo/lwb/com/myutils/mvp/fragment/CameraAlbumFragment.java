package demo.lwb.com.myutils.mvp.fragment;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.yalantis.ucrop.UCrop;
import com.yalantis.ucrop.UCropActivity;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.OnClick;
import demo.lwb.com.myutils.R;
import demo.lwb.com.myutils.Utils.ImageLoaderUtil;
import demo.lwb.com.myutils.Utils.LogUtils;
import demo.lwb.com.myutils.Utils.MyUtils;
import demo.lwb.com.myutils.Utils.PermissionUtils;
import demo.lwb.com.myutils.Utils.RxTool.RxPhotoTool;
import demo.lwb.com.myutils.Utils.dialog.RxDialogScaleView;
import demo.lwb.com.myutils.base.BaseFragment;
import demo.lwb.com.myutils.mvp.presenter.BasePresenter;

/**
 * 相机相册  裁剪 来自RxTool
 */
public class CameraAlbumFragment extends BaseFragment {
    int ResultCamera = 205;

    @BindView(R.id.btn_camera)
    Button btnCamera;
    @BindView(R.id.btn_photo_album)
    Button btnPhotoAlbum;
    @BindView(R.id.img_show)
    ImageView imgShow;
    private Uri resultUri;

    @Override
    public void setMiddleTitle() {

    }

    @Override
    protected BasePresenter bindPresenter() {
        return null;
    }

    @Override
    protected int bindLayout() {
        return R.layout.fragment_camera_album;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public void popBackListener(int returnCode, Bundle bundle) {

    }

    @OnClick({R.id.btn_camera, R.id.btn_photo_album})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_camera:
                if (PermissionUtils.checkPersmission(getActivity(), PermissionUtils.CAMERA)) {
                    RxPhotoTool.openCameraImage(this);
                } else {
                    PermissionUtils.requestPermissions(getActivity(), new String[]{PermissionUtils.CAMERA}, ResultCamera);
                }
                break;
            case R.id.btn_photo_album:
                RxPhotoTool.openLocalImage(this);
                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        LogUtils.e("" + requestCode);
        if (requestCode == ResultCamera) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                LogUtils.e("权限申请成功");
                RxPhotoTool.openCameraImage(this);
            } else {
                //用户勾选了不再询问
                //提示用户手动打开权限
                if (!ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), PermissionUtils.CAMERA)) {
                    MyUtils.toast("未开启拍照权限");
                }
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case RxPhotoTool.GET_IMAGE_FROM_PHONE://选择相册之后的处理
                if (resultCode == RESULT_OK) {
//                    RxPhotoTool.cropImage(ActivityUser.this, );// 裁剪图片
                    LogUtils.e(""+data.getData());
                    initUCrop(data.getData());
                }
                break;
            case RxPhotoTool.GET_IMAGE_BY_CAMERA://选择照相机之后的处理
                if (resultCode == RESULT_OK) {
                    /* data.getExtras().get("data");*/
//                    RxPhotoTool.cropImage(ActivityUser.this, RxPhotoTool.imageUriFromCamera);// 裁剪图片
                    initUCrop(RxPhotoTool.imageUriFromCamera);
                }
                break;
            case UCrop.REQUEST_CROP://UCrop裁剪之后的处理
                if (resultCode == RESULT_OK) {
                    resultUri = UCrop.getOutput(data);
                    LogUtils.e("裁剪之后" + resultUri);
                    ImageLoaderUtil.loadImage(imgShow, "" + resultUri);
//                    roadImageView(resultUri, mIvAvatar);
//                    RxSPTool.putContent(mContext, "AVATAR", resultUri.toString());
                } else if (resultCode == UCrop.RESULT_ERROR) {
                    final Throwable cropError = UCrop.getError(data);
                }
                break;
            case UCrop.RESULT_ERROR://UCrop裁剪错误之后的处理
                final Throwable cropError = UCrop.getError(data);
                break;
            default:
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    /**
     * 裁剪
     *
     * @param uri
     */
    private void initUCrop(Uri uri) {
        SimpleDateFormat timeFormatter = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.CHINA);
        long time = System.currentTimeMillis();
        String imageName = timeFormatter.format(new Date(time));

        Uri destinationUri = Uri.fromFile(new File(getActivity().getCacheDir(), imageName + ".jpeg"));

        UCrop.Options options = new UCrop.Options();
        //设置裁剪图片可操作的手势
        options.setAllowedGestures(UCropActivity.SCALE, UCropActivity.ROTATE, UCropActivity.ALL);
        //设置隐藏底部容器，默认显示
        //options.setHideBottomControls(true);
        //设置toolbar颜色
        options.setToolbarColor(ActivityCompat.getColor(getContext(), R.color.colorPrimary));
        //设置状态栏颜色
        options.setStatusBarColor(ActivityCompat.getColor(getContext(), R.color.colorPrimaryDark));

        //开始设置
        //设置最大缩放比例
        options.setMaxScaleMultiplier(5);
        //设置图片在切换比例时的动画
        options.setImageToCropBoundsAnimDuration(666);
        //设置裁剪窗口是否为椭圆
        //options.setCircleDimmedLayer(true);
        //设置是否展示矩形裁剪框
        // options.setShowCropFrame(false);
        //设置裁剪框横竖线的宽度
        //options.setCropGridStrokeWidth(20);
        //设置裁剪框横竖线的颜色
        //options.setCropGridColor(Color.GREEN);
        //设置竖线的数量
        //options.setCropGridColumnCount(2);
        //设置横线的数量
        //options.setCropGridRowCount(1);
        UCrop.of(uri, destinationUri)
                .withAspectRatio(1, 1)
                .withMaxResultSize(1000, 1000)
                .withOptions(options)
                .start(getActivity());
    }


    @OnClick(R.id.img_show)
    public void onViewClicked() {
        RxDialogScaleView rxDialogScaleView = new RxDialogScaleView(getActivity());
        rxDialogScaleView.setImage(resultUri);
        rxDialogScaleView.show();
    }
}
