package com.epam.task2.parser.impl;

import com.epam.task2.composite.Component;
import com.epam.task2.composite.ComponentType;
import com.epam.task2.composite.impl.TextComposite;
import com.epam.task2.parser.BaseParser;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser implements BaseParser {

    private static final String SENTENCE_SEPARATOR = "[\\p{LD}\\p{Space}'\",:;\\-+*/()=]*[.?!\u2026]?";
    private static final String MATH_SENTENCE = "[0-9()+=\\-*/]{3,}";

    private static Logger logger = LogManager.getLogger();

    @Override
    public List<Component> parse(String text) {
        List<Component> sentences = new ArrayList<>();
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("JS");
        logger.log(Level.DEBUG, "ScriptEngine object was created");
        Pattern patternSentence = Pattern.compile(SENTENCE_SEPARATOR);
        Matcher sentenceMatcher = patternSentence.matcher(text);
        String sentence = "";
        while (sentenceMatcher.find()) {
            sentence = sentenceMatcher.group();
            Pattern mathSentence = Pattern.compile(MATH_SENTENCE);
            Matcher mathMatcher = mathSentence.matcher(sentence);
            while (mathMatcher.find()) {
                String mathPart = mathMatcher.group();
                try {
                    sentence = sentence.replace(mathPart, engine.eval(mathPart).toString());
                } catch (ScriptException e) {
                    logger.log(Level.ERROR, "impossible interpritate math expression");
                }
            }
            Component sentenceComponent = new TextComposite(ComponentType.SENTENCE);
            List<Component> lexemes = new SentenceParser().parse(sentence);
            for (Component lexeme : lexemes) {
                sentenceComponent.add(lexeme);
            }
            sentences.add(sentenceComponent);
            logger.log(Level.DEBUG, "list of lexemes was added to sentence component");
        }
        logger.log(Level.DEBUG, "list of sentences was created");
        return sentences;
    }
}
