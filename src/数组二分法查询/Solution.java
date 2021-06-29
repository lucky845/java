package 数组二分法查询;


public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.Find(new int[][]{{1,2,3,4},{5,4,6,5},{4,5,6,9},{8,7,8,9}},3));
    }
    public boolean Find(int [][] array,int target) {

        for(int i=0;i<array.length;i++){
            int low=0;
            int high=array[i].length-1;
            while(low<=high){
                int mid=(low+high)/2;
                if(target>array[i][mid])
                    low=mid+1;
                else if(target<array[i][mid])
                    high=mid-1;
                else
                    return true;
            }
        }
        return false;

    }
}