package com.mysite.sbb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
}
