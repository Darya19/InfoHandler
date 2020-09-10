package com.epam.task2.composite;

import java.util.List;
import java.util.Optional;

public interface Component {

    void add(Component component);

    void remove(Component component);

    Component getChild(int index);

    public ComponentType getType();

    public List<Component> getTextComponents();
}
