package com.server.sumnote.summary.service;

import io.github.flashvayne.chatgpt.service.ChatgptService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Component("summaryChatService")
public class ChatService {

    private final ChatgptService chatgptService;

    public String getChatResponse(String prompt) {

        String answerTmp = chatgptService.sendMessage(prompt);
//        System.out.println(answerTmp);
        String answer = answerTmp.replace("\n", "");

        // dirtyData 삭제 -> ex) "정답 :", "정답:", "answer :", "answer :" 등
        int index = answer.indexOf(':');

        if (index != -1) {
            answer = answer.substring(index + 1);
//            System.out.println("\":\"과 그 앞의 문자들 삭제 ->" + answer);
        } else {
            System.out.println(answer);
        }

        if (answer.charAt(0) == ' ') {
            answer = answer.trim();
//            System.out.println("맨 앞에 공백이 있다면 삭제 ->" + answer);
        }

        return answer;
    }
}