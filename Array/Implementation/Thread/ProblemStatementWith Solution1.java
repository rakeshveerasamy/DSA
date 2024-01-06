/******************************************************************************

 Implement a multi-threaded program in Java that prints odd and even numbers alternatively. Each number should be printed by a separate thread.


 *******************************************************************************/
import java.util.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        SharedResources sharedResources  =  new SharedResources();
        Thread oddNumberGenerator = new OddNumberGenerator(sharedResources);
        Thread evenNumberGenerator = new EvenNumberGenerator(sharedResources);

        oddNumberGenerator.start();
        evenNumberGenerator.start();
    }

}
class SharedResources{
    private int currentNumber = 1;
    public  void setCurrentNumber(int number){
        this.currentNumber = number;
    }
    public int getCurrentNumber(){
        return this.currentNumber;
    }
}
class OddNumberGenerator extends Thread{
    private  final  SharedResources sharedResources;
    OddNumberGenerator(SharedResources sharedResources){
        this.sharedResources =  sharedResources;
    }
    public void run(){
        while(true){
            synchronized (sharedResources){
                while((sharedResources.getCurrentNumber()%2)==0){
                    try {
                        sharedResources.wait();
                    }catch(Exception exx){
                        exx.printStackTrace();
                    }
                }
                System.out.println(sharedResources.getCurrentNumber()+" ----> Odd Printer");
                sharedResources.setCurrentNumber(sharedResources.getCurrentNumber()+1);
                sharedResources.notify();
            }
        }
    }
}

class EvenNumberGenerator extends Thread{
    private  final  SharedResources sharedResources;
    EvenNumberGenerator(SharedResources sharedResources){
        this.sharedResources =  sharedResources;
    }
    public void run(){
        while(true){
            synchronized (sharedResources){
                while((sharedResources.getCurrentNumber()%2)==1){
                    try {
                        sharedResources.wait();
                    }catch(Exception exx){
                        exx.printStackTrace();
                    }
                }
                System.out.println(sharedResources.getCurrentNumber()+" ----> Even Printer");
                sharedResources.setCurrentNumber(sharedResources.getCurrentNumber()+1);
                sharedResources.notify();
            }
        }
    }
}


