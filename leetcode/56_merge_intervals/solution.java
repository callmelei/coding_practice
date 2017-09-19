/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    /*
    169 / 169 test cases passed.
Status: Accepted
Runtime: 25 ms
78.42%
time:O(nlogn)
space:O(n)
    */
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> newIntervals = new ArrayList<Interval>();
        if (intervals.size() == 0)
            return intervals;
        
        /*Comparator<Interval> comp = new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return (a.start-b.start);
            }
        };
        Collections.sort(intervals,comp);

        */
        
         // Sort by ascending starting point using an anonymous Comparator
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
    
        //for(int i = 0; i < intervals.size(); i ++) {
        //    System.out.print("[" + intervals.get(i).start + "," + intervals.get(i).end + "]");
        //}
      
        int start = 0;
        int end = 0;
        start = intervals.get(0).start;
        end = intervals.get(0).end;
        for(int j = 0; j < intervals.size(); j++) {
                if (intervals.get(j).start > end){
                    Interval interval = new Interval(start, end);
                    newIntervals.add(interval);
                    start = intervals.get(j).start;
                    end = intervals.get(j).end;
                    continue;
                }
            
                //if (intervals.get(j).start < start)
                //    start = intervals.get(j).start; //since we have already sort the list before, no need this statement
                if (intervals.get(j).end > end)
                    end = intervals.get(j).end;
                
                
                    //System.out.print("[" + intervals.get(i).start + "," + intervals.get(i).end + "]");
        }
        Interval interval = new Interval(start, end);
        newIntervals.add(interval);
        return newIntervals;
    }
}
