package poker;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
public class PokerAutomatedTest {
    ArrayList<Player> players= new ArrayList<Player>();
    int numplayers=0;
    //Automated testing
    //This function is called to run nonrainbow tests for all possible nonrainbow hands ( Assuming 3 suits )
    public void nonRainbowHelper(String[] args, String[] suits){
        //String[] suits = {"c", "h", "d"};
        int z=0;
        //Hand generation
        for (int i=2;i<=14;i++){
            args[0]=(i%13) + suits[z];
            args[1]=((i+1)%13) + suits[z+1];
            args[2]=((i+2)%13) + suits[z+2];
            args[3]=((i+3)%13) + suits[z];
            args[4]=((i+4)%13) + suits[z+1];
            args[5]=((i+5)%13) + suits[z+2];
            args[6]=((i+6)%13) + suits[z];
            args[7]=((i+7)%13) + suits[z+1];
            args[8]=((i+8)%13) + suits[z+2];
            args[9]=((i+9)%13) + suits[z];
            //Checking for tens, convert to value ten (t)
            for (int j=0; j<10;j++) {
                if (args[j].substring(0,2).equals("10")) {
                    String newCard = args[j].substring(2);
                    args[j] = "t" + newCard;
                }
            }

            //Checking for 11, convert to value Jack (j)
            for (int j=0; j<10;j++) {
                if (args[j].substring(0,2).equals("11")) {
                    String newCard = args[j].substring(2);
                    args[j] = "j" + newCard;
                }
            }
            //Checking for 12, convert to value Queen (q)
            for (int j=0; j<10;j++) {
                if (args[j].substring(0,2).equals("12")) {
                    String newCard = args[j].substring(2);
                    args[j] = "q" + newCard;
                }
            }
            //Checking for 0, convert to value King (k)
            for (int j=0; j<10;j++) {
                if (args[j].substring(0,1).equals("0")) {
                    String newCard = args[j].substring(1);
                    args[j] = "k" + newCard;
                }
            }
            //Checking for ones, convert to value ace (a)
            for(int j = 0; j<10 ; j++){
                if (args[j].substring(0,1).equals("1")){
                    String newCard=args[j].substring(1);
                    args[j]="a"+ newCard;
                }
            }
            //end hand generation, Test generated hand now
            players = Poker.setCards(args,players,numplayers);
            numplayers=players.size();
            Poker.rank(numplayers,players);
            System.out.println("This is iteration " + i + " and it is " + String.valueOf(players.get(0).getrank()));
            for (int k=0 ; k < 10 ; k++){
                System.out.println(args[k]);
            }
            Assert.assertEquals(players.get(0).getrank(),1);
        }
    }
    //Automated testing
    //This helper will work for any hands that use 4 suits
    public int[] fourSuitHelper(String[] args, String[] suits){
        //String[] suits = {"c", "h", "d","s"};
        int z=0;
        int [] solution = new int[13];
        //Hand generation
        if (suits.length == 4){
            for (int i=2;i<=14;i++){
                args[0]=(i%13) + suits[z];
                args[1]=((i+1)%13) + suits[z+1];
                args[2]=((i+2)%13) + suits[z+2];
                args[3]=((i+3)%13) + suits[z+3];
                args[4]=((i+4)%13) + suits[z];
                args[5]=((i+5)%13) + suits[z+1];
                args[6]=((i+6)%13) + suits[z+2];
                args[7]=((i+7)%13) + suits[z+3];
                args[8]=((i+8)%13) + suits[z];
                args[9]=((i+9)%13) + suits[z+1];
                //Checking for tens, convert to value ten (t)
                for (int j=0; j<10;j++) {
                    if (args[j].substring(0,2).equals("10")) {
                        String newCard = args[j].substring(2);
                        args[j] = "t" + newCard;
                    }
                }
                //Checking for 11, convert to value jack (j)
                for (int j=0; j<10;j++) {
                    if (args[j].substring(0,2).equals("11")) {
                        String newCard = args[j].substring(2);
                        args[j] = "j" + newCard;
                    }
                }
                //Checking for 12, convert to value queen (q)
                for (int j=0; j<10;j++) {
                    if (args[j].substring(0,2).equals("12")) {
                        String newCard = args[j].substring(2);
                        args[j] = "q" + newCard;
                    }
                }
                //Checking for 0, convert to value king (k)
                for (int j=0; j<10;j++) {
                    if (args[j].substring(0,1).equals("0")) {
                        String newCard = args[j].substring(1);
                        args[j] = "k" + newCard;
                    }
                    //Checking for ones, convert to value ace (2)
                    if (args[j].substring(0,1).equals("1")){
                        String newCard=args[j].substring(1);
                        args[j]="a"+ newCard;
                    }
                }
                //end hand generation, Test generated hand now
                players = Poker.setCards(args,players,numplayers);
                numplayers=players.size();
                Poker.rank(numplayers,players);
                System.out.println("This is iteration " + i + " and it is " + players.get(0).getrank());
                solution[i-2]= players.get(0).getrank();
            }
        }
        //For flush test
        else {
            for (int i = 2; i <= 14; i++) {
                args[0] = (i % 13) + suits[z];
                args[1] = ((i + 1) % 13) + suits[z + 1];
                args[2] = ((i + 2) % 13) + suits[z];
                args[3] = ((i + 3) % 13) + suits[z + 1];
                args[4] = ((i + 4) % 13) + suits[z];
                args[5] = ((i + 5) % 13) + suits[z + 1];
                args[6] = ((i + 6) % 13) + suits[z];
                args[7] = ((i + 7) % 13) + suits[z + 1];
                args[8] = ((i + 8) % 13) + suits[z];
                args[9] = ((i + 9) % 13) + suits[z + 1];
                //Checking for tens, convert to value ten (t)
                for (int j = 0; j < 10; j++) {
                    if (args[j].substring(0, 2).equals("10")) {
                        String newCard = args[j].substring(2);
                        args[j] = "t" + newCard;
                    }
                }
                //Checking for 11, convert to value jack (j)
                for (int j = 0; j < 10; j++) {
                    if (args[j].substring(0, 2).equals("11")) {
                        String newCard = args[j].substring(2);
                        args[j] = "j" + newCard;
                    }
                }
                //Checking for 12, convert to value queen (q)
                for (int j = 0; j < 10; j++) {
                    if (args[j].substring(0, 2).equals("12")) {
                        String newCard = args[j].substring(2);
                        args[j] = "q" + newCard;
                    }
                }
                //Checking for 0, convert to value king (k)
                for (int j = 0; j < 10; j++) {
                    if (args[j].substring(0, 1).equals("0")) {
                        String newCard = args[j].substring(1);
                        args[j] = "k" + newCard;
                    }
                    //Checking for ones, convert to value ace (2)
                    if (args[j].substring(0, 1).equals("1")) {
                        String newCard = args[j].substring(1);
                        args[j] = "2" + newCard;
                    }
                }
                //end hand generation, Test generated hand now
                players = Poker.setCards(args, players, numplayers);
                numplayers = players.size();
                Poker.rank(numplayers, players);
                System.out.println("This is iteration " + i + " and it is " + players.get(0).getrank());
                solution[i - 2] = players.get(0).getrank();
            }
        }
        return solution;
    }
    public int [] monoHelper(String [] args, String [] suits){
        int z=0;
        int [] solution = new int[13];
        for (int i = 2; i <= 14; i++) {
            args[0] = (i % 13) + suits[z];
            args[1] = ((i + 1) % 13) + suits[z + 2];
            args[2] = ((i + 2) % 13) + suits[z];
            args[3] = ((i + 3) % 13) + suits[z + 3];
            args[4] = ((i + 4) % 13) + suits[z + 3];
            args[5] = ((i + 5) % 13) + suits[z + 1];
            args[6] = ((i + 6) % 13) + suits[z];
            args[7] = ((i + 7) % 13) + suits[z + 2];
            args[8] = ((i + 8) % 13) + suits[z];
            args[9] = ((i + 9) % 13) + suits[z + 1];
            //Checking for tens, convert to value ten (t)
            for (int j = 0; j < 10; j++) {
                if (args[j].substring(0, 2).equals("10")) {
                    String newCard = args[j].substring(2);
                    args[j] = "t" + newCard;
                }
            }
            //Checking for 11, convert to value jack (j)
            for (int j = 0; j < 10; j++) {
                if (args[j].substring(0, 2).equals("11")) {
                    String newCard = args[j].substring(2);
                    args[j] = "j" + newCard;
                }
            }
            //Checking for 12, convert to value queen (q)
            for (int j = 0; j < 10; j++) {
                if (args[j].substring(0, 2).equals("12")) {
                    String newCard = args[j].substring(2);
                    args[j] = "q" + newCard;
                }
            }
            //Checking for 0, convert to value king (k)
            for (int j = 0; j < 10; j++) {
                if (args[j].substring(0, 1).equals("0")) {
                    String newCard = args[j].substring(1);
                    args[j] = "k" + newCard;
                }
                //Checking for ones, convert to value ace (2)
                if (args[j].substring(0, 1).equals("1")) {
                    String newCard = args[j].substring(1);
                    args[j] = "2" + newCard;
                }
            }
            //end hand generation, Test generated hand now
            players = Poker.setCards(args, players, numplayers);
            numplayers = players.size();
            Poker.rank(numplayers, players);
            System.out.println("This is iteration " + i + " and it is " + players.get(0).getrank());
            solution[i - 2] = players.get(0).getrank();
        }
        return solution;
    }
    public int [] OddHelper(String [] args, String [] suits){
        int z=0;
        int [] solution = new int[13];
        for (int i = 2; i <= 14; i++) {
            args[0] = (i % 13) + suits[z];
            args[1] = ((i) % 13) + suits[z + 1];
            args[2] = ((i + 5) % 13) + suits[z+2];
            args[3] = ((i + 2) % 13) + suits[z + 3];
            args[4] = ((i + 3) % 13) + suits[z + 3];
            args[5] = ((i + 4) % 13) + suits[z + 1];
            args[6] = ((i + 5) % 13) + suits[z];
            args[7] = ((i + 3) % 13) + suits[z + 2];
            args[8] = ((i + 7) % 13) + suits[z];
            args[9] = ((i + 7) % 13) + suits[z + 1];
            //Checking for tens, convert to value ten (t)
            for (int j = 0; j < 10; j++) {
                if (args[j].substring(0, 2).equals("10")) {
                    String newCard = args[j].substring(2);
                    args[j] = "t" + newCard;
                }
            }
            //Checking for 11, convert to value jack (j)
            for (int j = 0; j < 10; j++) {
                if (args[j].substring(0, 2).equals("11")) {
                    String newCard = args[j].substring(2);
                    args[j] = "j" + newCard;
                }
            }
            //Checking for 12, convert to value queen (q)
            for (int j = 0; j < 10; j++) {
                if (args[j].substring(0, 2).equals("12")) {
                    String newCard = args[j].substring(2);
                    args[j] = "q" + newCard;
                }
            }
            //Checking for 0, convert to value king (k)
            for (int j = 0; j < 10; j++) {
                if (args[j].substring(0, 1).equals("0")) {
                    String newCard = args[j].substring(1);
                    args[j] = "k" + newCard;
                }
                //Checking for ones, convert to value ace (2)
                if (args[j].substring(0, 1).equals("1")) {
                    String newCard = args[j].substring(1);
                    args[j] = "2" + newCard;
                }
            }
            //end hand generation, Test generated hand now
            players = Poker.setCards(args, players, numplayers);
            numplayers = players.size();
            Poker.rank(numplayers, players);
            System.out.println("This is iteration " + i + " and it is " + players.get(0).getrank());
            solution[i - 2] = players.get(0).getrank();
        }
        return solution;
    }
    public int [] EvenHelper(String [] args, String [] suits){
        int z=0;
        int [] solution = new int[13];
        for (int i = 2; i <= 14; i++) {
            args[0] = (i % 13) + suits[z];
            args[1] = ((i) % 13) + suits[z + 1];
            args[2] = ((i + 3) % 13) + suits[z];
            args[3] = ((i + 2) % 13) + suits[z + 3];
            args[4] = ((i + 3) % 13) + suits[z + 3];
            args[5] = ((i + 4) % 13) + suits[z + 1];
            args[6] = ((i + 5) % 13) + suits[z];
            args[7] = ((i + 3) % 13) + suits[z + 2];
            args[8] = ((i + 6) % 13) + suits[z];
            args[9] = ((i + 6) % 13) + suits[z + 1];
            //Checking for tens, convert to value ten (t)
            for (int j = 0; j < 10; j++) {
                if (args[j].substring(0, 2).equals("10")) {
                    String newCard = args[j].substring(2);
                    args[j] = "t" + newCard;
                }
            }
            //Checking for 11, convert to value jack (j)
            for (int j = 0; j < 10; j++) {
                if (args[j].substring(0, 2).equals("11")) {
                    String newCard = args[j].substring(2);
                    args[j] = "j" + newCard;
                }
            }
            //Checking for 12, convert to value queen (q)
            for (int j = 0; j < 10; j++) {
                if (args[j].substring(0, 2).equals("12")) {
                    String newCard = args[j].substring(2);
                    args[j] = "q" + newCard;
                }
            }
            //Checking for 0, convert to value king (k)
            for (int j = 0; j < 10; j++) {
                if (args[j].substring(0, 1).equals("0")) {
                    String newCard = args[j].substring(1);
                    args[j] = "k" + newCard;
                }
                //Checking for ones, convert to value ace (2)
                if (args[j].substring(0, 1).equals("1")) {
                    String newCard = args[j].substring(1);
                    args[j] = "2" + newCard;
                }
            }
            //end hand generation, Test generated hand now
            players = Poker.setCards(args, players, numplayers);
            numplayers = players.size();
            Poker.rank(numplayers, players);
            System.out.println("This is iteration " + i + " and it is " + players.get(0).getrank());
            solution[i - 2] = players.get(0).getrank();
        }
        return solution;
    }
    public int [] tripletsHelper(String [] args, String [] suits){
        int z=0;
        int [] solution = new int[13];
        for (int i = 2; i <= 14; i++) {
            args[0]=(i%13) + suits[z];
            args[1]=((i)%13) + suits[z+1];
            args[2]=((i)%13) + suits[z+2];
            args[3]=((i+3)%13) + suits[z+3];
            args[4]=((i+4)%13) + suits[z];
            args[5]=((i+5)%13) + suits[z+1];
            args[6]=((i+6)%13) + suits[z+2];
            args[7]=((i+1)%13) + suits[z+3];
            args[8]=((i+1)%13) + suits[z];
            args[9]=((i+1)%13) + suits[z+1];
            //Checking for tens, convert to value ten (t)
            for (int j = 0; j < 10; j++) {
                if (args[j].substring(0, 2).equals("10")) {
                    String newCard = args[j].substring(2);
                    args[j] = "t" + newCard;
                }
            }
            //Checking for 11, convert to value jack (j)
            for (int j = 0; j < 10; j++) {
                if (args[j].substring(0, 2).equals("11")) {
                    String newCard = args[j].substring(2);
                    args[j] = "j" + newCard;
                }
            }
            //Checking for 12, convert to value queen (q)
            for (int j = 0; j < 10; j++) {
                if (args[j].substring(0, 2).equals("12")) {
                    String newCard = args[j].substring(2);
                    args[j] = "q" + newCard;
                }
            }
            //Checking for 0, convert to value king (k)
            for (int j = 0; j < 10; j++) {
                if (args[j].substring(0, 1).equals("0")) {
                    String newCard = args[j].substring(1);
                    args[j] = "k" + newCard;
                }
                //Checking for ones, convert to value ace (2)
                if (args[j].substring(0, 1).equals("1")) {
                    String newCard = args[j].substring(1);
                    args[j] = "a" + newCard;
                }
            }
            //end hand generation, Test generated hand now
            players = Poker.setCards(args, players, numplayers);
            numplayers = players.size();
            Poker.rank(numplayers, players);
            System.out.println("This is iteration " + i + " and it is " + players.get(0).getrank());
            solution[i - 2] = players.get(0).getrank();
        }
        return solution;
    }
    public int [] OverfullHouseHelper(String [] args, String [] suits){
        int z=0;
        int [] solution = new int[13];
        for (int i = 2; i <= 14; i++) {
            args[0]=(i%13) + suits[z];
            args[1]=((i)%13) + suits[z+1];
            args[2]=((i)%13) + suits[z+2];
            args[3]=((i)%13) + suits[z+3];
            args[4]=((i+4)%13) + suits[z];
            args[5]=((i+5)%13) + suits[z+1];
            args[6]=((i+6)%13) + suits[z+2];
            args[7]=((i+7)%13) + suits[z+3];
            args[8]=((i+7)%13) + suits[z];
            args[9]=((i+9)%13) + suits[z+1];
            //Checking for tens, convert to value ten (t)
            for (int j = 0; j < 10; j++) {
                if (args[j].substring(0, 2).equals("10")) {
                    String newCard = args[j].substring(2);
                    args[j] = "t" + newCard;
                }
            }
            //Checking for 11, convert to value jack (j)
            for (int j = 0; j < 10; j++) {
                if (args[j].substring(0, 2).equals("11")) {
                    String newCard = args[j].substring(2);
                    args[j] = "j" + newCard;
                }
            }
            //Checking for 12, convert to value queen (q)
            for (int j = 0; j < 10; j++) {
                if (args[j].substring(0, 2).equals("12")) {
                    String newCard = args[j].substring(2);
                    args[j] = "q" + newCard;
                }
            }
            //Checking for 0, convert to value king (k)
            for (int j = 0; j < 10; j++) {
                if (args[j].substring(0, 1).equals("0")) {
                    String newCard = args[j].substring(1);
                    args[j] = "k" + newCard;
                }
                //Checking for ones, convert to value ace (2)
                if (args[j].substring(0, 1).equals("1")) {
                    String newCard = args[j].substring(1);
                    args[j] = "a" + newCard;
                }
            }
            //end hand generation, Test generated hand now
            players = Poker.setCards(args, players, numplayers);
            numplayers = players.size();
            Poker.rank(numplayers, players);
            System.out.println("This is iteration " + i + " and it is " + players.get(0).getrank());
            solution[i - 2] = players.get(0).getrank();
        }
        return solution;
    }
    public int [] threePairHelper(String [] args, String [] suits){
        int z=0;
        int [] solution = new int[13];
        for (int i = 2; i <= 14; i++) {
            args[0]=(i%13) + suits[z];
            args[1]=((i)%13) + suits[z+1];
            args[2]=((i+1)%13) + suits[z+2];
            args[3]=((i+1)%13) + suits[z+3];
            args[4]=((i+4)%13) + suits[z];
            args[5]=((i+5)%13) + suits[z+1];
            args[6]=((i+6)%13) + suits[z+2];
            args[7]=((i+7)%13) + suits[z+3];
            args[8]=((i+7)%13) + suits[z];
            args[9]=((i+9)%13) + suits[z+1];
            //Checking for tens, convert to value ten (t)
            for (int j = 0; j < 10; j++) {
                if (args[j].substring(0, 2).equals("10")) {
                    String newCard = args[j].substring(2);
                    args[j] = "t" + newCard;
                }
            }
            //Checking for 11, convert to value jack (j)
            for (int j = 0; j < 10; j++) {
                if (args[j].substring(0, 2).equals("11")) {
                    String newCard = args[j].substring(2);
                    args[j] = "j" + newCard;
                }
            }
            //Checking for 12, convert to value queen (q)
            for (int j = 0; j < 10; j++) {
                if (args[j].substring(0, 2).equals("12")) {
                    String newCard = args[j].substring(2);
                    args[j] = "q" + newCard;
                }
            }
            //Checking for 0, convert to value king (k)
            for (int j = 0; j < 10; j++) {
                if (args[j].substring(0, 1).equals("0")) {
                    String newCard = args[j].substring(1);
                    args[j] = "k" + newCard;
                }
                //Checking for ones, convert to value ace (2)
                if (args[j].substring(0, 1).equals("1")) {
                    String newCard = args[j].substring(1);
                    args[j] = "a" + newCard;
                }
            }
            //end hand generation, Test generated hand now
            players = Poker.setCards(args, players, numplayers);
            numplayers = players.size();
            Poker.rank(numplayers, players);
            System.out.println("This is iteration " + i + " and it is " + players.get(0).getrank());
            solution[i - 2] = players.get(0).getrank();
        }
        return solution;

    }


