class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        GroupAnagram ga = new GroupAnagram(strs);
        return ga.getGroupedAnagram();
    }
}
class GroupAnagram {
	private String[] str;
	private int size;

	GroupAnagram(String[] str) {
		this.str = str;
		this.size = str.length;
	}

	public List<List<String>> getGroupedAnagram() {
		Map<String, List<String>> result = new HashMap<>();
		for (String s : this.str) {
			char[] charArr = s.toCharArray();
			Arrays.sort(charArr);
			String sortedArr = new String(charArr);

			List<String> anagram = result.getOrDefault(sortedArr, new ArrayList<>());
			anagram.add(s);
			result.put(sortedArr, anagram);
		}
		return new ArrayList<>(result.values());
	}
}
