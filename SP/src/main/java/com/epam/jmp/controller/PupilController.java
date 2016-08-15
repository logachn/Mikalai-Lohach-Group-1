package com.epam.jmp.controller;


import com.epam.jmp.dao.PupilDao;
import com.epam.jmp.model.Pupil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class PupilController extends HttpServlet {

    private static String INSERT_OR_EDIT = "/pupil.jsp";
    private static String LIST_USER = "/index.jsp";
    private PupilDao dao;

    public PupilController() {
        super();
        dao = new PupilDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String forward = "";
        String action = req.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {
            int id = Integer.parseInt(req.getParameter("id"));
            dao.deletePupil(id);
            forward = LIST_USER;
            req.setAttribute("pupils", dao.getAllPupils());
        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int id = Integer.parseInt(req.getParameter("id"));
            Pupil pupil = dao.getPupilById(id);
            req.setAttribute("pupil", pupil);
        } else if (action.equalsIgnoreCase("listPupils")) {
            forward = LIST_USER;
            req.setAttribute("pupils", dao.getAllPupils());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = req.getRequestDispatcher(forward);
        view.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("name") != null) {
            Pupil pupil = new Pupil();
            pupil.setName(req.getParameter("name"));
            pupil.setSurname(req.getParameter("surname"));
            pupil.setGpa(Double.parseDouble(req.getParameter("gpa")));
            pupil.setPhone(req.getParameter("phone"));
            String id = req.getParameter("id");
            if (id == null || id.isEmpty()) {
                dao.addPupil(pupil);
            } else {
                pupil.setId(Integer.parseInt(id));
                dao.updatePupil(pupil);
            }
            req.setAttribute("pupils", dao.getAllPupils());
        } else {
            int id = Integer.parseInt(req.getParameter("listbox"));
            Pupil pupil = dao.getPupilById(id);
            List<Pupil> pupils = new ArrayList<>();
            pupils.add(pupil);
            req.setAttribute("pupils", pupils);
        }
        RequestDispatcher view = req.getRequestDispatcher(LIST_USER);

        view.forward(req, resp);
    }
}
