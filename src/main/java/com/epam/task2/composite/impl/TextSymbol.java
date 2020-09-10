package com.epam.task2.composite.impl;

import com.epam.task2.composite.Component;
import com.epam.task2.composite.ComponentType;

import java.util.List;

public class TextSymbol implements Component {

    private String symbol;
    private ComponentType type;

    public TextSymbol(String symbol, ComponentType type) {
        this.symbol = symbol;
        this.type = type;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public void add(Component component) {
        throw new UnsupportedOperationException("impossible add symbol");
    }

    @Override
    public void remove(Component component) {
        throw new UnsupportedOperationException("impossible remove symbol");
    }

    @Override
    public Component getChild(int index) {
        throw new UnsupportedOperationException("impossible remove symbol ");
    }

    @Override
    public ComponentType getType() {
        return type;
    }

    @Override
    public List<Component> getTextComponents() {
        throw new UnsupportedOperationException("symbol class hasn't got inner object");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TextSymbol that = (TextSymbol) o;

        return symbol != null ? symbol.equals(that.symbol) : that.symbol == null;
    }

    @Override
    public int hashCode() {
        return symbol != null ? symbol.hashCode() : 0;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
