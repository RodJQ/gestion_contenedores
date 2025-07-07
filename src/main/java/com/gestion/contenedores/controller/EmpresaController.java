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
    
    @GetMapping("/empresa/nuevo")
    public String nuevaEmpresa(Model model) {
        model.addAttribute("empresa", new Empresa());
        return "empresa/formulario";
}

    @PostMapping("/empresa/guardar")
    public String guardarEmpresa(Empresa empresa) {
        empresaService.save(empresa);
        return "redirect:/empresa/listado";
}

    @GetMapping("/empresa/editar/{id_empresa}")
    public String editarEmpresa(@PathVariable("id_empresa") Long id_empresa, Model model) {
        var empresa = new Empresa();
        empresa.setId_empresa(id_empresa);
        empresa = empresaService.getEmpresa(empresa);
        model.addAttribute("empresa", empresa);
        return "empresa/formulario";
}

    @GetMapping("/empresa/eliminar/{id_empresa}")
    public String eliminarEmpresa(@PathVariable("id_empresa") Long id_empresa) {
        var empresa = new Empresa();
        empresa.setId_empresa(id_empresa);
        empresaService.delete(empresa);
        return "redirect:/empresa/listado";
}

}
