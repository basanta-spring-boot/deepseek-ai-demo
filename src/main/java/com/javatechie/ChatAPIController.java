package com.javatechie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
@RestController
@RequestMapping("/api/ai")
public class ChatAPIController {

    @Autowired
    private ChatAIService chatAIService;

    @GetMapping("/test")
    public String test(){
        return "test ";
    }

    @GetMapping("/prompt")
    public String talkToAI(@RequestParam(value = "question") String question){
        return chatAIService.askToDeepSeek(question);
    }

    @GetMapping("/prompt/stream")
    public Flux<String> talkToAIWithStream(@RequestParam(value = "question") String question){
        return chatAIService.askToDeepSeekWithStream(question);
    }

}
