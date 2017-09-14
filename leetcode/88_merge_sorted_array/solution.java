class Solution {
    public void merge_from_end_to_begin_less_complex(int[] nums1, int m, int[] nums2, int n) {
        /*
        59 / 59 test cases passed.
Status: Accepted
Runtime: 0 ms
31.73%
        */
        int end = m+n-1;
        if (n == 0) return;
        int n1 = m-1;
        int n2 = n-1;
        for (int i = end; i >= 0; i--) {
            
            if (n1 < 0 && n2 >= 0) 
                nums1[i] = nums2[n2--];
            else if (n2 < 0) 
                break;
            else if (nums1[n1] > nums2[n2])
                nums1[i] = nums1[n1--];
            else
                nums1[i] = nums2[n2--];
            
        }
        
    }
    
    public void merge_from_begin_to_end_complex(int[] nums1, int m, int[] nums2, int n) {

        if (n == 0) return;
        int curr = m + n - 1;
        for (int i = m-1; i >= 0; i--) {
            nums1[curr] = nums1[i];
            //System.out.println("->" + curr+ nums1[curr]+ i);

            curr --;
            
        }
    
        int id1 = n;
        int id2 = 0;
        //System.out.println("id1:" + id1);
        //System.out.println("id2:" + id2);
        for (curr = 0; curr < m+n; curr++) {
        //System.out.println("id1:" + id1);
        //System.out.println("id2:" + id2);

            if (id1 >= m+n && id2 < n)
                nums1[curr] = nums2[id2++];
            else if (id2 >= n )
                break;
            else if (nums1[id1] < nums2[id2])
                nums1[curr] = nums1[id1++];
            else
                nums1[curr] = nums2[id2++];
            
        //System.out.println("curr:"+nums1[curr]);
  
        }
        
        return ;
    }
}
