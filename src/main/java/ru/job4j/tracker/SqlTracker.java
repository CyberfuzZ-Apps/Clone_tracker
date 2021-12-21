package ru.job4j.tracker;

import ru.job4j.tracker.react.Observe;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {
    private Connection cn;

    public SqlTracker() {
    }

    public SqlTracker(Connection cn) {
        this.cn = cn;
    }

    public void init() {
        try (InputStream in = SqlTracker.class.getClassLoader()
                .getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement pStatement = cn.prepareStatement(
                "INSERT INTO items(name, created) VALUES (?, ?)",
                Statement.RETURN_GENERATED_KEYS)) {
            pStatement.setString(1, item.getName());
            pStatement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            pStatement.execute();
            try (ResultSet generatedKeys = pStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    item.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean result = false;
        try (PreparedStatement pStatement = cn.prepareStatement(
                "UPDATE items SET name = ?, created = ? WHERE id = ?")) {
            pStatement.setString(1, item.getName());
            pStatement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            pStatement.setInt(3, id);
            result = pStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        try (PreparedStatement pStatement = cn.prepareStatement(
                "DELETE FROM items WHERE id = ?")) {
            pStatement.setInt(1, id);
            result = pStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Item> findAll() {
        List<Item> items = new ArrayList<>();
        try (PreparedStatement pStatement = cn.prepareStatement(
                "SELECT * FROM items")) {
            try (ResultSet resultSet = pStatement.executeQuery()) {
                while (resultSet.next()) {
                    items.add(new Item(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getTimestamp("created").toLocalDateTime()
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public void findAllByReact(Observe<Item> observe) {
        try (PreparedStatement pStatement = cn.prepareStatement(
                "SELECT * FROM items")) {
            try (ResultSet resultSet = pStatement.executeQuery()) {
                while (resultSet.next()) {
                    observe.receive(new Item(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getTimestamp("created").toLocalDateTime()
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> items = new ArrayList<>();
        try (PreparedStatement pStatement = cn.prepareStatement(
                "SELECT * FROM items WHERE name = ?")) {
            pStatement.setString(1, key);
            try (ResultSet resultSet = pStatement.executeQuery()) {
                while (resultSet.next()) {
                    items.add(new Item(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getTimestamp("created").toLocalDateTime()
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public Item findById(int id) {
        Item item = null;
        try (PreparedStatement pStatement = cn.prepareStatement(
                "SELECT * FROM items WHERE id = ?")) {
            pStatement.setInt(1, id);
            try (ResultSet resultSet = pStatement.executeQuery()) {
                if (resultSet.next()) {
                    item = new Item(
                            id,
                            resultSet.getString("name"),
                            resultSet.getTimestamp("created").toLocalDateTime()
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }
}