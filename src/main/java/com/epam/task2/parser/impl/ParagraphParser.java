package com.epam.task2.parser.impl;

import com.epam.task2.composite.Component;
import com.epam.task2.composite.ComponentType;
import com.epam.task2.composite.impl.TextComposite;
import com.epam.task2.parser.BaseParser;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser implements BaseParser {

    private static final String SENTENCE_SEPARATOR = "[\\p{LD}\\p]*[.?!])";
    private static final String MATH_SENTENCE = "[0-9()+=\\-*/]+";

    @Override
    public List<Component> parse(String text) {
        List<Component> sentences = new ArrayList<>();
        Pattern patternSentence = Pattern.compile(SENTENCE_SEPARATOR);
        Matcher matcher = patternSentence.matcher(text);
        String sentence = "";
        String sentence1 = "";
        while (matcher.find()) {
            sentence = matcher.group();
                Pattern mathSentence = Pattern.compile(MATH_SENTENCE);
                 matcher = mathSentence.matcher(sentence);
            ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("JavaScript");
            while (matcher.find()) {
                sentence1 = matcher.group();
       //double value = (double) engine.eval(sentence1);
                try {
                    sentence.replaceAll(MATH_SENTENCE, engine.eval(sentence1).toString());
                } catch (ScriptException e) {
                    e.printStackTrace();
                }
            }
            Component sentenceComponent = new TextComposite(ComponentType.SENTENCE);
            List<Component> lexemes = new SentenceParser().parse(sentence);
            for (Component lexeme : lexemes) {
                sentenceComponent.add(lexeme);
            }
            sentences.add(sentenceComponent);
        }
        return sentences;
    }

    public static void main(String[] args) throws IOException, ScriptException {
//        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
   //     (^[\p{Alpha}*[;:,]?\p{Space}]*[.?!;]$)
//        String sentence = r.readLine();
//        Pattern patternSentence = Pattern.compile("[0-9.()+=\\-*/]+");
//        Matcher matcher = patternSentence.matcher("popularised in the 5*(1*2*(3*(4*(5-3+4)-3)-2)-1) with");
//        String s = "";
//        while (matcher.find()) {
//            s = matcher.group();
//            System.out.println(s);
//        }
//
        Pattern patternSentence = Pattern.compile(SENTENCE_SEPARATOR);
        Matcher matcher = patternSentence.matcher("popularised in the 5*(1*2*(3*(4*(5-2+4)-3)-2)-1) bjhjbu. It is a long established fact that a reader will be." +
                "    It is a (-5+1/2*(2+5*2-2))*1200 established.");
        String s = "";
        while (matcher.find()) {
            String sentence = matcher.group();
            System.out.println(sentence);
            Pattern mathSentence = Pattern.compile(MATH_SENTENCE);
            Matcher matcher1 = mathSentence.matcher(sentence);
            ScriptEngineManager factory = new ScriptEngineManager();
            ScriptEngine engine = factory.getEngineByName("JavaScript");
            while (matcher1.find()) {
               String sentence1 = matcher1.group();
                System.out.println("bjub " + sentence1);
                //double value = (double) engine.eval(sentence1);
            s =  sentence.replaceAll(MATH_SENTENCE, engine.eval(sentence1).toString());
            }
            System.out.printf(s);
   }}}

