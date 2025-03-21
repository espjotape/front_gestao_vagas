package br.com.joaopedro.front_gestao_vagas.modules.Candidate.service;

import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.joaopedro.front_gestao_vagas.modules.Candidate.dto.ProfileDTO;

@Service
public class ProfileCandidateService {
 public ProfileDTO execute(String token) {
  RestTemplate rt = new RestTemplate();
  HttpHeaders headers = new HttpHeaders();
  headers.setBearerAuth(token);

  HttpEntity<Map<String, String>> request = new HttpEntity<>(headers);

  var result = rt.exchange(
   "http://localhost:8080/candidate/", 
   HttpMethod.GET,
   request,
   ProfileDTO.class);
  System.out.println(result);
  return result.getBody();
 } 
}
