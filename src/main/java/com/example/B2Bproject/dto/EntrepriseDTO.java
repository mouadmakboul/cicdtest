package com.example.B2Bproject.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data

public class EntrepriseDTO {
   
    @NotBlank
    @Size(min = 0, max = 30)
    private String nom;
    private String adresse;
}
