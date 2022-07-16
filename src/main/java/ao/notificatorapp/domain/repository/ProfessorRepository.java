package ao.notificatorapp.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ao.notificatorapp.domain.entity.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor,Long> {

}
