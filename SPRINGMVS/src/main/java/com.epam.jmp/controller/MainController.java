package com.epam.jmp.controller;

import com.epam.jmp.dao.PupilDaoImpl;
import com.epam.jmp.model.Pupil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/pupils")
public class MainController {

    @Autowired
    PupilDaoImpl pupilDaoImpl;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listAll() {
        ModelAndView m = new ModelAndView("index");
        m.addObject("command", new Pupil());
        m.addObject("pupils", pupilDaoImpl.getAllPupils());
        return m;
    }

    @RequestMapping(value = "/savePupil", method = RequestMethod.POST)
    public ModelAndView addPupil(@ModelAttribute("pupil") Pupil pupil) {
        pupilDaoImpl.addPupil(pupil);
        return new ModelAndView("redirect:/pupils");
    }

    @RequestMapping(value = "updatePupil/pupils/savePupil", method = RequestMethod.POST)
    public ModelAndView savePupil(@ModelAttribute("pupil") Pupil pupil) {
        pupilDaoImpl.updatePupil(pupil);
        return new ModelAndView("redirect:/pupils");
    }

    @RequestMapping(value = "/updatePupil/{id}", method = RequestMethod.GET)
    public ModelAndView updatePupil(@PathVariable int id) {
        ModelAndView m = new ModelAndView("index");
        m.addObject("command", pupilDaoImpl.getPupilById(id));
        m.addObject("pupils", pupilDaoImpl.getAllPupils());
        return m;
    }

    @RequestMapping(value = "/deletePupil/{id}", method = RequestMethod.GET)
    public ModelAndView deletePupil(@PathVariable int id) {
        pupilDaoImpl.deletePupil(id);
        return new ModelAndView("redirect:/pupils");
    }

}
