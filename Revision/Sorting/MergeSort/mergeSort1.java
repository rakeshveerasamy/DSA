// Time Complexity = o(nLogn)
//Space complexity = O(n)
// Is Stable Sort


class MergeSort{
	private int [] arr;
	
	MergeSort(int [] arr){
		this.arr = arr;
	}
	
	public void sort(){
		if(!isValid()){
			return ;
		}
		
		mergeSort(0, this.arr.length-1);
	}
		
	private boolean isValid(){
		return this.arr!=null && this.arr.length>0;
	}	
	
	private void mergeSort(int left , int right){
		if(left>=right){
			return ;
		}
	
		int mid  =  left + (right-left)/2;
		
		mergeSort(left,mid);
		mergeSort(mid+1, right);
	
		merge(left, mid, right);
	}
	
	private void merge(int left , int mid , int right){
		int n1 = mid - left+1;
		int n2 = right - mid;
	
		int leftArr[] = new int [n1];
		int rightArr[] = new int [n2];
	
		for(int i=0;i<n1;i++){
			leftArr[i] = this.arr[left+i];
		}
		
		for(int j=0;j<n2;j++){
			rightArr[j] = this.arr[mid+j+1];
		}	
	
		int i=0,j=0,k = left;
		
		while(i<n1 && j<n2){
			if(leftArr[i]<=rightArr[j]){
				this.arr[k++] = leftArr[i];
				i++;
			}
			else{
				this.arr[k++] = rightArr[j];
				j++;	
			}
		
		}
	
		while(i<n1){
			this.arr[k++] = leftArr[i++];
		}
		while(j<n2){
			this.arr[k++]  = rightArr[j++];
		}
	}
	
	public  void print(){
		for(int ele: this.arr){
			System.out.print(ele+" ");
		}
	}
}
