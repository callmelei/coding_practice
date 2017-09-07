
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        /*
        https://discuss.leetcode.com/topic/43893/simple-java-bfs-solution-with-explanation/2
        39 / 39 test cases passed.
        Status: Accepted
        Runtime: 129 ms
        51.86%
        
        BFS is the way to check the shotest path in the graph
        If we want to improve the speed, we can replace the list check function with hashmap implementation.
        
        Time:  O(|V| + |E|)
        Space: O(n)
        */
        //wordList.add(endWord);
        Queue<String> queue = new LinkedList<String>();
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        for (int i = 0; i < wordList.size(); i++) {
            hashMap.put(wordList.get(i), 1);
        }
        queue.add(beginWord);
        int level = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.remove();
                //System.out.print (curr);
                if (curr.equals(endWord)) return level + 1;
                for (int j = 0; j < curr.length(); j ++){
                    char [] word = curr.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        word[j] = c;
                        //System.out.println(word);
                        String check = new String(word); 
                        if (!check.equals(curr) && hashMap.get(check) != null && hashMap.get(check) == 1 /*wordList.contains(check)*/) {
                            queue.add(check);
                            //wordList.remove(check); //replace it with hashmap implementation.
                            hashMap.put(check, 0);
                            
                        }
                    }
                    
                }
                
            }
            level ++;  
        }
        return 0;
    }   
}
