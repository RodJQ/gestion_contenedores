package com.gestion.contenedores.controller;

import com.gestion.contenedores.domain.Empresa;
import com.gestion.contenedores.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping("/")
    public String inicio() {
        return "index";
    }

    @GetMapping("/empresa/listado")
    public String listado(Model model) {
        var empresas = empresaService.getEmpresas();
        model.addAttribute("empresas", empresas);
        return "empresa/listado";
    }
}
