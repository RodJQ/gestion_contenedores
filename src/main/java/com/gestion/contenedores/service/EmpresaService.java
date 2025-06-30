package com.gestion.contenedores.service;

import com.gestion.contenedores.domain.Empresa;
import java.util.List;

public interface EmpresaService {
    public List<Empresa> getEmpresas();
    public Empresa getEmpresa(Empresa empresa);
    public void save(Empresa empresa);
    public void delete(Empresa empresa);
}
