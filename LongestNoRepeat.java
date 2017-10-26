public class LongestNoRepeat{
    /*
        First solution: O(N^3)
        Limit Time Exceeded
    */
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0){
            return 0;
        }
        int longestLength = 1;
        for(int i = 0;i < s.length();i++){
            int length = 1;
            for(int j = i + 1;j < s.length();j++){
                if (i + s.substring(i, j + 1).indexOf(s.charAt(j)) != j){
                    break;
                }
                ++length;
                if(longestLength <= length){
                    longestLength = length;
                }
            }
        }
        return longestLength;
    }
    public static void main(String[] args){
        String test = "abcabcaa";
        String test2 = "aaaaa";
        String test3 = "pwwkew";
        System.out.println("au".substring(0, 2).indexOf("au".charAt(1)));
        System.out.println(lengthOfLongestSubstring(test));
        System.out.println(lengthOfLongestSubstring(test2));
        System.out.println(lengthOfLongestSubstring(test3));
        System.out.println(lengthOfLongestSubstring("au"));
    }
}