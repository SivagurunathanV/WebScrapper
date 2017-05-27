package com.sivagurunathan.repositories;


import com.sivagurunathan.dto.ScrappingRequest;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by sivagurunathan.v on 20/05/17.
 */
public interface RequestRepository extends CrudRepository<ScrappingRequest,Long>{

    ScrappingRequest findByEmailId(Long id);

    List<ScrappingRequest> findByUrl(String url);

    List<ScrappingRequest> findBySendNotification(Boolean sendNotification);
}
