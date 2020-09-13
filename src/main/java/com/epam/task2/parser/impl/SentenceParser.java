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

public class SentenceParser implements BaseParser {

    private static final String LEXEME_SEPARATOR = "\\s";

    private static Logger logger = LogManager.getLogger();

    @Override
    public List<Component> parse(String text) {
        List<Component> lexemes = new ArrayList<>();
        String[] stringLexemes = text.split(LEXEME_SEPARATOR);
        for (String lexeme : stringLexemes) {
            Component lexemeComponent = new TextComposite(ComponentType.LEXEME);
            List<Component> symbols = new LexemeParser().parse(lexeme);
            for (Component symbol : symbols) {
                lexemeComponent.add(symbol);
            }
            lexemes.add(lexemeComponent);
            logger.log(Level.DEBUG, "list of symbols was added to lexeme component");
        }
        logger.log(Level.DEBUG, "list of lexemes was created");
        return lexemes;
    }
}
