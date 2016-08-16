package com.epam.jmp.dao;


import com.epam.jmp.model.Pupil;

import java.util.List;

public interface PupilDao {

    void addPupil(Pupil pupil);

    void deletePupil(int id);

    void updatePupil(Pupil pupil);

    List<Pupil> getAllPupils();

    Pupil getPupilById(int id);


}
