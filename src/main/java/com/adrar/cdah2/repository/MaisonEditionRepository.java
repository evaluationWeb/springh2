package com.adrar.cdah2.repository;

import com.adrar.cdah2.model.MaisonEdition;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaisonEditionRepository extends CrudRepository<MaisonEdition, Integer> {
}
