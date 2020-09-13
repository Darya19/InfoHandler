package com.epam.task2.parser.impl;

import com.epam.task2.composite.Component;
import com.epam.task2.composite.ComponentType;
import com.epam.task2.composite.impl.TextComposite;
import com.epam.task2.parser.BaseParser;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TextParser implements BaseParser {

    private static final String PARAGRAPH_SEPARATOR = "\n";

    private static Logger logger = LogManager.getLogger();

    @Override
    public List<Component> parse(String text) {
        List<Component> paragraphs = new ArrayList<>();
        String[] stringParagraphs = text.split(PARAGRAPH_SEPARATOR);
        for (String paragraph : stringParagraphs) {
            Component paragraphComponent = new TextComposite(ComponentType.PARAGRAPH);
            List<Component> sentences = new ParagraphParser().parse(paragraph);
            for (Component sentence : sentences) {
                paragraphComponent.add(sentence);
                logger.log(Level.DEBUG, "list of sentences was added to paragraph component");
            }
            paragraphs.add(paragraphComponent);
        }
        logger.log(Level.DEBUG, "list of paragraphs was created");
        return paragraphs;
    }
}
