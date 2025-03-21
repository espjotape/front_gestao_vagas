package br.com.joaopedro.front_gestao_vagas.modules.Company.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.joaopedro.front_gestao_vagas.modules.Company.dto.CreateCompanyDTO;

@Controller
@RequestMapping("/company")
public class ControllerCompany {

 @GetMapping("/create")
 public String create(Model model) {
  model.addAttribute("company", new CreateCompanyDTO());
  return "company/create";
 }
}