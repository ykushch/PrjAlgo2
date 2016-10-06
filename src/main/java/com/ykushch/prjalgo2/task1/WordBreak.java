package com.ykushch.prjalgo2.task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.joining;

public class WordBreak {
    public List<String> finalRes = new ArrayList<>();

    public String breakWord(String s, Set<String> dict) {
        if (!couldBreakSentence(s, dict, 0)) {
            return "";
        }
        Collections.reverse(finalRes);
        return finalRes.stream()
                .collect(joining(" "));
    }

    private boolean couldBreakSentence(String s, Set<String> dict, int start) {
        if(start == s.length()) {
            return true;
        }

        for(String a: dict) {
            int len = a.length();
            int end = start + len;

            if(end > s.length()) {
                continue;
            }

            if(s.substring(start, start + len).equals(a)) {
                if(couldBreakSentence(s, dict, start + len)) {
                    finalRes.add(s.substring(start, start + len));
                    return true;
                }
            }
        }
        return false;
    }
}
