package com.wellware.smart.controllers;

import com.wellware.smart.DTO.QuizDTO;
import com.wellware.smart.entities.Quiz;
import com.wellware.smart.services.QuizService;
import com.wellware.smart.success.Success;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Quiz APIs", tags = {"Quiz Management"},
        description = "Quiz operations")
@RestController
@CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping(path = "/add-quiz")
    public Success save(@RequestBody QuizDTO quizDTO){
        try {
            Quiz quiz = quizService.save(quizDTO);
            return new Success(200,true,quiz,"");
        }catch (Exception e)
        {
            return new Success(400,false,null,e.getMessage());
        }
    }
}
