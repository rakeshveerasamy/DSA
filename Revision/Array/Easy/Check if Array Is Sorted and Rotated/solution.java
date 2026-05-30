class SortedRotated{
    private int [] arr;

    SortedRotated(int[] arr){
        this.arr = arr;
    }

    public boolean check(){
        if(!isValid()){
            return false;
        }

        int  count = 0;

        for(int i=0;i<this.arr.length;i++){
            if(this.arr[i]>this.arr[(i+1)%this.arr.length]){
                count++;
            }

            if(count>1){
                return false;
            }

        }

        return true;
    }

    private boolean isValid(){
        return this.arr!=null && this.arr.length>0;
    }


}
