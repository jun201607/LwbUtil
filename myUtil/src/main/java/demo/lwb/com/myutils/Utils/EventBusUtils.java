package demo.lwb.com.myutils.Utils;

import android.content.Context;


import org.greenrobot.eventbus.EventBus;

import demo.lwb.com.myutils.mvp.message.MessageEvent;

/**
 * Created by lwb on 2018/6/6.
 * TODO EventBus
 */

public class EventBusUtils {
    /**
     * 注册
     * @param context
     */
    public static void register(Context context){
        EventBus.getDefault().register(context);
    }

    /**
     * 注销
     * @param context
     */
    public static void unregister(Context context){
        EventBus.getDefault().unregister(context);
    }
    /**
     * 发布事件
     * @param str
     */
    public static void unregister(String str){
        EventBus.getDefault().post(new MessageEvent(str));
    }

    /**
     * 订阅者方法将在主线程（UI线程）中被调用。因此，可以在该模式的订阅者方法中直接更新UI界面。
     * 如果发布事件的线程是主线程，那么该模式的订阅者方法将被直接调用。
     * 使用该模式的订阅者 方法必须快速返回，以避免阻塞主线程。
     * @param event
     */
//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void onMessageEvent(MessageEvent event){
//        LogUtils.e(event.message);
//    }

    /**
     * 订阅者将在发布该事件的同一线程中被调用。这是默认设置。事件传递是同步完成的，一旦发布事件，所有该模式的订阅者方法都将被调用。
     * 这种线程模式意味着最小的开销，因为它避免了完全的线程切换。因此，对于已知完成的简单任务而言，这是推荐的模式，
     * 因此，对于不要求是主线程并且耗时很短的简单任务推荐使用该模式。使用该模式的订阅者方法应该快速返回，以避免阻塞发布事件的线程，这可能是主线程
     * @param event
     */
//    @Subscribe(threadMode = ThreadMode.POSTING)
//    public void onMessage(MessageEvent event) {
//        LogUtils.e(event.message);
//    }

    /**
     * 订阅者方法将在主线程（UI线程）中被调用。因此，可以在该模式的订阅者方法中直接更新UI界面。
     * 事件将先进入队列然后才发送给订阅者，所以发布事件的调用将立即返回。
     * 这使得事件的处理保持严格的串行顺序。使用该模式的订阅者方法必须快速返回，以避免阻塞主线程。
     * @param event
     */
//    @Subscribe(threadMode = ThreadMode.MAIN_ORDERED)
//    public void onMessage(MessageEvent event) {
//        LogUtils.e(event.message);
//    }

    /**
     * 订阅者方法将在后台线程中被调用。如果发布事件的线程不是主线程，那么订阅者方法将直接在该线程中被调用。
     * 如果发布事件的线程是主线程，那么将使用一个单独的后台线程，该线程将按顺序发送所有的事件。
     * 使用该模式的订阅者方法应该快速返回，以避免阻塞后台线程。
     * @param event
     */
//    @Subscribe(threadMode = ThreadMode.BACKGROUND)
//    public void onMessage(MessageEvent event){
//        LogUtils.e(event.message);
//    }

    /**
     *订阅者方法将在一个单独的线程中被调用。因此，发布事件的调用将立即返回。如果订阅者方法的执行需要一些时间，
     * 例如网络访问，那么就应该使用该模式。避免触发大量的长时间运行的订阅者方法，以限制并发线程的数量。
     * EventBus使用了一个线程池来有效地重用已经完成调用订阅者方法的线程。
     * @param event
     */
//    @Subscribe(threadMode = ThreadMode.ASYNC)
//    public void onMessage(MessageEvent event){
//        LogUtils.e(event.message);
//    }
}
