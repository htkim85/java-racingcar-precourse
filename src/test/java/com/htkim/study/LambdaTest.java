package com.htkim.study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.IntPredicate;

import static org.assertj.core.api.Assertions.assertThat;

class LambdaTest {
    private List<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = List.of(1, 2, 3, 4, 5, 6);
    }

    @Test
    void sumAll() {
        final int result = sumByCondition(numbers, p -> true);
        assertThat(result).isEqualTo(21);
    }

    @Test
    void sumAllEven() {
        final int result = sumByCondition(numbers, p -> p % 2 == 0);
        assertThat(result).isEqualTo(12);
    }

    @Test
    void sumOverThree() {
        final int result = sumByCondition(numbers, p -> p > 3);
        assertThat(result).isEqualTo(15);
    }

    private int sumByCondition(List<Integer> numbers, IntPredicate predicate) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .filter(predicate)
                .sum();
    }
}
