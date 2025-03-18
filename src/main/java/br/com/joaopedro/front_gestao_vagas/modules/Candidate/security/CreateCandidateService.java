package br.com.joaopedro.front_gestao_vagas.modules.Candidate.security;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.joaopedro.front_gestao_vagas.modules.Candidate.dto.CreateCandidateDTO;

@Service
public class CreateCandidateService  {
 public void execute (CreateCandidateDTO createCandidateDTO) {
  RestTemplate rt = new RestTemplate();
  
  HttpHeaders headers = new HttpHeaders();
  headers.setContentType(MediaType.APPLICATION_JSON);

  HttpEntity<CreateCandidateDTO> request = new HttpEntity<>(createCandidateDTO, headers);

  var result = rt.postForEntity("http://localhost:8080/candidate/", request, String.class);
  System.out.println(result);
 }
}
