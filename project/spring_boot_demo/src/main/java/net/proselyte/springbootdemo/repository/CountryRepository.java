package net.proselyte.springbootdemo.repository;

import net.proselyte.springbootdemo.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
