package com.dictionaryapp.model.entity;

import com.dictionaryapp.model.enums.LanguageEnum;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "language")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private LanguageEnum languageName;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "language")
    private Set<Word> words;

    public Language() {
        this.words=new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public Language setId(Long id) {
        this.id = id;
        return this;
    }

    public LanguageEnum getLanguageName() {
        return languageName;
    }

    public Language setLanguageName(LanguageEnum languageName) {
        this.languageName = languageName;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Language setDescription(String description) {
        this.description = description;
        return this;
    }

    public Set<Word> getWords() {
        return words;
    }

    public Language setWords(Set<Word> words) {
        this.words = words;
        return this;
    }
}
