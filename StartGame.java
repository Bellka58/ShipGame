import java.util.Scanner;

class ChoiceOfArea {
    int AreaSize = 5;
    int shipLength = 3;

    void yourChoice() {
        Scanner in = new Scanner(System.in);
        System.out.println ("You should chose area");
        AreaSize = in.nextInt();
        System.out.println ("You should chose length of SHIP");
        shipLength = in.nextInt();
    }
}

class OutWindow {
    String[] StrToWin;

    void makeStr (int sizeOfStr) {
        StrToWin = new String[sizeOfStr];
        for(int k = 0; k < sizeOfStr; k++) {
            StrToWin[k] = "[ ]";
            System.out.print (StrToWin[k]);
        }
    }

    void outStr (int sizeOfStr,boolean rigthAn, int numOfWinCell) {
        if (rigthAn) {
            StrToWin[numOfWinCell] = "[x]";
        }
        else {
            StrToWin[numOfWinCell] = "[o]";
        }
        for(int k = 0; k < sizeOfStr; k++) {
            System.out.print (StrToWin[k]);
        }
        System.out.println();
        for(int k = 0; k < sizeOfStr; k++) {
            if (k < 9) {
                 System.out.print("|"+(k+1)+"|");
            }
            else {
                System.out.print((k+1)+"|");
            }
        }
    }
}

class CompGame {
    ChoiceOfArea NewArea = new ChoiceOfArea();
    int [] cellsNum;
    int numOfHits = 0;
    int AreaS;
    int ShipL;

    void makeMap() {
        NewArea.yourChoice();
        cellsNum = new int[NewArea.AreaSize];
        AreaS = NewArea.AreaSize;
        ShipL = NewArea.shipLength;
        int needShipLegth = NewArea.shipLength - 1;
        int FirstNum = (int) (Math.round(Math.random()* (NewArea.AreaSize-NewArea.shipLength)));

        for(int i = FirstNum; i < (FirstNum + NewArea.shipLength); i++) {
            cellsNum[i] = 1;
        }

    }
}

class PlayerGame {
    int numcell = 0;
    void readFromPlayer () {
        Scanner in = new Scanner(System.in);
        System.out.println("\nWhat do you think? where is it?");
        numcell = in.nextInt() - 1;
    }
}

class CompareGame {

    boolean poapalilinet (int firstarg) {
        if (firstarg == 1) {
            System.out.println( "You are right");
            return true;
        }
        if (firstarg == 0) {
            System.out.println("You are wrong");
            return false;
        }  
        else {
            return false;
        }
    }
    boolean poapalilinetboo (int firstarg) {
        if (firstarg == 1) {
            return true;
        }
        else {
            return false;
        }
    }
}

class StartGamePre {
    void starting(){
        OutWindow newWin = new OutWindow();
        CompGame newGame = new CompGame();
        PlayerGame Vibor = new PlayerGame();
        CompareGame TryGame = new CompareGame();
        int countOfTrue = 0;
        int countOfEverything = 0;
        newGame.makeMap();
        newWin.makeStr(newGame.AreaS);
        while (countOfTrue < newGame.ShipL){
            countOfEverything = countOfEverything + 1;
            Vibor.readFromPlayer();
            newWin.outStr(newGame.AreaS,TryGame.poapalilinet(newGame.cellsNum[Vibor.numcell]),Vibor.numcell);
            if (TryGame.poapalilinetboo(newGame.cellsNum[Vibor.numcell])) {
                countOfTrue = countOfTrue + 1;
            }
            if (countOfTrue == newGame.ShipL) {
                System.out.println("\nYOU WON!\nCONGRATULATIONS!\nYou did for " + countOfEverything + " steps");
            }
        }
    }
}

public class StartGame {
    public static void main (String[] args) {
        StartGamePre newOurGame = new StartGamePre();
        newOurGame.starting();
    }
}