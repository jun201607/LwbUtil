/*Copyright ©2015 TommyLemon(https://github.com/TommyLemon)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.*/

package demo.lwb.com.myutils.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;

import demo.lwb.com.myutils.Utils.StringUtil;
import demo.lwb.com.myutils.bean.ThreadBean;

/**TODO 线程管理类
 * @author Lemon
 * @use ThreadManager.getInstance().runThread(...);
 * 		在使用ThreadManager的Context被销毁前ThreadManager.getInstance().destroyThread(...);
 *      在应用退出前ThreadManager.getInstance().finish();
 */
public class ThreadManager {
	private static final String TAG = "ThreadManager";

	private Map<String, ThreadBean> threadMap;
	private ThreadManager() {
		threadMap = new HashMap<String, ThreadBean>();
	}

	private static ThreadManager threadManager;
	public static ThreadManager getInstance() {
		if (threadManager == null) {
			threadManager = new ThreadManager();
		}

		return threadManager;
	}


	/**TODO 运行线程
	 * @param name
	 * @param runnable
	 * @return
	 */
	public Handler runThread(String name, Runnable runnable) {
		if (StringUtil.isNotEmpty(name, true) == false || runnable == null) {
			Log.e(TAG, "runThread  StringUtil.isNotEmpty(name, true) == false || runnable == null >> return");
			return null;
		}
		name = StringUtil.getTrimedString(name);
		Log.d(TAG, "\n runThread  name = " + name);

		Handler handler = getHandler(name);
		if (handler != null) {
			Log.w(TAG, "handler != null >>  destroyThread(name);");
			destroyThread(name);
		}

		HandlerThread thread = new HandlerThread(name);
		thread.start();//创建一个HandlerThread并启动它
		handler = new Handler(thread.getLooper());//使用HandlerThread的looper对象创建Handler
		handler.post(runnable);//将线程post到Handler中

		threadMap.put(name, new ThreadBean(name, thread, runnable, handler));

		Log.d(TAG, "runThread  added name = " + name + "; threadMap.size() = " + threadMap.size() + "\n");
		return handler;
	}

	/**TODO 获取线程Handler
	 * @param name
	 * @return
	 */
	private Handler getHandler(String name) {
		ThreadBean tb = getThread(name);
		return tb == null ? null : tb.getHandler();
	}

	/**TODO 获取线程
	 * @param name
	 * @return
	 */
	public ThreadBean getThread(String name) {
		return name == null ? null : threadMap.get(name);
	}


	/**TODO 销毁线程
	 * @param name
	 * @return
	 */
	public void destroyThread(List<String> nameList) {
		if (nameList != null) {
			for (String name : nameList) {
				destroyThread(name);
			}
			nameList = null;
		}
	}
	/**TODO 销毁线程
	 * @param name
	 * @return
	 */
	public void destroyThread(String name) {
		destroyThread(getThread(name));
	}
	/**TODO 销毁线程
	 * @param tb
	 * @return
	 */
	private void destroyThread(ThreadBean tb) {
		if (tb == null) {
			Log.e(TAG, "destroyThread  tb == null >> return;");
			return;
		}

		destroyThread(tb.getHandler(), tb.getRunnable());
		if (tb.getName() != null) { // StringUtil.isNotEmpty(tb.getName(), true)) {
			threadMap.remove(tb.getName());
		}
		tb = null;
	}
	/**TODO 销毁线程
	 * @param handler
	 * @param runnable
	 * @return
	 */
	public void destroyThread(Handler handler, Runnable runnable) {
		if (handler == null || runnable == null) {
			Log.e(TAG, "destroyThread  handler == null || runnable == null >> handler = null;runnable = null;return;");
			handler = null;
			runnable = null;
			return;
		}

		try {
			handler.removeCallbacks(runnable);
		} catch (Exception e) {
			Log.e(TAG, "onDestroy try { handler.removeCallbacks(runnable);...  >> catch  : " + e.getMessage());
		}
		handler = null;
		runnable = null;
	}


	/**TODO 结束ThreadManager所有进程
	 */
	public void finish() {
		threadManager = null;
		if (threadMap == null || threadMap.keySet() == null) {
			Log.d(TAG, "finish  threadMap == null || threadMap.keySet() == null >> return;");
			return;
		}
		List<String> nameList = new ArrayList<String>(threadMap.keySet());//直接用Set在系统杀掉应用时崩溃
		if (nameList != null) {
			for (String name : nameList) {
				destroyThread(name);
			}
		}
		threadMap = null;
		Log.d(TAG, "\n finish  finished \n");
	}


}
