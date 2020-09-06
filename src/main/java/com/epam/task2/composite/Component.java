package com.epam.task2.composite;

import java.util.Optional;

public interface Component {

    void add(Component component);

    void remove(Component component);

    Optional<Component> getChild(int index);

    public ComponentType getType();
}
