package com.epam.task2.parser.impl;

import com.epam.task2.composite.Component;
import com.epam.task2.composite.ComponentType;
import com.epam.task2.composite.impl.TextComposite;
import com.epam.task2.parser.BaseParser;

import java.util.ArrayList;
import java.util.List;

public class TextParser implements BaseParser {

    private static final String PARAGRAPH_SEPARATOR = "\\n\\t";

    @Override
    public List<Component> parse(String text) {
        List<Component> paragraphs = new ArrayList<>();
        String[] stringParagraphs = text.split(PARAGRAPH_SEPARATOR);
        for (String element : stringParagraphs) {
            Component paragraphComponent = new TextComposite(ComponentType.PARAGRAPH);
            List<Component> sentences = new ParagraphParser().parse(element);
            for (Component sentence : sentences) {
                paragraphComponent.add(sentence);
            }
            paragraphs.add(paragraphComponent);
        }
        return paragraphs;
    }
}
