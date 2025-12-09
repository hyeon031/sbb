package com.example.sbb.test;

import com.example.sbb.question.Question;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class TestAnswerController {

    private TestService testService;
    private TestAnswerService testAnswerService;

    @PostMapping("/create/{id}")
    public String createTestAnswer(Model model, @PathVariable("id")Integer id, @RequestParam("content") String content){
        Question testQuestion = this.testService.getQuestions(id);
        this.testAnswerService.create(testQuestion,content);
        return String.format("redirect:/questions/%d",id);
    }
}
