package com.geekbrains.lesson4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;

public class FunctionsTest {
    private static Logger logger = LoggerFactory.getLogger(FunctionsTest.class);

    @BeforeAll
    static void beforeAll() {
        WebDriverManager.chromedriver().setup();
        // TRACE, DEBUG, INFO, WARN, ERROR
        logger.error("error");
        logger.info("info");
        logger.trace("trace");
        System.out.println("Метод выполнится 1 раз перед всеми тестами данного класса");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Метод выполнится перед каждым тестом");
    }

    @Test
    //@Disabled
    @DisplayName("Тест проверяет метод ispalindrome с палиндромом")
    void givenPalindomeWhenCallIsPalindomeMethodThenTrue() {
        boolean result = Functions.isPalindrome("1234321");
        Assertions.assertTrue(result);
        //Assertions.assertEquals(true, result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1234321", "1"})
    void checkWordWithOneCharacterIsPalindome(String word) {
        boolean result = Functions.isPalindrome(word);
        Assertions.assertTrue(result);
    }

    @ParameterizedTest
    @CsvSource({"1234321, true", "12, false"})
    void checkIsPalindome(String word, boolean expectedResult) {
        boolean result = Functions.isPalindrome(word);
        Assertions.assertEquals(result, expectedResult);
    }

    @ParameterizedTest
    @MethodSource("catsDataProvider")
    void catTest(Cat cat, boolean isVaccinated) {
        Assertions.assertEquals(cat.isVaccinated(), isVaccinated);
    }

    private static Stream<Arguments> catsDataProvider() {
        return Stream.of(
                Arguments.of(new Cat("Moris", true), true),
                Arguments.of(new Cat("Barssik", false), true)
        );
    }

    @Test
    void assumeTest() {
        Assumptions.assumeTrue(1 == 2);
        Assertions.assertTrue(true);
    }

    @Test
    void assertAllTest() {
        Assertions.assertAll(
                () -> Assertions.assertTrue(true),
                () -> Assertions.assertEquals(1, 2),
                () -> Assertions.assertEquals(1, 3)
        );
    }

    @AfterEach
    void afterEach() {
        System.out.println("Метод выполнится после каждого теста");
    }

    @AfterAll
    static void tearDown() {
        System.out.println("Метод выполнится 1 раз после запуска всех тестов класса");
    }
}
