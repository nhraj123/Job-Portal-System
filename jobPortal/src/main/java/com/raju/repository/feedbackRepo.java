package com.raju.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raju.model.feedbackModel;

public interface feedbackRepo extends JpaRepository<feedbackModel,Integer> {

}
