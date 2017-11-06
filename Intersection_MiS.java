/*
@mseskar
@11/1/17
Create a system to simulate vehicles at an intersection.
Assume that there is one lane going in each of four directions, with stoplights facing each direction.
Vary the arrival average of vehicles in each direction and the frequency of the light changes to view the "behavior" of the intersection.
*/
import java.util.Random;
public class Intersection_MiS{
    private static Queue lane1 = new Queue();//pairs with 3
    private static Queue lane2 = new Queue();//pairs with 4
    private static Queue lane3 = new Queue();//pairs with 1
    private static Queue lane4 = new Queue();//pairs with 2
    private static Queue lanes[] = new Queue[]{lane1, lane2, lane3, lane4};
    public static void main(String [] args){
        while(true){
            System.out.print(traffic());
        }
    }
    public static String traffic(){
        Random r = new Random();
        int amount = r.nextInt(20);//how "long" the light will be green
        for(int i = 0; i < amount; i++){//10 times every round, adds up to 4 cars to a random lane
            int lane = r.nextInt(4);
            for(int j = 0; j < 3; j++){ //adds up to 4 cars at a time
            lanes[lane].enqueue("car");
            }
            }

        int i = (int)Math.random()*5;
        int rand = (int) (Math.random() * (50-10)+10);//random number to see which lane goes
        while(i<5){//how "long" the light is green
            if(!lanes[0].isEmpty()) lanes[0].dequeue();
            if(!lanes[1].isEmpty()) lanes[1].dequeue();
            if(!lanes[2].isEmpty()) lanes[2].dequeue();
            if(!lanes[3].isEmpty()) lanes[3].dequeue();
            i++;
            }
            String result = "\nLane 1: " + lanes[0].size() + "\nLane 2: " + lanes[1].size() + "\nLane 3: " + lanes[2].size() + "\nLane 4: " + lanes[3].size();//print out all values of the lanes to see behaviour
            return result;
        }
    }
//Output
/*
Milos@Milos-PC MINGW64 ~/Documents/+PHS/Algo (master)
$ java Intersection_MiS

Lane 1: 0
Lane 2: 0
Lane 3: 0
Lane 4: 0
Lane 1: 13
Lane 2: 1
Lane 3: 0
Lane 4: 4
Lane 1: 17
Lane 2: 0
Lane 3: 0
Lane 4: 2
Lane 1: 24
Lane 2: 7
Lane 3: 4
Lane 4: 0
Lane 1: 40
Lane 2: 5
Lane 3: 0
Lane 4: 10
Lane 1: 50
Lane 2: 6
Lane 3: 7
Lane 4: 11
Lane 1: 57
Lane 2: 4
Lane 3: 20
Lane 4: 21
Lane 1: 64
Lane 2: 23
Lane 3: 18
Lane 4: 31

*/
