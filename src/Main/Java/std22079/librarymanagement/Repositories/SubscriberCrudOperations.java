package std22079.librarymanagement.Repositories;

import std22079.librarymanagement.Model.Subscriber;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubscriberCrudOperations implements CrudOperations<Subscriber> {
    private final Connection connection;
    public SubscriberCrudOperations(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Subscriber> findAll() {
        List<Subscriber> subscribers = new ArrayList<>();
        String sql = "SELECT * FROM Subscriber";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Subscriber subscriber = new Subscriber();
                subscriber.setId(rs.getInt("id"));
                subscriber.setName(rs.getString("name"));
                subscriber.setReference(rs.getString("reference"));
                subscribers.add(subscriber);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subscribers;
    }

    @Override
    public List<Subscriber> saveAll(List<Subscriber> toSave) {
        toSave.forEach(this::save);
        return toSave;
    }

    @Override
    public Subscriber save(Subscriber toSave) {
        String sql = "INSERT INTO Subscriber (name, reference) VALUES (?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, toSave.getName());
            pstmt.setString(2, toSave.getReference());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toSave;
    }

    @Override
    public Subscriber delete(Subscriber toDelete) {
        String sql = "DELETE FROM Subscriber WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, toDelete.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toDelete;
    }
}
