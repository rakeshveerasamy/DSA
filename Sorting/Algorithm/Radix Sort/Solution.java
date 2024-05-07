class RadixSort {
	private int[] arr;

	RadixSort(int[] arr) {
		this.arr = arr;
		sort();
	}

	private void sort() {
		int max = Arrays.stream(this.arr).max().getAsInt();
		for (int exp = 1; max / exp > 0; exp *= 10) {
			countSort(exp);
		}
	}

	private void countSort(int exp) {
		int[] output = new int[this.arr.length];
		int count[] = new int[10];
		Arrays.fill(count, 0);

		for (int i = 0; i < this.arr.length; i++) {
			count[(arr[i] / exp) % 10]++;
		}
		for (int i = 1; i < 10; i++) {
			count[i] += count[i - 1];
		}
		for (int i = this.arr.length - 1; i >= 0; i--) {
			output[count[(arr[i] / exp) % 10] - 1] = this.arr[i];
			count[(arr[i] / exp) % 10]--;
		}
		System.arraycopy(output, 0, arr, 0, arr.length);
	}

}
