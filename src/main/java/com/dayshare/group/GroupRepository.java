package com.dayshare.group;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;



public interface GroupRepository extends PagingAndSortingRepository<Group, Long> {
    @RestResource(rel = "name-contains", path = "containsName")
    Page<Group> findByNameContains(@Param("name") String name, Pageable page);
}

