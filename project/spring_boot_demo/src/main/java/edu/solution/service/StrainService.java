package edu.solution.service;
import edu.solution.model.Strain;
import edu.solution.repository.StrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StrainService {

    private final StrainRepository strainRepository;

    @Autowired
    public StrainService(StrainRepository strainRepository) {
        this.strainRepository = strainRepository;
    }

    public Strain findById(Long id){
        return strainRepository.getOne(id);
    }

    public List<Strain> findAll(){
        return strainRepository.findAll();
    }

    public Strain saveStrain(Strain strain){
        return strainRepository.save(strain);
    }

    public void deleteById(Long id){
        strainRepository.deleteById(id);
    }
}