package com.dictionaryapp.service.impl;

import com.dictionaryapp.config.UserSession;
import com.dictionaryapp.model.dto.bindng.AddWordDTO;
import com.dictionaryapp.model.entity.Word;
import com.dictionaryapp.repo.LanguageRepository;
import com.dictionaryapp.repo.UserRepository;
import com.dictionaryapp.repo.WordRepository;
import com.dictionaryapp.service.WordService;
import org.springframework.stereotype.Service;

@Service
public class WordServiceImpl implements WordService {

    private final LanguageRepository languageRepository;

    private final UserRepository userRepository;

    private final WordRepository wordRepository;

    private final UserSession userSession;

    public WordServiceImpl(LanguageRepository languageRepository, UserRepository userRepository, WordRepository wordRepository, UserSession userSession) {
        this.languageRepository = languageRepository;
        this.userRepository = userRepository;
        this.wordRepository = wordRepository;
        this.userSession = userSession;
    }


    @Override
    public void add(AddWordDTO data) {
        Word word = new Word();

        //TODO: Save and attach user + language
    }
}
