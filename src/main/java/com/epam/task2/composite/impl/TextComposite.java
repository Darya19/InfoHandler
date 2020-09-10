package com.epam.task2.composite.impl;

import com.epam.task2.composite.Component;
import com.epam.task2.composite.ComponentType;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements Component {

    private static final String PARAGRAPH_SEPARATOR = "\\n\\t";
    private static final String SENTENCE_SEPARATOR = "[.!?]\\s*";
    private static final String LEXEME_SEPARATOR = "\\s";

    private ComponentType type;
    List<Component> textComponents = new ArrayList<>();

    public TextComposite(ComponentType type) {
        this.type = type;
    }

    public ComponentType getType() {
        return type;
    }

    public List<Component> getTextComponents() {
        return textComponents;
    }

    public int size() {
        return textComponents.size();
    }

    @Override
    public void add(Component component) {
        textComponents.add(component);
    }

    @Override
    public void remove(Component component) {
        textComponents.remove(component);
    }

    @Override
    public Component getChild(int index) {
        return textComponents.get(index);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (Component component : textComponents) {
            if (ComponentType.PARAGRAPH.equals(component.getType())) {
                sb.append(PARAGRAPH_SEPARATOR);
            }
            if (ComponentType.SENTENCE.equals(component.getType())) {
                sb.append(SENTENCE_SEPARATOR);
            }
            if (ComponentType.LEXEME.equals(component.getType())) {
                sb.append(LEXEME_SEPARATOR);
            }
            if (ComponentType.LETTER_OR_DIGIT.equals(component.getType())) {
                sb.append(component);
            }
            if (ComponentType.PUNCTUATION.equals(component.getType())) {
                sb.append(component);
            }
        }
        return sb.toString();
    }
}
