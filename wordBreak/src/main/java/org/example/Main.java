package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        wordBreak("catsanddog", List.of("cat", "cats", "and", "sand", "dog"));
    }

    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans = new ArrayList<>();

        Map<String, Boolean > words= new HashMap<>();

        for(String ss: wordDict ){
            words.put(ss, false);
        }

        recurse(s, words, ans);

        return ans;
    }

    public static void recurse(String s, Map<String, Boolean > wordDict, List<String> ans) {

        for (String ss : wordDict.keySet()) {
            if (s.startsWith(ss) && !wordDict.get(ss)) {
                s = s.substring(ss.length());
                if (ans.isEmpty()) {
                    ans.add(ss);
                } else {
                    String last = ans.get(ans.size() - 1);
                    last = last.replace(" ", "");
                    if (!last.equals(s)) {
                        ans.set(ans.size() - 1, ans.get(ans.size() - 1) + " " + ss);
                    } else {
                        ans.add(ss);
                    }
                }
                wordDict.put(ss, true);
                if (s.isBlank()) {
                    break;
                }
                recurse(s, wordDict, ans);
            }
        }
    }
}