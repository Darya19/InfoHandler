package com.epam.task2.parser.impl;

import com.epam.task2.composite.Component;
import com.epam.task2.composite.ComponentType;
import com.epam.task2.composite.impl.TextSymbol;
import com.epam.task2.parser.BaseParser;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class LexemeParser implements BaseParser {

    private static Logger logger = LogManager.getLogger();

    @Override
    public List<Component> parse(String text) {
        List<Component> symbols = new ArrayList<>();
        char[] charSymbols = text.toCharArray();
        for (char symbol : charSymbols) {
            if (Character.isLetterOrDigit(symbol)) {
                Component letterComponent = new TextSymbol(Character.toString(symbol),
                        ComponentType.LETTER_OR_DIGIT);
                symbols.add(letterComponent);
            } else {
                Component punctuation = new TextSymbol(Character.toString(symbol), ComponentType.PUNCTUATION);
                symbols.add(punctuation);
            }
        }
        logger.log(Level.DEBUG, "list of symbols was created");
        return symbols;
    }
}
