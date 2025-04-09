package cz.uhk.pro2_c.repository;

import cz.uhk.pro2_c.model.Lecturer;
import cz.uhk.pro2_c.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LecturerRepository extends JpaRepository<Lecturer, Long> {
}
