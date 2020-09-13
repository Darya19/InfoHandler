package com.epam.test.parsertest;

import com.epam.task2.composite.Component;
import com.epam.task2.parser.impl.TextParser;
import com.epam.test.dataprovider.StaticDataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class TextParserTest {

    TextParser parser;

    @BeforeClass
    public void setUp() {
        parser = new TextParser();
    }


    @Test(dataProvider = "parsed text", dataProviderClass = StaticDataProvider.class)
    public void parseTextPositiveTest(List<Component> expected) {
        String text = "It has survived - not only five centuries.But also the leap into 13+5 electronic typesetting.\n" +
                "It is a fact.Reader will be distracted.";
        List<Component> actual = parser.parse(text);
        assertEquals(actual, expected);
    }
}
