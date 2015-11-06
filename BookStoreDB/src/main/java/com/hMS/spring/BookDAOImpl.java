package com.hMS.spring;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        jdbcTemplate = new JdbcTemplate(dataSource);

    }


    public void save(Book book) {
        this.jdbcTemplate.update("insert into bookDetails (Isbn,Title,Author,Genre) values (?, ?,?,?)",
                book.getIsbn(), book.getTitle(),book.getAuthor(),book.getGenre());
    }

    @Override
    public List<Book> getAll() {

        return this.jdbcTemplate.query( "select Isbn,Title,Author,Genre from bookDetails", new BookMapper());

    }
    private static final class BookMapper implements RowMapper<Book> {

        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            Book book = new Book();
            book.setIsbn(rs.getString("Isbn"));
            book.setTitle(rs.getString("Title"));
            book.setAuthor(rs.getString("Author"));
            book.setGenre(rs.getString("Genre"));
            return book;
        }
    }



}


