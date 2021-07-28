package net.proselyte.springbootdemo.repository;

import net.proselyte.springbootdemo.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository  extends JpaRepository<City, Long> {
}
