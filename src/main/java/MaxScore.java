class MaxScore {
    
	// Merges two subarrays of arr[].
	// First subarray is arr[l..m]
	// Second subarray is arr[m+1..r]
	static void merge(int arr[], int l, int m, int r)
	{
		// Find sizes of two subarrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;

		/* Create temp arrays */
		int L[] = new int[n1];
		int R[] = new int[n2];

		/*Copy data to temp arrays*/
		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarry array
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			}
			else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	// Main function that sorts arr[l..r] using
	// merge()
	static void sort(int arr[], int l, int r)
	{
		if (l < r) {
			// Find the middle point
			int m = (l + r) / 2;

			// Sort first and second halves
			sort(arr, l, m);
			sort(arr, m + 1, r);

			// Merge the sorted halves
			merge(arr, l, m, r);
		}
	}

	static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
	
	// Driver method
 	public static void main(String args[])
 	{
 		int arr[] = { 100,200 };
 		int P = 150;

 		System.out.println("Given Array");
 		printArray(arr);

 		sort(arr, 0, arr.length - 1);

 		System.out.println("\nSorted array");
 		printArray(arr);
 		
 		System.out.println("\n Bag of tokens score:");
 		System.out.println(bagOfTokensScore(arr, P));
 		
 	}

   public  static int bagOfTokensScore(int[] tokens, int P) {

       
       sort(tokens, 0, tokens.length-1);
       int score = 0, pwrPtr = (tokens.length);
       
       for(int i = 0; i < pwrPtr;){
           
           if(tokens[i] <= P){
              score++;
              P -= tokens[i]; 
              i++;
           } else if (score > 0 && i+1 < pwrPtr){
               --pwrPtr;
               --score;
               P += tokens[pwrPtr];
           } else {
        	   i++;
           }
           
       }
       return score;
       
   
   }
}