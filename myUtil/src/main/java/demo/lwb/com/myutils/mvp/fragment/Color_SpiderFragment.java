package demo.lwb.com.myutils.mvp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import demo.lwb.com.myutils.R;
import demo.lwb.com.myutils.Utils.colorpicker.OnColorChangedListener;
import demo.lwb.com.myutils.Utils.colorpicker.OnColorSelectedListener;
import demo.lwb.com.myutils.Utils.colorpicker.slider.AlphaSlider;
import demo.lwb.com.myutils.Utils.colorpicker.slider.LightnessSlider;
import demo.lwb.com.myutils.Utils.colorpicker.spider.ColorPickerView;
import demo.lwb.com.myutils.Utils.colorpicker.spider.ModelSpider;
import demo.lwb.com.myutils.Utils.colorpicker.spider.RxCobwebView;
import demo.lwb.com.myutils.base.BaseFragment;
import demo.lwb.com.myutils.mvp.presenter.BasePresenter;

/**
 * 蛛网层级及颜色选取  来自RxTool
 */
public class Color_SpiderFragment extends BaseFragment implements SeekBar.OnSeekBarChangeListener {

    @BindView(R.id.cobweb_view)
    RxCobwebView cobwebView;
    @BindView(R.id.seekbar_level)
    SeekBar seekbarLevel;
    @BindView(R.id.seekbar_spider_number)
    SeekBar seekbarSpiderNumber;
    @BindView(R.id.color_picker_view)
    ColorPickerView colorPickerView;
    @BindView(R.id.v_lightness_slider)
    LightnessSlider vLightnessSlider;
    @BindView(R.id.v_alpha_slider)
    AlphaSlider vAlphaSlider;
    @BindView(R.id.color_picker_view_level)
    ColorPickerView colorPickerViewLevel;
    @BindView(R.id.v_lightness_slider_level)
    LightnessSlider vLightnessSliderLevel;
    @BindView(R.id.v_alpha_slider_level)
    AlphaSlider vAlphaSliderLevel;
    private String[] nameStrs = {
            "金钱", "能力", "美貌", "智慧", "交际",
            "口才", "力量", "智力", "体力", "体质",
            "敏捷", "精神", "耐力", "精通", "急速",
            "暴击", "回避", "命中", "跳跃", "反应",
            "幸运", "魅力", "感知", "活力", "意志"
    };

    @Override
    public void setMiddleTitle() {

    }

    @Override
    protected BasePresenter bindPresenter() {
        return null;
    }

    @Override
    protected int bindLayout() {
        return R.layout.fragment_color_spider;
    }

    @Override
    public void initView() {
        seekbarLevel.setOnSeekBarChangeListener(this);
        seekbarSpiderNumber.setOnSeekBarChangeListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public void popBackListener(int returnCode, Bundle bundle) {
        colorPickerView.addOnColorChangedListener(new OnColorChangedListener() {
            @Override
            public void onColorChanged(int selectedColor) {
                // Handle on color change
                cobwebView.setSpiderColor(selectedColor);
            }
        });
        colorPickerView.addOnColorSelectedListener(new OnColorSelectedListener() {
            @Override
            public void onColorSelected(int selectedColor) {
                //mCobwebView.setSpiderColor(selectedColor);
            }
        });
        colorPickerViewLevel.addOnColorChangedListener(new OnColorChangedListener() {
            @Override
            public void onColorChanged(int selectedColor) {
                cobwebView.setSpiderLevelColor(selectedColor);
            }
        });
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
        switch (seekBar.getId()) {
            case R.id.seekbar_level:
                cobwebView.setSpiderMaxLevel(progress + 1);
                break;
            case R.id.seekbar_spider_number:
                int number = progress + 1;
                List<ModelSpider> modelSpiders = new ArrayList<>();
                for (int i = 0; i < number; i++) {
                    modelSpiders.add(new ModelSpider(nameStrs[i], 1 + new Random().nextInt(cobwebView.getSpiderMaxLevel())));
                }
                cobwebView.setSpiderList(modelSpiders);
                break;
            default:
                break;
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
