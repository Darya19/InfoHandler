package com.epam.test.parsertest;

import com.epam.task2.composite.Component;
import com.epam.task2.parser.impl.LexemeParser;
import com.epam.test.dataprovider.StaticDataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class LexemeParserTest {

    LexemeParser parser;

    @BeforeClass
    public void setUp() {
        parser = new LexemeParser();
    }

    @Test(dataProvider = "parsed lexeme", dataProviderClass = StaticDataProvider.class)
    public void parseLexemePositiveTest(List<Component> expected) {
        String text = "It";
        List<Component> actual = parser.parse(text);
        assertEquals(actual, expected);
    }
}
