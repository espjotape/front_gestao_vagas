package br.com.joaopedro.front_gestao_vagas.modules.Candidate.dto;

import java.util.List;

import lombok.Data;

@Data
public class Token {
 private String access_token;
 private String expires_in;
 private List<String> roles;
}
