package org.umss.scesi.spring_course.final_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.umss.scesi.spring_course.final_project.models.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> {

    @Query("SELECT d FROM Departamento d WHERE d.uuid = ?1")
    Departamento findOneByUuid(String uuid);
}
