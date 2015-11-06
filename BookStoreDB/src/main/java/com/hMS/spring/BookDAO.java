package com.hMS.spring;

import java.util.List;

/**
 * An interface to define all the operation
 * available to use in database.
 * <p>
 * Created by nivethika on 06/11/15.
 */
public interface BookDAO {
    public void save(Book book);

    public List<Book> getAll();
    public boolean getBook(String isbn);

}
