package ao.notificatorapp.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ao.notificatorapp.domain.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {}
