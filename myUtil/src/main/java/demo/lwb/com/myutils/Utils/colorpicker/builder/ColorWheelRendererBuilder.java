package demo.lwb.com.myutils.Utils.colorpicker.builder;


import demo.lwb.com.myutils.Utils.colorpicker.renderer.ColorWheelRenderer;
import demo.lwb.com.myutils.Utils.colorpicker.renderer.FlowerColorWheelRenderer;
import demo.lwb.com.myutils.Utils.colorpicker.renderer.SimpleColorWheelRenderer;
import demo.lwb.com.myutils.Utils.colorpicker.spider.ColorPickerView;

/**
 * @author vondear
 * @date 2018/6/11 11:36:40 整合修改
 */
public class ColorWheelRendererBuilder {
    public static ColorWheelRenderer getRenderer(ColorPickerView.WHEEL_TYPE wheelType) {
        switch (wheelType) {
            case CIRCLE:
                return new SimpleColorWheelRenderer();
            case FLOWER:
                return new FlowerColorWheelRenderer();
                default:
                    break;
        }
        throw new IllegalArgumentException("wrong WHEEL_TYPE");
    }
}