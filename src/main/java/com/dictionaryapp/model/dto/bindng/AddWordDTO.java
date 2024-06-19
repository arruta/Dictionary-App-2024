package com.dictionaryapp.model.dto.bindng;

import java.time.LocalDate;

// todo validation
public class AddWordDTO {

    private String term;

    private String translation;

    private String example;

    private LocalDate inputDate;

    private String language;

    public String getTerm() {
        return term;
    }

    public AddWordDTO setTerm(String term) {
        this.term = term;
        return this;
    }

    public String getTranslation() {
        return translation;
    }

    public AddWordDTO setTranslation(String translation) {
        this.translation = translation;
        return this;
    }

    public String getExample() {
        return example;
    }

    public AddWordDTO setExample(String example) {
        this.example = example;
        return this;
    }

    public LocalDate getInputDate() {
        return inputDate;
    }

    public AddWordDTO setInputDate(LocalDate inputDate) {
        this.inputDate = inputDate;
        return this;
    }

    public String getLanguage() {
        return language;
    }

    public AddWordDTO setLanguage(String language) {
        this.language = language;
        return this;
    }
}
