package br.com.joaopedro.front_gestao_vagas.modules.Candidate.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfileDTO {
 
 private String name;
 private String username;
 private UUID id;
 private String email;
 private String description;

}
