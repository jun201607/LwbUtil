package demo.lwb.com.myutils.aidl;

import android.os.RemoteException;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import demo.lwb.com.myutils.bean.Book;
import demo.lwb.com.myutils.bean.IBookManager;

/**
 * Created by lwb on 2018/4/23.
 * 业务模块1
 */

public class IBookImpl extends IBookManager.Stub{
    private CopyOnWriteArrayList<Book> mBookList=new CopyOnWriteArrayList<Book>();
    @Override
    public List<Book> getBookList() throws RemoteException {
        return mBookList;
    }

    @Override
    public void addBook(Book book) throws RemoteException {
        mBookList.add(0,book);
    }
}
