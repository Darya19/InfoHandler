package com.epam.task2.parser.impl;

import com.epam.task2.composite.Component;
import com.epam.task2.composite.ComponentType;
import com.epam.task2.composite.impl.TextSymbol;
import com.epam.task2.parser.BaseParser;

import java.util.ArrayList;
import java.util.List;

public class LexemeParser implements BaseParser {

    @Override
    public List<Component> parse(String text) {
        List<Component> symbols = new ArrayList<>();
        char[] charSymbols = text.toCharArray();
        for (char element : charSymbols) {
            if (Character.isLetterOrDigit(element)) {
                Component letterComponent = new TextSymbol(Character.toString(element), ComponentType.LETTER_OR_DIGIT);
                symbols.add(letterComponent);
            } else {
                Component punctuation = new TextSymbol(Character.toString(element), ComponentType.PUNCTUATION);
                symbols.add(punctuation);
            }
        }
        return symbols;
    }
}
