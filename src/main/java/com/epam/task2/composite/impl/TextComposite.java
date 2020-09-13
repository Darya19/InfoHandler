package com.epam.task2.composite.impl;

import com.epam.task2.composite.Component;
import com.epam.task2.composite.ComponentType;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements Component {

    private static final String PARAGRAPH_SEPARATOR = "\n";
    private static final String LEXEME_SEPARATOR = " ";
    private ComponentType type;
    List<Component> textComponents = new ArrayList<>();

    private static Logger logger = LogManager.getLogger();

    public TextComposite(ComponentType type) {
        this.type = type;
        logger.log(Level.DEBUG, "was created object type " + type);
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
    public String getSymbol() {
        throw new UnsupportedOperationException("");//TODO
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
        final StringBuilder builder = new StringBuilder();
        for (Component component : textComponents) {
            if (component.getType().equals(ComponentType.PARAGRAPH)) {
                builder.append(PARAGRAPH_SEPARATOR);
            }
            if (component.getType().equals(ComponentType.LEXEME)) {
                builder.append(LEXEME_SEPARATOR);

            }
            builder.append(component.toString());

        }
        return builder.toString();
    }
}
