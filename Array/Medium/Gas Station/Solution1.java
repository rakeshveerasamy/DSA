//TIme complexity - O(n)
//Sace Complexity - O(n)



class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int currentGas = 0;
        int startingPoint = 0;
        for(int i= 0;i<gas.length;i++){
            totalGas+=gas[i] - cost[i];
            currentGas+=gas[i]-cost[i];

            if(currentGas<0){
                startingPoint = i+1;
                currentGas = 0;
            }
        }
        System.out.println(totalGas);
        return (totalGas>=0)?startingPoint:-1;

    }
}
