//$Id$
package practice.test.pkg;

import java.util.*;
import java.util.regex.*;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class Test {
	public static void main(String[] args) {
		String [] word1 = {"great"};
		String word2 [] = {"great"};
		
		String [][] pair = {{}};
		SentenceSimilarity ss = new SentenceSimilarity(word1,word2,pair);
		System.out.println(ss.getResult());	
		
	}

}
/*
 * form disjoint union for pairs;
 * iterate over two arr find ultimate parent are equal
 */


class DisjointSet{
	
	private int vertices;
	private List<Integer> parent;
	private List<Integer> size;
		
	DisjointSet(int vertices){
		this.vertices = vertices;
		this.parent = new ArrayList<>();
		this.size = new ArrayList<>();
		init();
	}
	
	private void init() {
		for(int i=0;i<this.vertices;i++) {
			this.parent.add(i);
			this.size.add(1);
		}
	}
	
	public int findUltimateParent(int node) {
			if(this.parent.get(node) == node) {
				return node;
			}
			int par = findUltimateParent(this.parent.get(node));
			this.parent.set(node, par);
			return par;
	}
	
	public void unionBySize(int u, int v) {
			int  uParent = findUltimateParent(u);
			int vParent = findUltimateParent(v);
			
			if(uParent == vParent) return;
				
			if(this.size.get(uParent)<this.size.get(vParent))
			{
				this.parent.set(uParent, vParent);
				this.size.set(vParent, this.size.get(uParent)+this.size.get(vParent));
			}
			else {
				this.parent.set(vParent, uParent);
				this.size.set(uParent, this.size.get(uParent)+this.size.get(vParent));
			}
	}
}


class SentenceSimilarity{
	private String [] word1;
	private String [] word2;
	private String [][] pairs;
	private boolean isSimilar;
	
	SentenceSimilarity(String [] word1,String [] word2,String [][] pairs){
		this.word1 = word1;
		this.word2 = word2;
		this.pairs= pairs;
		this.isSimilar = false;
		
		if(isValid()) {
			isSimilar();
		}
	}
	
	private boolean isValid() {
			return this.word1!=null & this.word2!=null 
					&& this.word1.length!=0 && this.word2.length!=0 
					&& this.word1.length == this.word2.length
					&& this.pairs!=null ;
	}
	
	private void isSimilar() {
		int vertices = this.pairs.length;
		DisjointSet  set=  new DisjointSet(vertices);
		
		Map<String , Integer> mappedWord = new HashMap<>();
		
		for(int i=0;i<vertices;i++) {
			for(int j = 0;j<this.pairs[i].length;j++) {
				
				String word =  this.pairs[i][j];
				
				if(mappedWord.containsKey(word)) {
					set.unionBySize(mappedWord.get(word), i);
				}
				else {
					mappedWord.put(word,i);
				}
				
			}
		}
		int size = mappedWord.size();
		for(int i=0;i<this.word1.length;i++) {
			String first = this.word1[i];
			String second = this.word2[i];
			
			if(size == 0 && !first.equals(second)) {
				return;
			}
			else if(size> 0 && set.findUltimateParent(mappedWord.get(first)) !=  set.findUltimateParent(mappedWord.get(second))) {
				return;
			}
		}
		
		this.isSimilar = true;
	}
	
	
	public boolean getResult() {
		return this.isSimilar;
	}
}
