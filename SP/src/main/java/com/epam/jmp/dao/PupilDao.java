package com.epam.jmp.dao;


import com.epam.jmp.model.Pupil;
import com.epam.jmp.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PupilDao {

    private Connection connection;

    public PupilDao() {
        connection = DBUtil.getConnection();
    }

    public void addPupil(Pupil pupil) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO pupils(name,surname,gpa,phone) VALUES (?, ?, ?, ?)");

            ps.setString(1, pupil.getName());
            ps.setString(2, pupil.getSurname());
            ps.setDouble(3, pupil.getGpa());
            ps.setString(4, pupil.getPhone());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePupil(int id) {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM pupils WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePupil(Pupil pupil) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE pupils SET name=?, surname=?, gpa=?, phone=? " + " WHERE id=?");
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

    public List<Pupil> getAllPupils() {
        List<Pupil> pupils = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM pupils");
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

    public Pupil getPupilById(int id) {
        Pupil pupil = new Pupil();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM pupils WHERE id=?");
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
