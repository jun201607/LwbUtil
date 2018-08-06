package demo.lwb.com.myutils.gen.DBOperation;

import android.widget.TextView;

import java.util.List;

import demo.lwb.com.myutils.base.BaseApplication;
import demo.lwb.com.myutils.bean.UserBean;
import demo.lwb.com.myutils.gen.UserBeanDao;

/**
 * Created by lwb on 2017/6/17.
 * User数据库操作类 例子
 * https://github.com/yuweiguocn/GreenDaoUpgradeHelper/blob/master/README_CH.md 数据库升级
 */

public class UserOpertion {

    private   UserBeanDao userBeanDao;

    public UserOpertion() {
        userBeanDao = BaseApplication.getInstances().getDaoSession().getUserBeanDao();
    }

    /**
     * 增
     * @param id
     * @param name
     */
    public void add(String id,String name){
        userBeanDao.insert(new UserBean(id,name));//添加一个
    }
    /**
     * 删
     * @param id
     */
    public void delete(String id){
        userBeanDao.deleteByKey(id);//添加一个
    }

    /**
     * 改
     * @param id
     */
    public void upDate(String id,String name){
        userBeanDao.update(new UserBean(id,name));
    }

    /**
     * 查
     * @param view
     */
    public void selectAll(TextView view){
        List<UserBean> users = userBeanDao.loadAll();
        String userName = "";
        for (int i = 0; i < users.size(); i++) {
            userName += users.get(i).getName()+",";
        }
        view.setText("查询全部数据==>"+userName);
    }
}
