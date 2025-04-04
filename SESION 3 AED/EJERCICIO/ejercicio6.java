public static void mergeSort(int[] arr, int l, int r) {
    if (l < r) {
        int m = l + (r - l) / 2;  					// O(1)
        mergeSort(arr, l, m);  					// O(log n)
        mergeSort(arr, m + 1, r);  				// O(log n)
        merge(arr, l, m, r);  					// O(n)
    }
}

public static void merge(int[] arr, int l, int m, int r) {
    int n1 = m - l + 1;
    int n2 = r - m;
    int[] L = new int[n1];
    int[] R = new int[n2];

    System.arraycopy(arr, l, L, 0, n1); 				// O(n)
    System.arraycopy(arr, m + 1, R, 0, n2);  			// O(n)

    int i = 0, j = 0, k = l;
    while (i < n1 && j < n2) {  					// O(n)
        if (L[i] <= R[j]) {
            arr[k++] = L[i++];
        } else {
            arr[k++] = R[j++];
        }
    }
    while (i < n1) arr[k++] = L[i++];  				// O(n)
    while (j < n2) arr[k++] = R[j++];  				// O(n)
}