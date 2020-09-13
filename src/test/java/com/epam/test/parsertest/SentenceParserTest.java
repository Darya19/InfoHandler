package com.epam.test.parsertest;

import com.epam.task2.composite.Component;
import com.epam.task2.parser.impl.SentenceParser;
import com.epam.test.dataprovider.StaticDataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class SentenceParserTest {

    SentenceParser parser;

    @BeforeClass
    public void setUp() {
        parser = new SentenceParser();
    }

    @Test(dataProvider = "parsed sentence", dataProviderClass = StaticDataProvider.class)
    public void parseSentencePositiveTest(List<Component> expected) {
        String text = "It has survived - not only five centuries.";
        List<Component> actual = parser.parse(text);
        assertEquals(actual, expected);
    }
}
