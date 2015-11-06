package com.hMS.spring;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * Implementation of Database Queries
 * <p>
 * Created by nivethika on 06/11/15.
 */
public class BookDAOImpl implements BookDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public void save(Book book) {
        String query = "insert into bookDetails (Isbn,Title,Author,Genre) values (?, ?,?,?)";
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = dataSource.getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, book.getIsbn());
            ps.setString(2, book.getTitle());
            ps.setString(3, book.getAuthor());
            ps.setString(4, book.getGenre());

            int out = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public List<Book> getAll() {
        String query = "select Id,Isbn,Title,Author,Genre from bookDetails";
        List<Book> bookList = new ArrayList<Book>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = dataSource.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Book bk = new Book();
                bk.setId(rs.getInt("Id"));
                bk.setTitle(rs.getString("Isbn"));
                bk.setAuthor(rs.getString("Author"));
                bk.setIsbn(rs.getString("Isbn"));
                bk.setGenre(rs.getString("Genre"));
                bookList.add(bk);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return bookList;
    }


}


