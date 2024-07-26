package org.example;

/**
 * @author Rahmatullo Omonov
 * Date: ${DATE}
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
//        System.out.println(main.isMatch("aaaaaa", "a*"));
//        System.out.println(main.isMatch("mississippi", "mis*is*.p*."));
        System.out.println(main.isMatch("aaa", "a*a"));
    }

//    public boolean isMatch(String s, String p) {
//        if (!p.contains("*") && !p.contains(".")) {
//            return s.equals(p);
//        }
//
//        if (p.contains("*") && !p.contains(".")) {
//            return checkRecursive(s, p);
//        }
//
//        if (p.contains(".") && !p.contains(".")) {
//            return checkWithDot(s, p);
//        }
//
//        return checkRecursiveWithDot(s, p);
//    }

    public boolean isMatch(String s, String p) {
        if (s.isEmpty() && p.isEmpty()) {
            return true;
        }

        if (!p.contains(".") && !p.contains("*")) {
            return p.equals(s);
        }

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && i > 0) {
                if (p.charAt(i - 1) == '.') {
                    if (i == 1) {
                        if (i == p.length() - 1) {
                            return true;
                        } else {
                            char lastChar = p.charAt(2);
                            for (int j = 0; j < s.length(); j++) {
                                if (s.charAt(j) == lastChar) {
                                    return isMatch(s.substring(j), p.substring(2));
                                }
                            }
                            return false;
                        }
                    } else {
                        String pSub = p.substring(0, i - 1);
                        String sSub = s.substring(0, i - 1);
                        if (!checkWithDot(sSub, pSub)) {
                            return false;
                        } else {
                            return isMatch(s.substring(i - 1), p.substring(i - 1));
                        }
                    }
                } else {
                    if (i == 1) {
                        char preChar = p.charAt(0);

                        if (s.startsWith(String.valueOf(preChar))) {
                            for (int j = 0; j < s.length(); j++) {
                                if (preChar != s.charAt(j)) {
                                    return isMatch(s.substring(j), p.substring(2));
                                }

                                if (j == s.length() - 1 && s.endsWith(String.valueOf(preChar))) {
                                    return isMatch(s.substring(j + 1), p.substring(2));
                                }
                            }
                        }

                        if (p.length() == 2) {
                            if (s.isEmpty()) {
                                return true;
                            }
                        } else {
                            char nextChar = p.charAt(2);
                            if (s.startsWith(String.valueOf(nextChar))) {
                                return isMatch(s, p.substring(2));
                            }
                        }

                    }
                    String pSub = p.substring(0, i - 1);
                    String sSub = s.substring(0, i - 1);
                    if (!checkWithDot(sSub, pSub)) {
                        return false;
                    } else {
                        return isMatch(s.substring(i - 1), p.substring(i - 1));
                    }
                }
            }
        }

        return checkWithDot(s, p);
    }

    public boolean checkWithAsterisk(String s, String p) {
        if (!p.contains("*")) {
            return p.equals(s);
        }

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*') {
                if (i == 0) {
                    return false;
                }


            }
        }

        return false;
    }

    public boolean checkRecursiveWithDot(String s, String p) {
        if (!p.contains("*") && !p.contains(".")) {
            return s.equals(p);
        }
        for (int i = 0; i < s.length(); i++) {
            if (p.charAt(i) == '*' && i > 0 && i < s.length() - 1) {
                if (p.charAt(i - 1) == '.') {
                    if (i > 2) {
                        String pSub = p.substring(0, i - 1);
                        String sSub = s.substring(0, i - 1);
                        if (!checkWithDot(sSub, pSub)) {
                            return false;
                        }

                        return checkRecursiveWithDot(s.substring(i), p.substring(i));
                    } else {
                        char nextChar = p.charAt(i + 1);
                        for (int j = 0; j < s.length(); j++) {
                            if (s.charAt(j) == nextChar) {
                                return checkRecursiveWithDot(s.substring(0, j + 1), p.substring(i + 2));
                            }
                        }
                    }
                } else {
//                    for (int j = 0; j < s.length(); j++) {
//                        if (s.charAt(j) != p.charAt(i - 1)) {
//                            if (checkRecursive(s.substring(0, j - 1), p.substring(0, i + 1))) {
//                                return checkRecursiveWithDot(s.substring(j), p.substring(i));
//                            }
//                        }
//                    }
                }
            }
        }

        return false;
    }

    public boolean checkRecursive(String s, String p) {
        if (!p.contains("*") && !p.contains(".")) {
            return s.equals(p);
        }

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*') {
//                if (i == 0) {
//                    return false;
//                }
//
//                String sub = s.substring(0, i);
//                String pSub = p.substring(0, i);
//                char lastChar = pSub.charAt(i - 1);
//
//                if (sub.equals(pSub)) {
//                    for (int j = i - 1; j < s.length(); j++) {
//                        if (j == s.length() - 1 && s.charAt(j) == lastChar) {
//                            return checkRecursive(s.substring(j), p.substring(i + 1));
//                        }
//                        if (s.charAt(j) != lastChar) {
//                            return checkRecursive(s.substring(j), p.substring(i + 1));
//                        }
//                    }
//                } else {
//                    if (!sub.contains(String.valueOf(lastChar))) {
//                        return checkRecursive(s, p.substring(i + 1));
//                    }
//                }
            }
        }

        return s.equals(p);
    }

    public boolean checkWithDot(String s, String p) {
        if (p.contains(".") && !p.contains("*")) {
            if (p.length() != s.length()) {
                return false;
            }
            String[] sParts = s.split("");
            String[] pParts = p.split("");
            for (int i = 0; i < s.length(); i++) {
                if (!sParts[i].equals(pParts[i])) {
                    if (!pParts[i].equals(".")) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}