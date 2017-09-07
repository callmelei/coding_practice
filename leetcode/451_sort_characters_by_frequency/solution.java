class Solution {
    public String frequencySort(String s) {
        /*
        although we can count the frequency at linear time.
        how to sort the value with customized structure
        
        It can use bucket sort
        it will waste some spaces though.
        I use the collection sort
        
        Use StringBuilder, the performance is much better than String.
        
        35 / 35 test cases passed.
        Status: Accepted
        Runtime: 22 ms
        87.21%
        
        */
        int []count = new int[256];
        for (int i = 0; i < 256; i++) {
            count[i] = 0;
        }
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)] ++;
        }
        
        List<int []> list = new ArrayList<int []>();
        
        for (int i = 0; i < 256; i++) {
            if (count[i] > 0) {
                int [] temp = new int[2];
                temp[0] = i;
                temp[1] = count[i];
                list.add(temp);   
            }
            
        }
        
        Collections.sort(list,new Comparator<int []>() {
        @Override
        public int compare(int[] a, int[] b) {
            
            if (a[1] == b[1])
                return 0;
            else if (a[1] > b[1])
                return -1;
            else
                return 1;
        }
        }); 

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < list.size(); i++) {
            char c = (char) list.get(i)[0];
            for (int j = 0; j < list.get(i)[1]; j++){
                sb.append(c);
            }
            
        }
        return sb.toString();
        
    }
}
