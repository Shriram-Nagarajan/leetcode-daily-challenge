
public class ReducingDishes {
	
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

    public static int maxSatisfaction(int[] satisfaction) {
        
    	int sum = 0, len = satisfaction.length;
    	sort(satisfaction,0,len-1);
    	
    	int psIdx = -1, pSum = 0;
    	
    	for(int i = len-1; i >= 0; i--) {
    		
    		if(satisfaction[i] >= 0) {
    			psIdx = i;
    			pSum += satisfaction[i];
    		} else {
    			break;
    		}
    		
    	}
    	
    	if(pSum > 0 && psIdx > -1) {
    		
			int nPtr = psIdx-1, cumPSum = 0, cumNSum = 0, prevNSum = 0;
			
			for(int i = psIdx; i < len;i++) {
				cumPSum += ((i+1-psIdx) * satisfaction[i]);
			}
			
			//Initialise sum with sum from positive values
			if(cumPSum > sum) {
				sum = cumPSum;
			} 
			
			while(nPtr >= 0) {
				
				cumNSum = (cumNSum) +satisfaction[nPtr];
				prevNSum += cumNSum;
				cumPSum += (pSum);
				
				if(cumPSum+prevNSum > sum)
					sum = cumPSum+prevNSum;
				
				nPtr--;
				
			}
    		
    		return sum;
    		
    	} else {
    		return pSum;
    	}
    	
    	
    }
	
    
    public static void main(String args[]) {
    	
    	int satisfaction[] = {-2,5,-1,0,3,-3};
    	System.out.println(maxSatisfaction(satisfaction));
    }
	
}
