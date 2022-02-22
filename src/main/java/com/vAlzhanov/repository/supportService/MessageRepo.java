package com.vAlzhanov.repository.supportService;

import com.vAlzhanov.models.auth.User;
import com.vAlzhanov.models.supportService.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepo extends JpaRepository<Message, Long> {

    List<Message> findAllByUserOrderByDateTime(User user);
}
