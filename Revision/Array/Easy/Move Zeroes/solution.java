class MoveZeros{
    private int [] arr;

    MoveZeros(int [] arr){
        this.arr = arr;
    }

    public void move(){
        if(!isValid()){
            return;
        }

        int nonZeroIndex = 0;

        for(int i=0;i<this.arr.length;i++){
            if(this.arr[i]!=0)
            {
                this.arr[nonZeroIndex++] = this.arr[i];
            }
                 
        }

        for(;nonZeroIndex<this.arr.length;nonZeroIndex++){
            this.arr[nonZeroIndex] = 0;
        }
    }

    private boolean isValid(){
        return this.arr!=null && this.arr.length>0;
    }

    public int[] getResult(){
        return this.arr;
    }
}
