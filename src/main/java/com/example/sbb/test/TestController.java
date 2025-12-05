package com.example.sbb.test;

import org.springframework.ui.Model;
import com.example.sbb.question.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@RequiredArgsConstructor
@Controller
@RequestMapping("/test")
public class TestController {

    private final TestService testService;

    @GetMapping("/list")
//    @ResponseBody : 템플릿이 랜더링 되지 않고 test_list 텍스트만 반환된다.
    public String test(Model model){
        List<Question> questionLiszt = testService.getList();
        model.addAttribute("questionLiszt",questionLiszt);
        return "test_list";
    }

    @GetMapping(value = "/detail/{id}")
    public String details(Model model, @PathVariable("id") Integer id){

        Question question = this.testService.getQuestions(id);
        model.addAttribute("question",question);
        return "test_detail";
    }
}