    @Test
    public void testNonRainbowOnePlayerAutomated(){
        //Omitted one suit
        String[] args= new String[10];
        String[] suits= {"c", "h", "d"};
        nonRainbowHelper(args,suits);
        suits[0]="s";
        nonRainbowHelper(args,suits);
        suits[1]="c";
        nonRainbowHelper(args,suits);
        suits[2]="h";
        nonRainbowHelper(args,suits);
    }

    @Test
    public void testRainbowOnePlayerAutomated(){
        String[] args=new String[10];
        String[] suits = {"c", "h", "d","s"};
        int [] solutions = fourSuitHelper(args,suits);
        for (int i = 0; i<=12; i++){
            Assert.assertEquals(solutions[i],2);
        }
    }
    @Test
    public void testMonochromaticOnePlayerAutomated(){
        String[] args=new String[10];
        String[] suits = {"c", "h", "d","s"};
        int [] solutions = monoHelper(args,suits);
        for (int i = 0; i<=12; i++){
            Assert.assertEquals(solutions[i],4);
        }
    }

    @Test
    public void testFlushRedsAndBlacksAutomated(){
        String[] args=new String[10];
        String[] Blacksuits = {"c","s"};
        String[] Redsuits ={"h", "d"};
        int [] solutions = fourSuitHelper(args, Blacksuits);
        for (int i = 0; i<=12; i++){
            Assert.assertEquals(solutions[i],9);
        }
        solutions =fourSuitHelper(args,Redsuits);
        for (int i = 0; i<=12; i++){
            Assert.assertEquals(solutions[i],9);
        }

    }
    @Test
    public void testOddOnePlayerAutomated(){
        String[] args=new String[10];
        String[] suits = {"c", "h", "d","s"};
        int [] solutions = OddHelper(args,suits);
        for (int i = 0; i<=12; i++){
            Assert.assertEquals(solutions[i],8);
        }
    }

