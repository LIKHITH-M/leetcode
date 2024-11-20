import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        // Initialize the two sets for Bidirectional BFS
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);

        int level = 1;

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            // Always expand the smaller set to optimize search
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            Set<String> nextSet = new HashSet<>();
            for (String word : beginSet) {
                char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char originalChar = chars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                        String transformedWord = new String(chars);

                        if (endSet.contains(transformedWord)) {
                            return level + 1;
                        }

                        if (wordSet.contains(transformedWord)) {
                            nextSet.add(transformedWord);
                            wordSet.remove(transformedWord); // Avoid revisiting
                        }
                    }
                    chars[i] = originalChar; // Restore original character
                }
            }
            beginSet = nextSet;
            level++;
        }

        return 0;
    }
}
