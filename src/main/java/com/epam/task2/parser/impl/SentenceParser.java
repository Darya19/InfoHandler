package com.epam.task2.parser.impl;

import com.epam.task2.composite.Component;
import com.epam.task2.composite.ComponentType;
import com.epam.task2.composite.impl.TextComposite;
import com.epam.task2.parser.BaseParser;

import java.util.ArrayList;
import java.util.List;

public class SentenceParser implements BaseParser {

    private static final String SENTENCE_SEPARATOR = "[.!?]\\s*";

    @Override
    public List<Component> parse(String text) {
        List<Component> sentences = new ArrayList<>();
        String[] stringSentences = text.split(SENTENCE_SEPARATOR);
        for (String element : stringSentences) {
            Component sentence = new TextComposite(ComponentType.SENTENCE);
            List<Component> lexemes = new LexemeParser().parse(element);
            for (Component lexeme : lexemes) {
                sentence.add(lexeme);
            }
            sentences.add(sentence);
        }
        return sentences;
    }
}