    @Test
    public void testEvenOnePlayerAutomated(){
        String[] args=new String[10];
        String[] suits = {"c", "h", "d","s"};
        int [] solutions = EvenHelper(args,suits);
        for (int i = 0; i<=12; i++){
            Assert.assertEquals(solutions[i],7);
        }
    }
    @Test
    public void testTripletsOnePlayerAutomated(){
        String[] args=new String[10];
        String[] suits = {"c", "h", "d","s"};
        int [] solutions = tripletsHelper(args,suits);
        for (int i = 0; i<=12; i++){
            Assert.assertEquals(solutions[i],10);
        }
    }
    @Test
    public void testOverfullHouseOnePlayerAutomated(){
        String[] args=new String[10];
        String[] suits = {"c", "h", "d","s"};
        int [] solutions = OverfullHouseHelper(args,suits);
        for (int i = 0; i<=12; i++){
            Assert.assertEquals(solutions[i],11);
        }
    }
    /*
    @Test
    public void testThreePairOnePlayerAutomated(){
        String[] args=new String[10];
        String[] suits = {"c", "h", "d","s"};
        int [] solutions = threePairHelper(args,suits);
        for (int i = 0; i<=12; i++){
            Assert.assertEquals(solutions[i],5);
        }
    }
    */
}
