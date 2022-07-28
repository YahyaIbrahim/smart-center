package com.wellware.smart.reposetories;

import com.wellware.smart.entities.Quiz;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepo extends CrudRepository<Quiz,Long> {
}
