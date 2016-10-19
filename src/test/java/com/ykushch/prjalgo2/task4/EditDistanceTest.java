package com.ykushch.prjalgo2.task4;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class EditDistanceTest {
    @Test
    public void computeMinEditDistance() throws Exception {
        String src = "world";
        String dest = "fyord";
        int result = EditDistance.computeMinEditDistance(src, dest, true);
        assertThat(result).isEqualTo(3);
    }

}