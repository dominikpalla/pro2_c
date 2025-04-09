package cz.uhk.pro2_c.service;

import cz.uhk.pro2_c.model.Lecturer;
import cz.uhk.pro2_c.repository.LecturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LecturerServiceImpl implements LecturerService {

    private final LecturerRepository lecturerRepository;

    @Autowired
    public LecturerServiceImpl(LecturerRepository lecturerRepository) {
        this.lecturerRepository = lecturerRepository;
    }

    @Override
    public List<Lecturer> getLecturers() {
        return lecturerRepository.findAll();
    }

    @Override
    public void saveLecturer(Lecturer lecturer) {
        lecturerRepository.save(lecturer);
    }

    @Override
    public Lecturer getLecturer(long id) {
        return lecturerRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteLecturer(long id) {
        lecturerRepository.deleteById(id);
    }
}
