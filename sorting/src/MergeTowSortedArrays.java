import java.util.Arrays;



public class MergeTowSortedArrays {
    private void mergeSortedarrayInPlace(int arr1[], int arr2[]){
        int left = arr1.length-1;
        int right = 0;
        while(left>=0&& right<arr2.length){
            if(arr1[left]>arr2[right]) {
                int temp = arr1[left];
                arr1[left] = arr2[right];
                arr2[right] = temp;
                left--;
                right++;
            }else{
                break;
            }

        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for(int element: arr1){
            System.out.print(element+ " ");
        }
        for(int element: arr2){
            System.out.print(element+ " ");
        }
    }



    private void swapIfGreater(int[] arr1, int[] arr2, int left, int right) {
        if(arr1[left]>arr2[right]){
            int temp = arr1[left];
            arr1[left] = arr2[right];
            arr2[right] = temp;
        }

    }

    private void mergeSortedArrayInPlaceShellSort(int arr1[], int arr2[]){
        int length  = arr1.length+arr2.length;
        int gap = (length/2)+(length%2); // this is the ceil value of gap

        while(gap>0){
            int left  = 0;
            int right = left+gap;

            while(right<length){

                if(left<arr1.length && right>=arr1.length ){//case1 when both left and right are in different array
                    swapIfGreater(arr1, arr2, left, right-arr1.length);
                }else if(left<arr1.length && right<arr1.length){  //case 2 When left & right are in array1
                    swapIfGreater(arr1, arr1, left, right);
                }else{  //case 3 When left and right are in array2
                    swapIfGreater(arr2, arr2, left-arr1.length, right-arr1.length);
                }
                left++;
                right++;
            }
            if(gap==1) break;
            gap = gap/2 +(gap%2);
        }
        for(int element: arr1){
            System.out.print(element+ " ");
        }
        for(int element: arr2){
            System.out.print(element+ " ");
        }
    }

    private void mergeArray(int arr1[], int arr2[]){
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
    public static void main(String args[]){
        int arr1[] = {1,3,5,7};
        int arr2[] = {0,2,6,8,9};

        MergeTowSortedArrays mergeTowSortedArrays = new MergeTowSortedArrays();
        mergeTowSortedArrays.mergeSortedarrayInPlace(arr1,arr2);
        mergeTowSortedArrays.mergeArray(arr1,arr2);
        mergeTowSortedArrays.mergeSortedArrayInPlaceShellSort(arr1, arr2);
    }
}
