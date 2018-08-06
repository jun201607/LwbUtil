package demo.lwb.com.myutils.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * http://www.jianshu.com/p/4986100eff90  //greendao使用
 *Created by Administrator on 2017/6/17.
 * 对Bean中的对象进行解释
 * @Entity：告诉GreenDao该对象为实体，只有被@Entity注释的Bean类才能被dao类操作
 * @Id：对象的Id，使用Long类型作为EntityId，否则会报错。(autoincrement = true)表示主键会自增，如果false就会使用旧值
 * @Property：可以自定义字段名，注意外键不能使用该属性
 * @NotNull：属性不能为空
 * @Transient：使用该注释的属性不会被存入数据库的字段中
 * @Unique：该属性值必须在数据库中是唯一值
 * @Generated：编译后自动生成的构造函数、方法等的注释，提示构造函数、方法等不能被修改
  * */
@Entity
public class UserBean {
    @Id
    String id;
    String name;
    @Generated(hash = 720580898)
    public UserBean(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Generated(hash = 1203313951)
    public UserBean() {
    }

    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
