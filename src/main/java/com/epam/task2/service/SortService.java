package com.epam.task2.service;

import com.epam.task2.composite.Component;
import com.epam.task2.composite.ComponentType;
import com.epam.task2.composite.impl.TextComposite;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;
import java.util.List;

public class SortService {

    private static Logger logger = LogManager.getLogger();

    public TextComposite sortParagraphByAmountOfSentences(TextComposite text) {
        List<Component> sortedParagraphs = text.getTextComponents();
        sortedParagraphs.sort(Comparator.comparingInt(p -> p.getTextComponents().size()));
        logger.log(Level.INFO, "paragraphs was sorted by sentence amount");
        return text;
    }

    public TextComposite sortSentencesByLexemesLength(TextComposite text) {
        List<Component> paragraphs = text.getTextComponents();
        for (Component paragraph : paragraphs) {
            List<Component> sentences = paragraph.getTextComponents();
            sentences.sort(Comparator.comparingInt(s -> getMaxLengthOfLexeme(s)));
        }
        logger.log(Level.INFO, "sentences was sorted by lexeme length");
        return text;
    }

    public Component sortLexemesByAmountOfRequiredSymbol(Component text, String symbol) {
        Component newText = new TextComposite(ComponentType.TEXT);
        Component newSentence = new TextComposite(ComponentType.SENTENCE);
        List<Component> paragraphs = text.getTextComponents();
        for (Component paragraph : paragraphs) {
            List<Component> sentences = paragraph.getTextComponents();
            for (Component sentence : sentences) {
                List<Component> lexemes = sentence.getTextComponents();
                for (Component lexeme : lexemes) {
                    newSentence.add(lexeme);
                }
            }
        }
        newSentence.getTextComponents().sort(Comparator
                .comparingInt(l -> getAmountOfRequiredSymbols(l, symbol)));
        newText.add(newSentence);
        return newText;
    }

    private int getAmountOfRequiredSymbols(Component lexeme, String letter) {
        List<Component> symbols = lexeme.getTextComponents();
        int count = 0;
        for (Component symbol : symbols) {
            if (symbol.getSymbol().equalsIgnoreCase(letter)) {
                count++;
            }
        }
        return count;
    }

    private int getMaxLengthOfLexeme(Component sentence) {
        List<Component> lexemes = sentence.getTextComponents();
        int maxSize = 0;
        for (int i = 0; i < lexemes.size() - 1; i++) {
            int firstLexemeSize = lexemes.get(i).getTextComponents().size();
            int secondLexemeSize = lexemes.get(i + 1).getTextComponents().size();
            if (firstLexemeSize > secondLexemeSize) {
                maxSize = firstLexemeSize;
            } else {
                maxSize = secondLexemeSize;
            }
        }
        return maxSize;
    }
}
