package demo.lwb.com.myutils.gen.DBOperation;

import android.widget.TextView;

import java.util.List;

import demo.lwb.com.myutils.base.BaseApplication;
import demo.lwb.com.myutils.bean.Book;
import demo.lwb.com.myutils.bean.UserBean;
import demo.lwb.com.myutils.gen.BookDao;
import demo.lwb.com.myutils.gen.UserBeanDao;

/**
 * Created by lwb on 2017/6/17.
 * BOOK数据库操作类
 * https://github.com/yuweiguocn/GreenDaoUpgradeHelper/blob/master/README_CH.md 数据库升级
 */

public class BookOpertion {


    private   BookDao bookDao;

    public BookOpertion() {
        bookDao = BaseApplication.getInstances().getDaoSession().getBookDao();
    }

    /**
     * 增
     * @param id
     * @param name
     */
    public void add(int id,String name){
        bookDao.insert(new Book(id,name));//添加一个
    }
    /**
     * 根据id 删书名
     */
    public void del(int id){
        Book book = selectBook(id);
        if(book!=null){
          bookDao.delete(book);
        }
    }

    /**
     * 根据id   改书名
     * @param id
     */
    public void upDate(int id,String name){
        Book book = selectBook(id);
        if(book!=null){
            book.setBookName(name);
            bookDao.update(book);
        }

    }

    /**
     * 查
     */
    public List<Book> selectAll(){
        List<Book> books = bookDao.loadAll();
        return books;
    }
    /**
     * 根据id  查书名
     */
    public Book selectBook(final int id){
        List<Book> books = bookDao.loadAll();
        for (Book book:books){
            int bookId = book.getBookId();
            if(bookId==id){
                return book;
            }
        }
        return null;
    }
}
