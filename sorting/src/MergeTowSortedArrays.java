public class MergeTowSortedArrays {
    public static void main(String args[]){
        int arr1[] = {1,3,5,7};
        int arr2[] = {0,2,6,8,9};

        int arr[] = new int[arr1.length+arr2.length];
        int left  = 0;
        int right = 0;
        int i = 0;
        while(left<arr1.length && right<arr2.length){
            if(arr1[left]<=arr2[right]){
                arr[i] = arr1[left];
                left++;
            }else{
                arr[i] = arr2[right];
                right++;
            }
            i++;
        }
        //insert remaining element in the new list
        while(left<arr1.length){
            arr[i] = arr1[left];
            left++;
            i++;
        }

        while(right<arr2.length){
            arr[i] = arr2[right];
            right++;
            i++;
        }

        for(int element : arr){
            System.out.print(element + " ");
        }
    }
}
