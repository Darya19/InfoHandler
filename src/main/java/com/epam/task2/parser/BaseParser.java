package com.epam.task2.parser;

import com.epam.task2.composite.Component;

import java.util.List;

public interface BaseParser {

    List<Component> parse(String text);
}
