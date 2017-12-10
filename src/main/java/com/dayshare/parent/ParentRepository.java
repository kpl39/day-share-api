package com.dayshare.parent;

import com.dayshare.child.Child;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface ParentRepository extends PagingAndSortingRepository<Parent, Long> {

    @RestResource(rel = "find-by-username", path = "findByUserName")
    Page<Parent> findByUsername(@Param("username") String username, Pageable page);
//
//    @Query("SELECT p FROM PARENTS p WHERE LOWER(p.email) = LOWER(:email)")
    @RestResource(rel = "find-by-email", path = "findByEmail")
    Page<Parent> findByEmail(@Param("email") String email, Pageable page);

    @RestResource(rel = "find-by-userid", path = "findByUserId")
    Page<Parent> findByUserId(@Param("userId") String userId, Pageable page);
}
