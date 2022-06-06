package com.geekbrains.lesson4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BoxTest {
    Box box;

    @Nested
    class WhenEmpty {
        @BeforeEach
        void initBox() {
            box = new Box();
        }

        @Test
        void exceptionWhenTryToShuffleEmptyBox() {
            Assertions.assertThrows(ZeroBallsException.class, () -> box.shuffleBalls());
        }

        @Nested
        class WhenOneBall {
            @BeforeEach
            void addBall() {
                box.addBall();
            }

            @Test
            void deleteBall() {
                box.deleteBall();
                Assertions.assertEquals(box.getBallsCount(), 0);
            }

            @Test
            void assertJTest() {
                List<String> strings = new ArrayList<>(Arrays.asList("test1", "test3", "test6"));
                assertThat(strings).containsAnyOf("test3", "test9").containsExactly("test1", "test3", "test6");
                assertThat(5).isGreaterThan(4).isLessThan(7);
            }
        }
    }
}
