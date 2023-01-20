package com.kafka.spring;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsumedTweetRepository extends JpaRepository<Consumed, Integer> {

}
