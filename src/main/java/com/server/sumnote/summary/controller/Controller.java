package com.server.sumnote.summary.controller;

import com.server.sumnote.summary.service.ChatServiceImpl;
import io.github.flashvayne.chatgpt.service.ChatgptService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/sum-note")
@Component("summaryController")
public class Controller {
    private final ChatServiceImpl chatServiceImpl;
    private final ChatgptService chatgptService;

    //chat-gpt 와 간단한 채팅 서비스 소스
    @PostMapping("")
    public String makeSumNote(@RequestBody String question) {
        return chatServiceImpl.getChatResponse(question);
    }

}