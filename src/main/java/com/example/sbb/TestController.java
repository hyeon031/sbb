package com.example.sbb;

import org.springframework.ui.Model;
import com.example.sbb.question.Question;
import com.example.sbb.question.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@RequiredArgsConstructor
@Controller
public class TestController {

    private final QuestionRepository questionRepository;

    @GetMapping("/test/list")
//    @ResponseBody : 템플릿이 랜더링 되지 않고 test_list 텍스트만 반환된다.
    public String test(Model model){
        List<Question> questionLiszt = questionRepository.findAll();
        model.addAttribute("questionLiszt",questionLiszt);
        return "test_list";
    }
}
