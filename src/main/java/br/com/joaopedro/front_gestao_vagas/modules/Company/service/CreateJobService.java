package br.com.joaopedro.front_gestao_vagas.modules.Company.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.joaopedro.front_gestao_vagas.modules.Company.dto.CreateJobsDTO;



@Service
public class CreateJobService {
 public String execute(CreateJobsDTO jobs, String token) {
  RestTemplate rt = new RestTemplate();

  HttpHeaders headers = new HttpHeaders();
  headers.setContentType(MediaType.APPLICATION_JSON);
  headers.setBearerAuth(token);

  HttpEntity<CreateJobsDTO> request = new HttpEntity<>(jobs , headers);

  return rt.postForObject("http://localhost:8080/company/job/", request, String.class);
 }
}
