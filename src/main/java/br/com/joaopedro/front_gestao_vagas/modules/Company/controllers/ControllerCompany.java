package br.com.joaopedro.front_gestao_vagas.modules.Company.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;

import br.com.joaopedro.front_gestao_vagas.modules.Company.dto.CreateCompanyDTO;
import br.com.joaopedro.front_gestao_vagas.modules.Company.service.CreateCompanyService;
import br.com.joaopedro.front_gestao_vagas.utils.FormatErrorMessage;

@Controller
@RequestMapping("/company")
public class ControllerCompany {

 @Autowired
 private CreateCompanyService createCompanyService;

 @GetMapping("/create")
 public String create(Model model) {
  model.addAttribute("company", new CreateCompanyDTO());
  return "company/create";
 }

 @PostMapping("/create")
 public String save(Model model, CreateCompanyDTO createCompanyDTO) {
  try {
   this.createCompanyService.execute(createCompanyDTO);
   model.addAttribute("company", new CreateCompanyDTO());
  } catch (HttpClientErrorException ex) {
   model.addAttribute("error_message", FormatErrorMessage.formatErrorMessage(ex.getResponseBodyAsString()));
   model.addAttribute("company", createCompanyDTO);
  }

  return "company/create";
 } 
}