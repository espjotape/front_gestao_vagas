package br.com.joaopedro.front_gestao_vagas.modules.Candidate.dto;

import java.util.Date;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobDTO {
 private UUID id;
 private String description;
 private String benefits;
 private String level;
 private UUID companyId;
 private Date createdAt;
}
