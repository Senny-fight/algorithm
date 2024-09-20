package ws20240910;

public class SolutionLCR006 {

    public int[] twoSum(int[] numbers, int target) {
        //双指针夹中
        int l = 0, r = numbers.length - 1;
        while(l < r) {
            int n = numbers[l] + numbers[r];
            if(n == target) {
                return new int[]{l,r};
            } else if(n > target) {
                r--;
            } else {
                l++;
            }
        }
        return new int[]{-1,-1};
    }
}
