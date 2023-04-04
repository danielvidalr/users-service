package com.axity.users.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.axity.users.model.OfficeDO;

/**
 * Persistence interface of  de {@link com.axity.users.model.OfficeDO}
 * 
 * @author alejandro.menchaca@axity.com
 */
@Repository
public interface OfficePersistence extends JpaRepository<OfficeDO, Integer>
{
  // Agregar consultas personalizadas
}
