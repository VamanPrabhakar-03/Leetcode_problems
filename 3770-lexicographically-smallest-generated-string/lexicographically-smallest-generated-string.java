class Solution {
    public String generateString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        
        char[] word = new char[n + m - 1];
        
        // Step 1: Fill with '?'
        for (int i = 0; i < word.length; i++) {
            word[i] = '?';
        }

        // Step 2: Apply 'T' constraints
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    if (word[i + j] == '?' || word[i + j] == str2.charAt(j)) {
                        word[i + j] = str2.charAt(j);
                    } else {
                        return ""; // conflict
                    }
                }
            }
        }

        // Step 3: Fill remaining '?' with 'a'
        for (int i = 0; i < word.length; i++) {
            if (word[i] == '?') {
                word[i] = 'a';
            }
        }

        // Step 4: Handle 'F' constraints
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'F') {
                boolean match = true;

                for (int j = 0; j < m; j++) {
                    if (word[i + j] != str2.charAt(j)) {
                        match = false;
                        break;
                    }
                }

                // If it matches, we must break it
                if (match) {
                    boolean broken = false;

                    // try modifying from right to left (minimal impact)
                    for (int j = m - 1; j >= 0; j--) {
                        int idx = i + j;

                        for (char c = 'a'; c <= 'z'; c++) {
                            if (c != word[idx]) {
                                char original = word[idx];
                                word[idx] = c;

                                // check still valid for all T constraints
                                if (isValid(word, str1, str2)) {
                                    broken = true;
                                    break;
                                }

                                word[idx] = original;
                            }
                        }
                        if (broken) break;
                    }

                    if (!broken) return "";
                }
            }
        }

        return new String(word);
    }

    // Helper to re-check all 'T' constraints
    private boolean isValid(char[] word, String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    if (word[i + j] != str2.charAt(j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}