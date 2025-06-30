package com.gestion.contenedores.dao;

import com.gestion.contenedores.domain.Empresa;
import org.springframework.data.repository.CrudRepository;

public interface EmpresaDao extends CrudRepository<Empresa, Long> {
}
