class Solution {
    public List<Integer> grayCode(int n) {
        /*
        0000
        0001
        0010
        0011
        0111
        0110
        0101
        0100
        1100
        1101
        1110
        1111
        1011
        1010
        1001
        1000
        */
        /*
        observe the result, and get the formula
        start from the end of list to beginning
        add the 1 bit at the significant bit.
        it will keep the new sequence as gray code sequence still.

        time:O(2^n)
        space:O(2^n)

        12 / 12 test cases passed.
        Status: Accepted
        Runtime: 1 ms
        35.54%
        */
        List<Integer> ret = new ArrayList<Integer>();
        ret.add(0);
        int tmp;
        for (int i = 1; i <= n; i++){
            for(int j = ret.size()-1; j >= 0; j--){
                tmp = ret.get(j);
                tmp |= (1<<(i-1));
                ret.add(tmp);
            }
        }

        //for (int i = 0; i < ret.size(); i++)
            //System.out.println(ret.get(i));

        return ret;

    }
}
