package com.epam.task2.service;

import com.epam.task2.composite.Component;
import com.epam.task2.composite.impl.TextComposite;

import java.util.Comparator;
import java.util.List;

public class SortService {

    public List<Component> sortParagraphByAmountOfSentences(TextComposite text) {
        List<Component> sortedParagraphs = text.getTextComponents();
        sortedParagraphs.sort(Comparator.comparingInt(p -> p.getTextComponents().size()));
        return sortedParagraphs;
    }

    public List<Component> sortSentencesByLexemesLength(TextComposite text) {
        List<Component> paragraphs = text.getTextComponents();
        for (Component paragraph : paragraphs) {
            List<Component> sentences = paragraph.getTextComponents();
            for (Component sentence : sentences) {
                List<Component> lexemes = sentence.getTextComponents();
                lexemes.sort(Comparator.comparingInt(l -> l.getTextComponents().size()));
            }
        }
        return paragraphs; //TODO what return
    }

    public List<Component> sortLexemesByAmountOfRequiredSymbol(TextComposite text, String symbol) {
        List<Component> paragraphs = text.getTextComponents();
        for (Component paragraph : paragraphs) {
            List<Component> sentences = paragraph.getTextComponents();
            for (Component sentence : sentences) {
                List<Component> lexemes = sentence.getTextComponents();
                for (Component lexeme : lexemes) {
                    //TODO sort by alphabet
                    lexeme.getTextComponents().sort(Comparator.comparing(s -> amountOfRequiredSymbols(s, symbol)));
                }
            }
        }
        return paragraphs;
    }

    private int amountOfRequiredSymbols(Component lexeme, String letter) {
        List<Component> symbols = lexeme.getTextComponents();
        int count = 0;
        for (int i = 0; i < symbols.size() - 1; i++) {
            if (symbols.get(i).equals(letter)) {
                count++;
            }
        }
        return count;
    }
}
