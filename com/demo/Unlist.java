package com.demo;

public class Unlist {
    static class RotateArray {

		public void rotate(int[] arr, int i) {
			
		}
        
    }

    public static int kthSmallestnumber(int[] nums) {
        if (nums.length < 4) {
            System.out.println("Array has less than 4 elements");
            return -1; // Or handle this case as needed
        }

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

        return nums[3];
    }

   
    public static class Main {
        public static void main(String[] args) {
            RotateArray r = new RotateArray();
            int arr[] = {1, 2, 3, 4, 5, 6, 7};
            r.rotate(arr, 5);

            // Find the fourth smallest element
            int fourthSmallest = kthSmallestnumber(arr);
            if (fourthSmallest != -1) {
                System.out.println("Fourth smallest element: " + fourthSmallest);
            }
        }
    }
}
