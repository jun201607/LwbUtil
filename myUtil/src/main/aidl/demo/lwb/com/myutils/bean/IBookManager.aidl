// IBookManager.aidl
package demo.lwb.com.myutils.bean;

import demo.lwb.com.myutils.bean.Book;
//业务模块1
interface IBookManager {
    List<Book> getBookList();
    void addBook(in Book book);
}
