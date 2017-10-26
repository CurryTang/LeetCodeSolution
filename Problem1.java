import java.util.Arrays;

public class Problem1{
    public int[] twoSum(int[] arr, int target){
        for(int i = 0;i < arr.length;i++){
            for(int j = i + 1;j < arr.length;j++){
                if (arr[i] + arr[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    

    public static void main(String[] args){
        int[] test = {2, 7, 11, 15};
        int target = 9;
        Problem1 solution = new Problem1();
        int[] ans = solution.twoSum(test, target);
        for(int an: ans){
            System.out.println(an);
        }
    }
}