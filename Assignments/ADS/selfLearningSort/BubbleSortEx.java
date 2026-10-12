package selfLearningSort;


//Optimized java implementation of Bubble sort

class BubbleSortEx {
 
 // An optimized version of Bubble Sort
 static void bubbleSort(int arr[], int n){
     int i, j, temp;
     boolean swapped;
     for (i = 0; i < n - 1; i++) {
         swapped = false;
         for (j = 0; j < n - i - 1; j++) {
             if (arr[j] > arr[j + 1]) {
                 
                 // Swap arr[j] and arr[j+1]
                 temp = arr[j];
                 arr[j] = arr[j + 1];
                 arr[j + 1] = temp;
                 swapped = true;
             }
         }

         // If no two elements were
         // swapped by inner loop, then break
         if (swapped == false)
             break;
     }
 }

 public static void main(String args[]){
     int arr[] = { 5, 6, 1, 3 };
     int n = arr.length;
     for (int i = 0; i < n; i++)
         System.out.print(arr[i] + " ");
     System.out.println();
     bubbleSort(arr, n);
     for (int i = 0; i < n; i++)
         System.out.print(arr[i] + " ");
 }
}