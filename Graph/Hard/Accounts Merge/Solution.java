class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        AccountMerge am =new AccountMerge(accounts);
        return am.getResult();
    }
}
class DisjointSet {
	private int vertices;
	private List<Integer> parent;
	private List<Integer> size;

	DisjointSet(int vertices) {
		this.vertices = vertices;
		this.parent = new ArrayList<>();
		this.size = new ArrayList<>();
		init();
	}

	private void init() {
		for (int i = 0; i <= this.vertices; i++) {
			this.parent.add(i);
			this.size.add(1);
		}
	}

	public int getUltimateParent(int node) {
		if (this.parent.get(node) == node) {
			return node;
		}

		int par = getUltimateParent(this.parent.get(node));
		this.parent.set(node, par);
		return par;

	}

	public void unionBySize(int u, int v) {
		int uParent = getUltimateParent(u);
		int vParent = getUltimateParent(v);

		if (uParent == vParent)
			return;

		if (this.size.get(uParent) < this.size.get(vParent)) {
			this.parent.set(uParent, vParent);
			this.size.set(vParent, this.size.get(vParent) + this.size.get(uParent));
		} else {
			this.parent.set(vParent, uParent);
			this.size.set(uParent, this.size.get(vParent) + this.size.get(uParent));

		}
	}
}

class AccountMerge {
	private List<List<String>> accounts;
	private List<List<String>> mergedAccounts;

	private int vertices;

	AccountMerge(List<List<String>> accounts) {
		this.accounts = accounts;
		this.mergedAccounts = new ArrayList<>();

		if (isValid()) {
			this.vertices = accounts.size();
			mergeAccounts();
		}

	}

	private boolean isValid() {
		return this.accounts != null && this.accounts.size() != 0;
	}

	private void mergeAccounts() {
		Map<String, Integer> mappedAccounts = new HashMap<>();
		DisjointSet set = new DisjointSet(this.vertices);

		for (int i = 0; i < this.vertices; i++) {
			for (int j = 1; j < this.accounts.get(i).size(); j++) {
				String email = this.accounts.get(i).get(j);

				if (mappedAccounts.containsKey(email)) {
					set.unionBySize(mappedAccounts.get(email), i);
				} else {
					mappedAccounts.put(this.accounts.get(i).get(j), i);
				}
			}
		}

		ArrayList<String>[] mergedMails = new ArrayList[this.vertices];
		for (int i = 0; i < this.vertices; i++) {
			mergedMails[i] = new ArrayList<>();
		}
		for (Map.Entry<String, Integer> entry : mappedAccounts.entrySet()) {
			int ultimateParent = set.getUltimateParent(entry.getValue());

			mergedMails[ultimateParent].add(entry.getKey());
		}

		for (int i = 0; i < this.vertices; i++) {
			if (mergedMails[i].size() == 0)
				continue;
            
            Collections.sort(mergedMails[i]);
            List<String> temp =new ArrayList<>();
			temp.add(this.accounts.get(i).get(0));

			for (String email : mergedMails[i]) {
				temp.add(email);
			}
            this.mergedAccounts.add(temp);
		}

	}

	public List<List<String>> getResult() {
		return this.mergedAccounts;
	}
}
