package com.example.B2Bproject.service;

import com.example.B2Bproject.dto.EntrepriseDTO; //nom des dossiers en miniscule
import com.example.B2Bproject.entity.EntrepriseEntity;
import com.example.B2Bproject.repository.EntrepriseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
@Service

public class EntrepriseServiceImpl implements EntrepriseService {  //nom des classes en camel case
    private final EntrepriseRepository entrepriseRepository;
    private final ModelMapper modelMapper;

    public EntrepriseServiceImpl(EntrepriseRepository entrepriseRepository, ModelMapper modelMapper) {
        this.entrepriseRepository = entrepriseRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public EntrepriseDTO createEntreprise(EntrepriseDTO entrepriseDTO) { //lowercamelCase
        EntrepriseEntity entrepriseEntity = modelMapper.map(entrepriseDTO, EntrepriseEntity.class);
        entrepriseEntity = entrepriseRepository.save(entrepriseEntity);
        return modelMapper.map(entrepriseEntity, EntrepriseDTO.class);
    }

    @Override
    public EntrepriseDTO getEntrepriseById(Long id) {
        EntrepriseEntity entrepriseEntity = entrepriseRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Entreprise not found with id: " + id));
        return modelMapper.map(entrepriseEntity, EntrepriseDTO.class);
    }

    @Override
    public List<EntrepriseDTO> getAllEntreprises() {
        List<EntrepriseEntity> entrepriseEntities = entrepriseRepository.findAll();
        return entrepriseEntities.stream()
                .map(entrepriseEntity -> modelMapper.map(entrepriseEntity, EntrepriseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public EntrepriseDTO updateEntreprise(Long id, EntrepriseDTO entrepriseDTO) {
        if (!entrepriseRepository.existsById(id)) {
            throw new NoSuchElementException("Entreprise not found with id: " + id);
        }
      //  entrepriseDTO.setId(id);
        EntrepriseEntity entrepriseEntity = modelMapper.map(entrepriseDTO, EntrepriseEntity.class);
        entrepriseEntity = entrepriseRepository.save(entrepriseEntity);
        return modelMapper.map(entrepriseEntity, EntrepriseDTO.class);
    }

    @Override
    public void deleteEntreprise(Long id) {
        if (!entrepriseRepository.existsById(id)) {
            throw new NoSuchElementException("Entreprise not found with id: " + id);
        }
        entrepriseRepository.deleteById(id);
    }
}
