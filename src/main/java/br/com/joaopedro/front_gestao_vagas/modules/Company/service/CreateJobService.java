package br.com.joaopedro.front_gestao_vagas.modules.Company.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.joaopedro.front_gestao_vagas.modules.Company.dto.CreateJobsDTO;



@Service
public class CreateJobService {

 @Value("${host.api.gestao.vagas}")
 private String hostAPIGestaoVagas;

 public String execute(CreateJobsDTO jobs, String token) {
  RestTemplate rt = new RestTemplate();

  HttpHeaders headers = new HttpHeaders();
  headers.setContentType(MediaType.APPLICATION_JSON);
  headers.setBearerAuth(token);

  HttpEntity<CreateJobsDTO> request = new HttpEntity<>(jobs , headers);

  var url = hostAPIGestaoVagas.concat("/company/job/");
  var result = rt.postForObject(url, request, String.class);
  
  return result;
 }
}
