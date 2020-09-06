package com.epam.task2.parser.impl;

import com.epam.task2.composite.Component;
import com.epam.task2.composite.ComponentType;
import com.epam.task2.composite.impl.TextComposite;
import com.epam.task2.parser.BaseParser;

import java.util.ArrayList;
import java.util.List;

public class LexemeParser implements BaseParser {

    private static final String LEXEME_SEPARATOR = "\\s";

    @Override
    public List<Component> parse(String text) {
        List<Component> lexemes = new ArrayList<>();
        String[] stringLexemes = text.split(LEXEME_SEPARATOR);
        for (String element : stringLexemes) {
            Component lexeme = new TextComposite(ComponentType.LEXEME);
            List<Component> symbols = new SymbolParser().parse(element);
            for (Component symbol : symbols) {
                lexeme.add(symbol);
            }
            lexemes.add(lexeme);
        }
        return lexemes;
    }
}
