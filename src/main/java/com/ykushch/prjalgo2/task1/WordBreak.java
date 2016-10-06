package com.ykushch.prjalgo2.task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.joining;

public class WordBreak {

    /**
     * Breaks words using naive approach (plain recursion)
     * @param s sentence without spaces
     * @param dict dictionary with unique words
     * @return sentence with spaces based on dictionary
     */
    public String breakWordRecursively(String s, Set<String> dict) {
        List<String> resultList = new ArrayList<>();
        if (!couldBreakSentenceRecursively(s, dict, 0, resultList)) {
            return "";
        }
        Collections.reverse(resultList);
        return resultList.stream()
                .collect(joining(" "));
    }

    private boolean couldBreakSentenceRecursively(String s, Set<String> dict, int start, List<String> resultList) {
        if(start == s.length()) {
            return true;
        }

        for(String a: dict) {
            int len = a.length();
            int end = start + len;

            if(end > s.length()) {
                continue;
            }

            if(s.substring(start, end).equals(a)) {
                if(couldBreakSentenceRecursively(s, dict, start + len, resultList)) {
                    resultList.add(s.substring(start, start + len));
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Breaks words using dynamic programming approach
     * @param s sentence without spaces
     * @param dict dictionary with unique words
     * @return sentence with spaces based on dictionary
     */
    public String breakWord(String s, Set<String> dict) {
        List<String> result = breakDownSentence(s, dict);

        if (result.isEmpty()) {
            return "";
        }
        return result.stream()
                .collect(joining(" "));
    }

    private List<String> breakDownSentence(String sentence, Set<String> dict) {
        List<String> resultBreakDownList = new ArrayList<>();
        boolean[] result = new boolean[sentence.length() + 1];
        result[0] = true;

        for (int i = 0; i < sentence.length(); i++) {
            if(!result[i]) {
                continue;
            }

            for (String wordFromDict : dict) {
                int len = wordFromDict.length();
                int end = i + len;

                if(end > sentence.length() || result[end]) {
                    continue;
                }

                if(sentence.substring(i, end).equals(wordFromDict)) {
                    resultBreakDownList.add(wordFromDict);
                    result[end] = true;
                }
            }
        }

        return resultBreakDownList;
    }
}
