package com.epam.test.readertest;

import com.epam.task2.exeption.ProjectException;
import com.epam.task2.reader.FileReader;
import com.epam.test.dataprovider.StaticDataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class ReaderFromFileTest {

    FileReader reader;

    @BeforeClass
    public void setUp() {
        reader = new FileReader();
    }

    @Test(dataProvider = "read text", dataProviderClass = StaticDataProvider.class)
    public void readTextFromActualFilePositiveTest(String expected) {
        try {
            String actual = reader.readFromFile("data\\dataFile.txt");
            assertEquals(actual, expected);
        } catch (ProjectException e) {
            fail();
        }
    }

    @Test(dataProvider = "read text", dataProviderClass = StaticDataProvider.class)
    public void readTextFromDefaultFilePositiveTest(String expected) {
        try {
            String actual = reader.readFromFile("data\\rrayData.txt");
            assertEquals(actual, expected);
        } catch (ProjectException e) {
            fail();
        }
    }

    @Test(expectedExceptions = ProjectException.class)
    public void readNumbersFromFileNegativeTest() throws ProjectException {
        reader.readFromFile("data\\data.mp3");
    }
}
