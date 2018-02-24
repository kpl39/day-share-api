package com.dayshare.events;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface EventRepository  extends CrudRepository<Event, Long> {

    @Query("SELECT e FROM Event e WHERE e.groupId = :groupId AND (e.primaryParentId = :primaryParentId OR e.personal = false) ORDER BY startTime ASC")
    Set<Event> findByGroupId(@Param("groupId") int groupId, @Param("primaryParentId") int primaryParentId);

}
