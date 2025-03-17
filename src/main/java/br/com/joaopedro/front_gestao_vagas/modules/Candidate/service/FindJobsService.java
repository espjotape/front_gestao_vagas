package br.com.joaopedro.front_gestao_vagas.modules.Candidate.service;

import java.util.List;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpClientErrorException.Unauthorized;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.joaopedro.front_gestao_vagas.modules.Candidate.dto.JobDTO;

@Service
public class FindJobsService {
 public List<JobDTO> execute(String filter, String token) {
  RestTemplate rt = new RestTemplate();
  HttpHeaders headers = new HttpHeaders();
  headers.setBearerAuth(token);

  HttpEntity<Map<String, String>> request = new HttpEntity<>(headers);
 
  UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/candidate/job")
  .queryParam("filter", filter);

  // Define o tipo da resposta como uma lista de JobDTO para evitar problemas de desserialização
  ParameterizedTypeReference<List<JobDTO>> responseType = new ParameterizedTypeReference<List<JobDTO>>() {};

  try {
   var result = rt.exchange(builder.toUriString(), HttpMethod.GET, request, responseType);
   //System.out.println(result);
   return result.getBody();
  } catch(Unauthorized ex){
   throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED);
  }
 }
}
