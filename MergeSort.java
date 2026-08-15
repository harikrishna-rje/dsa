// Online Java - IDE, Code Editor, Compiler

// Online Java is a quick and easy tool that helps you to build, compile, test your programs online.

// Write your Java code here

import java.util.Arrays;

public class MergeSort {
  public static void main(String[] args) {
    int[] sortArr = {38, 27, 43, 3, 9, 82, 10};
    System.out.println("Pre Sort:"+ Arrays.toString(sortArr));
    mergesort(sortArr);
    System.out.println("Post Sort:"+ Arrays.toString(sortArr));
  }
  public static void mergesort(int src[]){
      if(src == null || src.length <= 1){
          return;
      }
      sort(src, 0, src.length-1);
  }
  private static void sort(int src[], int left, int right){
      if(left>=right){
          return;
      }
      // it helps to prevent overflow of large indices
      int mid = left+(right-left)/2;
      // sort left sub arry
      sort(src, left, mid);
      // sort right sub arry
      sort(src, mid+1, right);
      // merge the both arrys
      sort(src, left, mid, right);
  }
  private static void sort(int src[], int left, int mid, int right){
      //find the sizes of sub Arrays
      int s1 = mid-left+1;
      int s2 = right-mid;
      // take 2 temp array for left & right arrary
      int leftArr[] = new int[s1];
      int rightArr[] = new int[s2];
      
      // copy the data to temp Arrays
      System.arraycopy(src, left, leftArr, 0, s1);
      System.arraycopy(src, mid+1, rightArr, 0, s2);
      //initialize indices for left& right sub array
      int i=0; int j=0;
      int k = left;
      //initial indices for temp Arrays
      while(i<s1 && j<s2){
          if (leftArr[i]<=rightArr[j]){
             src[k++] =  leftArr[i++];
          } else {
              src[k++] = rightArr[j++];
          }
      }
      // copy the remaining elements of left Arrays
      while(i<s1){
        src[k++] = leftArr[i++];
      }
      // copy the remaining elements of right Arrays
      while(j<s2){
        src[k++] = rightArr[j++];
      }
  }
}
