package com.epam.test.parsertest;

import com.epam.task2.composite.Component;
import com.epam.task2.parser.impl.ParagraphParser;
import com.epam.test.dataprovider.StaticDataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class ParagraphParserTest {

    ParagraphParser parser;

    @BeforeClass
    public void setUp() {
        parser = new ParagraphParser();
    }

    @Test(dataProvider = "parsed paragraph", dataProviderClass = StaticDataProvider.class)
    public void parseParagraphPositiveTest(List<Component> expected) {
        String text = "It has survived - not only five centuries.But also the leap into 13+5 electronic typesetting.";
        List<Component> actual = parser.parse(text);
        assertEquals(actual, expected);
    }
}
