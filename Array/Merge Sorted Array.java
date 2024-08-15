class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i1 = m-1;
        int i2 = n-1;
        int idx = nums1.length-1;
        while(i1>=0 && i2>=0){
            if(nums1[i1]>nums2[i2]){
                nums1[idx] = nums1[i1];
                i1--;
            }else{
                nums1[idx] = nums2[i2];
                i2--;
            }
            idx--;
        }
        while(i1>=0){
            nums1[idx] = nums1[i1];
            i1--;
            idx--;
        }
        while(i2>=0){
            nums1[idx] = nums2[i2];
            i2--;
            idx--;
        }
        
    }
}
