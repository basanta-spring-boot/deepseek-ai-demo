package com.javatechie;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ChatAIService {

    private final ChatClient chatClient;

    public ChatAIService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    public String askToDeepSeek(String question){
        return chatClient.prompt(question)
                .call().content();
    }

    public Flux<String> askToDeepSeekWithStream(String question){
        return chatClient.prompt(question)
                .stream().content();
    }
}
