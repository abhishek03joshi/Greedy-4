// Time complexity: O(m*logn)
// Space Complexity: O(1)
class Solution {
    public int shortestWay(String source, String target) {
        if (target.length() == 0) return 0;
        if(source.equals(target)) return 1;

        int sp = 0;
        int tp = 0;
        int count = 1;

        HashMap<Character, List<Integer>> map = new HashMap<>();
        for (int i=0; i < source.length(); i++) {
            char c = source.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, new ArrayList<>());
            }
            map.get(c).add(i);
        }

        while (tp < target.length()) {
            char c = target.charAt(tp);
            if (!map.containsKey(c)) {
                return -1;
            }

            List<Integer> list = map.get(c);

            int k = Collections.binarySearch(list, sp);

            if ( k < 0) {
                k = -k -1;
            }

            if (k == list.size()) {
                sp = 0;
                count++;
            }
            else {
                sp = list.get(k);
                sp++;
                tp++;
            }
        }

        return count;
    }
}