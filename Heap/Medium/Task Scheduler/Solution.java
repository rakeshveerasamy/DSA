class Solution {
    public int leastInterval(char[] tasks, int n) {
        TaskScheduler ts = new TaskScheduler(tasks,n);
        return ts.getResult();
    }
}
class TaskScheduler {
	private char[] arr;
	private int coolingPeriod;
	private int totalTime;

	TaskScheduler(char[] arr, int coolingPeriod) {
		this.arr = arr;
		this.coolingPeriod = coolingPeriod;
		this.totalTime = 0;

		if (isValid()) {
			findTotalTime();
		}
	}

	private boolean isValid() {
		return this.arr != null && this.arr.length != 0;
	}

	private void findTotalTime() {
		Map<Character, Integer> frequencyCounter = new HashMap<>();

		for (char curr : this.arr) {
			frequencyCounter.put(curr, frequencyCounter.getOrDefault(curr, 0) + 1);
		}

		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

		maxHeap.addAll(frequencyCounter.values());
		int time = 0;

		while (!maxHeap.isEmpty()) {
			int coolingTime = this.coolingPeriod + 1;
			List<Integer> temp = new ArrayList<>();

			while (coolingTime > 0 && !maxHeap.isEmpty() ) {
				int frequencyTime = maxHeap.poll();
				if (frequencyTime > 1) {
					temp.add(frequencyTime-1);
				}
				time++;
				coolingTime--;
			}
			maxHeap.addAll(temp);

			if (!maxHeap.isEmpty()) {
				time += coolingTime;
			}
		}
		this.totalTime = time;
	}

	public int getResult() {
		return this.totalTime;
	}
}
