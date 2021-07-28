package net.proselyte.springbootdemo.repository;

import net.proselyte.springbootdemo.model.Strain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StrainRepository extends JpaRepository<Strain, Long> {
}

