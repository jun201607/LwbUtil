package demo.lwb.com.myutils.Utils.colorpicker.renderer;


import java.util.ArrayList;
import java.util.List;

import demo.lwb.com.myutils.Utils.colorpicker.ColorCircle;

/**
 * @author vondear
 * @date 2018/6/11 11:36:40 整合修改
 */
public abstract class AbsColorWheelRenderer implements ColorWheelRenderer {
    protected ColorWheelRenderOption colorWheelRenderOption;
    protected List<ColorCircle> colorCircleList = new ArrayList<>();

    @Override
    public void initWith(ColorWheelRenderOption colorWheelRenderOption) {
        this.colorWheelRenderOption = colorWheelRenderOption;
        this.colorCircleList.clear();
    }

    @Override
    public ColorWheelRenderOption getRenderOption() {
        if (colorWheelRenderOption == null) {
            colorWheelRenderOption = new ColorWheelRenderOption();
        }
        return colorWheelRenderOption;
    }

    @Override
    public List<ColorCircle> getColorCircleList() {
        return colorCircleList;
    }

    protected int getAlphaValueAsInt() {
        return Math.round(colorWheelRenderOption.alpha * 255);
    }

    protected int calcTotalCount(float radius, float size) {
        return Math.max(1, (int) ((1f - GAP_PERCENTAGE) * Math.PI / (Math.asin(size / radius)) + 0.5f));
    }
}