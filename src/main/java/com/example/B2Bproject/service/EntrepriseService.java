package com.example.B2Bproject.service;

import com.example.B2Bproject.dto.EntrepriseDTO;
import org.springframework.stereotype.Component;

import java.util.List;
@Component


public interface EntrepriseService {
    EntrepriseDTO createEntreprise(EntrepriseDTO entrepriseDTO);
    EntrepriseDTO getEntrepriseById(Long id);
    List<EntrepriseDTO> getAllEntreprises();
    EntrepriseDTO updateEntreprise(Long id, EntrepriseDTO entrepriseDTO);
    void deleteEntreprise(Long id);
}
