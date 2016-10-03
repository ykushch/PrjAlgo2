package com.ykushch.prjalgo2.task4;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EditDistanceTest {

    @Test
    public void shouldReturnCorrectSequenceWhenLcsApplied() throws Exception {
        String inputA = "horizon";
        String inputB = "horizontal";

        int result = EditDistance.computeRecursively(inputA, inputB);

        assertThat(result).isEqualTo(3);
    }

}