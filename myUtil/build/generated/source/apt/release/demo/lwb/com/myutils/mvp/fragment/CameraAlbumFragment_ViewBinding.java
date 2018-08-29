// Generated code from Butter Knife. Do not modify!
package demo.lwb.com.myutils.mvp.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CameraAlbumFragment_ViewBinding implements Unbinder {
  private CameraAlbumFragment target;

  private View view2131755282;

  private View view2131755281;

  private View view2131755283;

  @UiThread
  public CameraAlbumFragment_ViewBinding(final CameraAlbumFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, 2131755282, "field 'btnPhotoAlbum' and method 'onViewClicked'");
    target.btnPhotoAlbum = Utils.castView(view, 2131755282, "field 'btnPhotoAlbum'", Button.class);
    view2131755282 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755281, "field 'btnCamera' and method 'onViewClicked'");
    target.btnCamera = Utils.castView(view, 2131755281, "field 'btnCamera'", Button.class);
    view2131755281 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755283, "field 'imgShow' and method 'onViewClicked'");
    target.imgShow = Utils.castView(view, 2131755283, "field 'imgShow'", ImageView.class);
    view2131755283 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    CameraAlbumFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.btnPhotoAlbum = null;
    target.btnCamera = null;
    target.imgShow = null;

    view2131755282.setOnClickListener(null);
    view2131755282 = null;
    view2131755281.setOnClickListener(null);
    view2131755281 = null;
    view2131755283.setOnClickListener(null);
    view2131755283 = null;
  }
}
