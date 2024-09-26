package org.umss.scesi.spring_course.final_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.umss.scesi.spring_course.final_project.models.Proyecto;

public interface ProyectoRepository extends JpaRepository<Proyecto, Integer> {

    @Query("SELECT p FROM Proyecto p WHERE p.uuid = ?1")
    Proyecto findOneByUuid(String uuid);
}

