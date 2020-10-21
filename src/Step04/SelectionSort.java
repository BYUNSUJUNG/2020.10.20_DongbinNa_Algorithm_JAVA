package Step04;

// 선택 정렬
public class SelectionSort {
	 public static void main(String[] args) {

	        int n = 10;
	        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

            // 반복문이 반복될 수록 가장 작은 값이 맨앞에 정렬된다.
	        for (int i = 0; i < n; i++) {
	            int min_index = i; // 가장 작은 원소의 인덱스 
	            for (int j = i + 1; j < n; j++) {
	                if (arr[min_index] > arr[j]) {
	                    min_index = j;
	                }
	            }
	            int temp = arr[i];
	            arr[i] = arr[min_index];
	            arr[min_index] = temp;
	        }

	        // 출력
	        for(int i = 0; i < n; i++) {
	            System.out.print(arr[i] + " ");
	        }
	    }
}
