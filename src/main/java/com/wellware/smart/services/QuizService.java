package com.wellware.smart.services;

import com.wellware.smart.DTO.QuizDTO;
import com.wellware.smart.entities.Group;
import com.wellware.smart.entities.Quiz;
import com.wellware.smart.reposetories.GroupRepo;
import com.wellware.smart.reposetories.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizService {

    @Autowired
    private QuizRepo quizRepo;

    @Autowired
    private GroupRepo groupRepo;

    public Quiz save(QuizDTO quizDTO){
        Quiz quiz = new Quiz();
        quiz.setName(quizDTO.getName());
        quiz.setDate(quizDTO.getDate());
        Group group = groupRepo.findAllById(quizDTO.getGroupId());
        quiz.setGroup(group);

        return quizRepo.save(quiz);

    }
}
