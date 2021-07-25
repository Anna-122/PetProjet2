package edu.solution.repository;

import edu.solution.model.Strain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StrainRepository extends JpaRepository<Strain, Long> {
}

