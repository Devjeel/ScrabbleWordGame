package Assignment2_200395854;

import java.util.HashMap;
import java.util.Map;

public class InitializerModel {

    public InitializerModel() {
    }

    public static void createBag() {
        Map<Character, Integer> valueBag = new HashMap<Character, Integer>();

        valueBag.put('A', 1);
        valueBag.put('B', 3);
        valueBag.put('C', 3);
        valueBag.put('D', 2);
        valueBag.put('E', 1);
        valueBag.put('F', 4);
        valueBag.put('G', 2);
        valueBag.put('H', 4);
        valueBag.put('I', 1);
        valueBag.put('J', 8);
        valueBag.put('K', 5);
        valueBag.put('L', 1);
        valueBag.put('M', 3);
        valueBag.put('N', 1);
        valueBag.put('O', 1);
        valueBag.put('P', 3);
        valueBag.put('Q', 10);
        valueBag.put('R', 1);
        valueBag.put('S', 1);
        valueBag.put('T', 1);
        valueBag.put('U', 1);
        valueBag.put('V', 4);
        valueBag.put('W', 4);
        valueBag.put('X', 8);
        valueBag.put('Y', 4);
        valueBag.put('Z', 10);
    }

    public static int getValueOfLetter(char letter){

        switch (letter){
            case 'g':
            case 'd':
                return 2;

            case 'q':
            case 'z':
                return 10;

            case 'h':
            case 'y':
            case 'w':
            case 'f':
            case 'v':
                return 4;

            case 'x':
            case 'j':
                return 8;

            case 'b':
            case 'c':
            case 'm':
            case 'p':
                return 3;

            case 'k':
                return 5;

            default:
                return 1;
        }
    }
}
