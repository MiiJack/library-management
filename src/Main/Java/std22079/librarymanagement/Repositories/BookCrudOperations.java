package std22079.librarymanagement.Repositories;

import std22079.librarymanagement.Configuration.DatabaseConfiguration;
import std22079.librarymanagement.Model.Book;
import std22079.librarymanagement.Model.Author;
import std22079.librarymanagement.Model.Topic;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookCrudOperations implements CrudOperations<Book>{
    @Override
    public List<Book>  findAll() {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM Book";

        try (Connection connection = DatabaseConfiguration.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setName(rs.getString("name"));
                book.setPageNumbers(rs.getInt("pageNumbers"));
                book.setReleaseDate(rs.getDate("releaseDate").toLocalDate());
                book.setAuthor(getAuthorById(rs.getInt("idAuthor")));
                String topicName = rs.getString("topic");
                Topic topic = new Topic();
                topic.setTopic(topicName);
                book.setTopic(topic);
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public List<Book> saveAll(List<Book> toSave) {
        toSave.forEach(this::save);
        return toSave;
    }

    @Override
    public Book save(Book toSave) {
        String sql = "INSERT INTO Book (name, pageNumbers, releaseDate, idAuthor, topic) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConfiguration.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, toSave.getName());
            pstmt.setInt(2, toSave.getPageNumbers());
            pstmt.setDate(3, java.sql.Date.valueOf(toSave.getReleaseDate()));
            pstmt.setInt(4, toSave.getAuthor().getId());
            if (toSave.getTopic() != null) {
                pstmt.setString(5, toSave.getTopic().getTopic());
            } else {
                pstmt.setNull(5, Types.OTHER); // Set to NULL if the Topic object is null
            }
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toSave;
    }

    @Override
    public Book delete(Book toDelete) {
        String sql = "DELETE FROM Book WHERE id = ?";
        try (Connection connection = DatabaseConfiguration.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, toDelete.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toDelete;
    }

    private Author getAuthorById(int id) {
        String sql = "SELECT * FROM Author WHERE id = ?";
        try (Connection connection = DatabaseConfiguration.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Author author = new Author();
                author.setId(rs.getInt("id"));
                author.setName(rs.getString("name"));
                author.setSex(rs.getString("sex"));
                return author;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
