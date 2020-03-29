package standartTest_01;


//What will the following program print when compiled and run?
class Game{
    public void play() throws Exception{
        System.out.println("Playing...");
    }
}

public class Q33Soccer extends Game{
    public void play(){
        System.out.println("Playing Soccer...");
    }
    public static void main(String[] args){
        Game g = new Q33Soccer();
//        g.play();
    }
}