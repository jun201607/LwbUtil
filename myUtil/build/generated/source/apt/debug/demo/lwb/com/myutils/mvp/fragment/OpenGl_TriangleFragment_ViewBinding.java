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

public class OpenGl_TriangleFragment_ViewBinding implements Unbinder {
  private OpenGl_TriangleFragment target;

  @UiThread
  public OpenGl_TriangleFragment_ViewBinding(OpenGl_TriangleFragment target, View source) {
    this.target = target;

    target.glSurfaceView = Utils.findRequiredViewAsType(source, 2131755343, "field 'glSurfaceView'", GLSurfaceView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    OpenGl_TriangleFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.glSurfaceView = null;
  }
}
