package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SpeechDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;


    public double SpeechAnalyze(String text,String pattern)
    {
        int score = 0;
        int minLength = Math.min(text.length(), pattern.length());

        for (int i = 0; i < minLength; i++) {
            if (text.charAt(i) == pattern.charAt(i)) {
                score++;
            }
        }

        double matchPercentage = (double) score / pattern.length() * 100;
        return matchPercentage;
    }

    public ArrayList<Integer> kmpSearch(String text, String pattern) {
        int[] prefixTable = constructPrefixTable(pattern);
        ArrayList<Integer> matches = new ArrayList<>();

        int i = 0, j = 0;
        while (i < text.length()) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;

                if (j == pattern.length()) {
                    matches.add(i - j);
                    j = prefixTable[j - 1];
                }
            } else {
                if (j != 0) {
                    j = prefixTable[j - 1];
                } else {
                    i++;
                }
            }
        }

        return matches;
    }

    public int[] constructPrefixTable(String pattern) {
        int[] prefixTable = new int[pattern.length()];
        int length = 0;  // Length of the previous longest prefix suffix

        int i = 1;
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                prefixTable[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = prefixTable[length - 1];
                } else {
                    prefixTable[i] = 0;
                    i++;
                }
            }
        }

        return prefixTable;
    }
    public double calculateMatchPercentage(int textLength, int patternLength) {
        return ((double) patternLength / textLength) * 100;
    }

}
