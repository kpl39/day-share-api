package com.dayshare.parent;

import com.dayshare.child.Child;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

public interface ParentRepository extends PagingAndSortingRepository<Parent, Long> {

    @RestResource(rel = "username-contains", path = "containsUsername")
    Page<Parent> findByUsernameContaining(@Param("username") String username, Pageable page);
}
