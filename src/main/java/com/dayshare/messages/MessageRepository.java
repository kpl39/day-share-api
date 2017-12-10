package com.dayshare.messages;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface MessageRepository extends PagingAndSortingRepository <Message, Long> {
    Page<Message> findBySenderId(@Param("senderId") int senderId, Pageable page);

    @Query("SELECT m FROM Message m WHERE m.senderId = :primary OR m.senderId = :secondary AND m.recipientId = :primary OR m.recipientId = :secondary ORDER BY dateTime ASC" )
    Page<Message> getConversation(@Param("primary") int primary, @Param("secondary") int secondary, Pageable page);
}
