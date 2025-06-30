package com.gestion.contenedores.service;

import com.gestion.contenedores.dao.EmpresaDao;
import com.gestion.contenedores.domain.Empresa;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaServiceImpl implements EmpresaService {

    @Autowired
    private EmpresaDao empresaDao;

    @Override
    public List<Empresa> getEmpresas() {
        return (List<Empresa>) empresaDao.findAll();
    }

    @Override
    public Empresa getEmpresa(Empresa empresa) {
        return empresaDao.findById(empresa.getId_empresa()).orElse(null);
    }

    @Override
    public void save(Empresa empresa) {
        empresaDao.save(empresa);
    }

    @Override
    public void delete(Empresa empresa) {
        empresaDao.delete(empresa);
    }
}
