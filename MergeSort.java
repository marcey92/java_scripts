import java.util.Arrays;

class MergeSort{

	public static void main(String[] args){
		//Sort this array
		int[] arr = {5,10,12,15,4,19,27,5,8,2,43,21,65,87,29};
		arr = mergesort2(arr);
		printArr(arr);
	}

	public static int[] mergesort(int[] arr){
		if (arr.length > 1){
			//devide into two arrays
			int splitPoint = (arr.length-1) / 2; //will round down on halves
			int[] arr1 = Arrays.copyOfRange(arr, 0, splitPoint+1);
			int[] arr2 = Arrays.copyOfRange(arr, splitPoint+1, arr.length);	

			arr1 = mergesort(arr1);
			arr2 = mergesort(arr2);

			//merge arrays
			int arr1pos = 0;
			int arr2pos = 0;
			for (int i=0; i<arr.length; i++){
				if (arr1pos == arr1.length | arr2pos == arr2.length){
					if(arr1pos == arr1.length){
						//arr1 is 'empty'
						arr[i] = arr2[arr2pos];
						arr2pos++;
					}
					else{
						//arr2 is 'empty'
						arr[i] = arr1[arr1pos];
						arr1pos++;
					}
				}
				else{
					if (arr1[arr1pos] < arr2[arr2pos]){
						arr[i] = arr1[arr1pos];
						arr1pos++;
					}
					else{
						arr[i] = arr2[arr2pos];
						arr2pos++;
					}
				}

			}
		}
		return arr;	

	}

	public static int[] mergesort2(int[] arr){
		if (arr.length > 1){
			//devide into two arrays
			int splitPoint = (arr.length-1) / 2; //will round down on halves
			int[] arr1 = Arrays.copyOfRange(arr, 0, splitPoint+1);
			int[] arr2 = Arrays.copyOfRange(arr, splitPoint+1, arr.length);	

			arr1 = mergesort(arr1);
			arr2 = mergesort(arr2);

			int i, j, k;
			i = j = k = 0;

			while(i < arr1.length && j < arr2.length){
				if (arr1[i] < arr2[j]){
					arr[k] = arr1[i];
					i++;
				}
				else{
					arr[k] = arr2[j];
					j++;
				}	
				k++;
			}
			for (;i<arr1.length; i++){
				arr[k] = arr1[i];
				i++;
				k++;
			}
			for (;j<arr2.length; j++){
				arr[k] = arr2[j];
				j++;
				k++;
			}
		}
		return arr;
	}

	public static void printArr(int[] arr){
		for(int i=0; i<arr.length; i++){
			System.out.print(" " + arr[i]);
		}	
		System.out.println("");
	}
}	