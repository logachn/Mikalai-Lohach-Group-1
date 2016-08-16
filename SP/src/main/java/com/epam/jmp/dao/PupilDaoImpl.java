package com.epam.jmp.dao;


import com.epam.jmp.model.Pupil;
import com.epam.jmp.util.DBFacad;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PupilDaoImpl implements PupilDao {

    private Connection connection;

    private final static String ADD = "INSERT INTO pupils(name,surname,gpa,phone) VALUES (?, ?, ?, ?)";
    private final static String DELETE = "DELETE FROM pupils WHERE id=?";
    private final static String UPDATE = "UPDATE pupils SET name=?, surname=?, gpa=?, phone=? WHERE id=?";
    private final static String SELECT_ALL = "SELECT * FROM pupils";
    private final static String SELECT_BY_ID = "SELECT * FROM pupils WHERE id=?";

    public PupilDaoImpl() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        DBFacad facad = new DBFacad();
        connection = facad.getConnection();
    }

    @Override
    public void addPupil(Pupil pupil) {
        try {
            PreparedStatement ps = connection.prepareStatement(ADD);
            ps.setString(1, pupil.getName());
            ps.setString(2, pupil.getSurname());
            ps.setDouble(3, pupil.getGpa());
            ps.setString(4, pupil.getPhone());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePupil(int id) {
        try {
            PreparedStatement ps = connection.prepareStatement(DELETE);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatePupil(Pupil pupil) {
        try {
            PreparedStatement ps = connection.prepareStatement(UPDATE);
            ps.setString(1, pupil.getName());
            ps.setString(2, pupil.getSurname());
            ps.setDouble(3, pupil.getGpa());
            ps.setString(4, pupil.getPhone());
            ps.setInt(5, pupil.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Pupil> getAllPupils() {
        List<Pupil> pupils = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SELECT_ALL);
            while (rs.next()) {
                Pupil pupil = new Pupil();
                pupil.setId(rs.getInt("id"));
                pupil.setName(rs.getString("name"));
                pupil.setSurname(rs.getString("surname"));
                pupil.setGpa(rs.getDouble("gpa"));
                pupil.setPhone(rs.getString("phone"));
                pupils.add(pupil);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pupils;
    }

    @Override
    public Pupil getPupilById(int id) {
        Pupil pupil = new Pupil();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                pupil.setId(rs.getInt("id"));
                pupil.setName(rs.getString("name"));
                pupil.setSurname(rs.getString("surname"));
                pupil.setGpa(rs.getDouble("gpa"));
                pupil.setPhone(rs.getString("phone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pupil;
    }
}
