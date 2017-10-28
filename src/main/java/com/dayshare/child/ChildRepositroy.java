package com.dayshare.child;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

public interface ChildRepositroy extends PagingAndSortingRepository<Child, Long> {
    @RestResource(rel = "first-name-contains", path = "containsFirstName")
    Page<Child> findByFirstNameContains(@Param("firstName") String firstName, Pageable page);
}
