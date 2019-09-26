package com.song.leet;

import javafx.util.Pair;

import java.util.*;

public class LadderLength {
    public static void main(String[] args) {
       /* beginWord = "hit",
                endWord = "cog",
                wordList = ["hot","dot","dog","lot","log","cog"]*/

        int r = new LadderLength().ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(r);
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        dfs(beginWord, endWord, wordList, 0, 0);
        System.out.println(r);
        return 0;

    }

    List<String> list = new ArrayList<>();
    static List<List<String>> r = new ArrayList<>();

    private void dfs(String beginWord, String endWord, List<String> wordList, int indx, int level) {
        if (beginWord == endWord) {
            if (r.size() == 0) {
                r.add(new ArrayList<>(list));
                return;
            }
            if (r.get(0).size() > list.size()) {
                r.clear();
                r.add(new ArrayList<>(list));
                return;
            }
            if (r.get(0).size() == list.size()) {
                r.add(new ArrayList<>(list));
                return;
            }
        }
        Set<String> set = new HashSet<>();
        for (int i = indx; i < wordList.size(); i++) {
            if (canSwitch(beginWord, wordList.get(i))) {
                list.add(wordList.get(i));
                dfs(wordList.get(i), endWord, wordList, indx + 1, level + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    public int ladderLength3(String beginWord, String endWord, List<String> wordList) {
        wordList = new ArrayList<>(new HashSet<>(wordList));
        wordList.remove(beginWord);
        Queue<String> Q = new LinkedList<String>();
        Q.offer(beginWord);
        int level = 0;
        int curSizie = 1;
        Set<String> set = new HashSet<>();
        while (!Q.isEmpty()) {
            curSizie--;
            if (curSizie == 0) {
                curSizie = Q.size();
                level++;
            }
            String cur = Q.poll();
            if (endWord.equals(cur)) {
                return level;
            }

            for (String temp : wordList) {
                if (canSwitch(temp, cur) && set.add(temp)) {
                    Q.add(temp);
                }
            }
        }
        return -1;
    }

    private boolean canSwitch(String temp, String cur) {
        int n = 0;
        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) == cur.charAt(i)) {
                n++;
            }
        }
        return n == temp.length() - 1;
    }


    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {

        // Since all words are of same length.
        int L = beginWord.length();

        // Dictionary to hold combination of words that can be formed,
        // from any given word. By changing one letter at a time.
        HashMap<String, ArrayList<String>> allComboDict = new HashMap<String, ArrayList<String>>();

        wordList.forEach(
                word -> {
                    for (int i = 0; i < L; i++) {
                        // Key is the generic word
                        // Value is a list of words which have the same intermediate generic word.
                        String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                        ArrayList<String> transformations =
                                allComboDict.getOrDefault(newWord, new ArrayList<String>());
                        transformations.add(word);
                        allComboDict.put(newWord, transformations);
                    }
                });

        // Queue for BFS
        Queue<Pair<String, Integer>> Q = new LinkedList<Pair<String, Integer>>();
        Q.add(new Pair(beginWord, 1));

        // Visited to make sure we don't repeat processing same word.
        HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
        visited.put(beginWord, true);

        while (!Q.isEmpty()) {
            Pair<String, Integer> node = Q.remove();
            String word = node.getKey();
            int level = node.getValue();
            for (int i = 0; i < L; i++) {

                // Intermediate words for current word
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

                // Next states are all the words which share the same intermediate state.
                for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<String>())) {
                    // If at any point if we find what we are looking for
                    // i.e. the end word - we can return with the answer.
                    if (adjacentWord.equals(endWord)) {
                        return level + 1;
                    }
                    // Otherwise, add it to the BFS Queue. Also mark it visited
                    if (!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord, true);
                        Q.add(new Pair(adjacentWord, level + 1));
                    }
                }
            }
        }

        return 0;
    }

}
