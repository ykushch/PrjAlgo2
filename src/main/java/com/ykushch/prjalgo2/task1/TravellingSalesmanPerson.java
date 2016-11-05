package com.ykushch.prjalgo2.task1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class TravellingSalesmanPerson {
    private static final Logger log = LoggerFactory.getLogger(TravellingSalesmanPerson.class);

    /*
    These are the steps of the algorithm:
        1. start on an arbitrary vertex as current vertex.
        2. find out the shortest edge connecting current vertex and an unvisited vertex V.
        3. set current vertex to V.
        4. mark V as visited.
        5. if all the vertices in domain are visited, then terminate.
        6. Go to step 2.
     */
    public List<Integer> tspNearest(int startingPoint, Integer adjacencyMatrix[][]) {
        int verticesCount = adjacencyMatrix[1].length - 1;
        boolean[] visited = new boolean[adjacencyMatrix[1].length];
        int min = Integer.MAX_VALUE;

        List<Integer> finalPath = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        visited[startingPoint] = true;
        deque.push(startingPoint);

        log.info("Path: {}", startingPoint);
        finalPath.add(startingPoint);

        boolean isMinValueFound = false;
        int element;
        int i;
        Integer dst = 0;

        while(!deque.isEmpty()) {
            element = deque.peek();
            i = 0;
            while(i <= verticesCount) {
                Integer curElem = adjacencyMatrix[element][i];
                if(curElem != 0 && !visited[i]) {
                    if(min > curElem) {
                        min = curElem;
                        dst = i;
                        isMinValueFound = true;
                    }
                }
                i++;
            }
            if (isMinValueFound) {
                deque.push(dst);
                log.info("Path: {}", dst);
                finalPath.add(dst);
                visited[dst] = true;
                isMinValueFound = false;
                continue;
            }
            deque.pop();
        }

        addNotVisitedNodes(verticesCount, visited, finalPath);
        log.info("Path: {}", startingPoint);
        finalPath.add(startingPoint);

        return finalPath;
    }

    private void addNotVisitedNodes(int verticesCount, boolean[] visited, List<Integer> finalPath) {
        for(int j = 0; j <= verticesCount; j ++) {
            if(!visited[j]) {
                visited[j] = true;
                log.info("Path: {}", j);
                finalPath.add(j);
            }
        }
    }
}
