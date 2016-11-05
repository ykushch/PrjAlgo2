package com.ykushch.prjalgo2.task1;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TravellingSalesmanPersonTest {

    @Test
    public void shouldComputePathCorrectly() throws Exception {
        Integer[][] adjacencyMatrix = {
                {0, 374, 200, 223},
                {374, 0, 255, 166},
                {200, 255, 0, 128},
                {223, 166, 128, 0},
        };


        TravellingSalesmanPerson tsp = new TravellingSalesmanPerson();
        List<Integer> path = tsp.tspNearest(0, adjacencyMatrix);
        Assert.assertArrayEquals(path.toArray(), new Integer[]{0, 2, 3, 1, 0});
    }
}