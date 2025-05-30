package br.com.joaopedro.front_gestao_vagas.modules.Company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.joaopedro.front_gestao_vagas.modules.Candidate.dto.JobDTO;

@Service
public class ListAllJobsCompanyService {

  @Value("${host.api.gestao.vagas}")
  private String hostAPIGestaoVagas;

 public List<JobDTO> execute(String token) {
   RestTemplate rt = new RestTemplate();
   HttpHeaders headers = new HttpHeaders();
   headers.setBearerAuth(token);

   var HttpEntity = new HttpEntity<>(headers);

   ParameterizedTypeReference<List<JobDTO>> responseType = new ParameterizedTypeReference<List<JobDTO>>() {
   };

   var url = hostAPIGestaoVagas.concat("/company/job/");
   var result = rt.exchange(url, HttpMethod.GET, HttpEntity, responseType);
   return result.getBody();

 }
}
