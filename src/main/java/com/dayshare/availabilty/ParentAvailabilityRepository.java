package com.dayshare.availabilty;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface ParentAvailabilityRepository extends PagingAndSortingRepository<ParentAvailability, Long> {
    Page<ParentAvailability> findByParentId(@Param("parentId") int parentId, Pageable page);
}
