package demo.lwb.com.myutils.Utils;

import android.app.Activity;
import android.content.Intent;

import me.nereo.multi_image_selector.MultiImageSelectorActivity;

public class ImageSeletUtils {

    /**
     * 图片选择器
     * @param activity
     * @param requestCode  返回码
     * @param maxNum    图片选择数量
     * @param selectedMode  单选MultiImageSelectorActivity.MODE_SINGLE  多选MultiImageSelectorActivity.MODE_MULTI
     */
    public static void select(Activity activity,int requestCode,int maxNum,int selectedMode ){
        MultiImageSelectorActivity.startSelect(activity, requestCode, maxNum, selectedMode);
    }

    /**
     * 结果返回
     */
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == REQUEST_IMAGE) {
//            if (resultCode == RESULT_OK) {
//                mSelectPath = data.getStringArrayListExtra(MultiImageSelectorActivity.EXTRA_RESULT);
//                StringBuilder sb = new StringBuilder();
//                for (String p : mSelectPath) {
//                    sb.append(p);
//                    sb.append("\n");
//                }
//                mResultText.setText(sb.toString());
//            }
//        }
//    }

}
