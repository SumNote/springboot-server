package com.server.sumnote.summary.service;

import com.server.sumnote.summary.entity.Summary;
import com.server.sumnote.summary.repository.SummaryRepository;
import com.server.sumnote.user.entity.User;
import com.server.sumnote.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class SummaryService {

    private final SummaryRepository summaryRepository;
    private final UserRepository userRepository;

    public Summary createSumNote(String title, String content, User user) {
        Summary newSumNote = new Summary();
        newSumNote.setTitle(title);
        newSumNote.setContent(content);
        newSumNote.setUser(user);
        userRepository.save(user);
        summaryRepository.save(newSumNote);
        return newSumNote;
    }

    public Summary getSumNote(Long id) {
        return summaryRepository.findSummaryById(id);
    }

    public ArrayList<Summary> getAllSumNotes(String email) {
        return summaryRepository.findSummariesByUser(userRepository.findByEmail(email));
    }

    public void deleteNote(Long id) {
        summaryRepository.deleteById(id);
    }
}