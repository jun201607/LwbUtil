// Generated code from Butter Knife. Do not modify!
package demo.lwb.com.myutils.mvp.fragment;

import android.opengl.GLSurfaceView;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class OpenGl_SquareFragment_ViewBinding implements Unbinder {
  private OpenGl_SquareFragment target;

  @UiThread
  public OpenGl_SquareFragment_ViewBinding(OpenGl_SquareFragment target, View source) {
    this.target = target;

    target.gl_surface_square = Utils.findRequiredViewAsType(source, 2131755342, "field 'gl_surface_square'", GLSurfaceView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    OpenGl_SquareFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.gl_surface_square = null;
  }
}
