package edu.solution.service;


import edu.solution.model.Country;
import edu.solution.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public Country findById(Long id){
        return countryRepository.getOne(id);
    }

    public List<Country> findAll(){
        return countryRepository.findAll();
    }

    public Country saveCountry(Country country){
        return countryRepository.save(country);
    }

    public void deleteById(Long id){
        countryRepository.deleteById(id);
    }
}