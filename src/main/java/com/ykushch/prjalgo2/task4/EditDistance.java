package com.ykushch.prjalgo2.task4;

import java.util.Arrays;
import java.util.Collections;

public class EditDistance {
    public static int computeRecursively(String srcString, String destString) {
        int srcStrLen = srcString.length();
        int destStrLen = destString.length();

        if (srcStrLen == 0) {
            // insert all
            return destStrLen;
        }

        if (destStrLen == 0) {
            // remove all
            return srcStrLen;
        }

        char srcCharEnd = srcString.charAt(srcStrLen - 1);
        char destCharEnd = destString.charAt(destStrLen - 1);

        if (srcCharEnd == destCharEnd) {
            return computeRecursively(srcString.substring(0, srcStrLen - 1), destString.substring(0, destStrLen - 1));
        }

        int insertOperationCounter = computeRecursively(srcString, destString.substring(0, destStrLen - 1));
        int removeOperationCounter = computeRecursively(srcString.substring(0, srcStrLen - 1), destString);
        int replaceOperationCounter = computeRecursively(srcString.substring(0, srcStrLen - 1), destString.substring(0, destStrLen - 1));

        return 1 + Collections.min(Arrays.asList(insertOperationCounter, removeOperationCounter, replaceOperationCounter));
    }
}
