package cz.uhk.pro2_c.service;

import cz.uhk.pro2_c.model.Lecturer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LecturerService {
    List<Lecturer> getLecturers();
    void saveLecturer(Lecturer lecturer);
    Lecturer getLecturer(long id);
    void deleteLecturer(long id);
}
