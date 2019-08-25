package Assignment2_200395854;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static Assignment2_200395854.InitializerModel.*;


public class Controller {
    @FXML
    private Label errorBox;

    @FXML
    private TextField wordInputBox;

    @FXML
    private Button previousWordButton;

    @FXML
    private Label totalScoreLabel;

    @FXML
    private TextArea previousWordBox;

    //char[] vowel = new char[]{'A', 'E', 'I', 'O', 'U'};
    ArrayList<String> previousWordList = new ArrayList<String>();

    //Create word Bag
    String[] bag = {"a", "a", "a", "a", "a", "a", "a", "a", "a", "b", "b", "c", "c", "d", "d", "d", "d", "e", "e", "e", "e", "e", "e", "e", "e", "e", "e", "e", "e",
            "f", "f", "g", "g", "g", "h", "h", "i", "i", "i", "i", "i", "i", "i", "i", "j", "k", "l", "l", "l", "l", "m", "m", "n", "n", "n", "n", "n", "n", "o", "o",
            "o", "o", "o", "o", "o", "o", "p", "p", "q", "r", "r", "r", "r", "r", "r", "s", "s", "s", "s", "t", "t", "t", "t", "t", "t", "u", "u", "u", "u", "v", "v", "w", "w", "x", "y", "y", "z"};
    List<String> bagList = new ArrayList<String>(Arrays.asList(bag));

    //Global Score initializer
    int score = 0;

    String[] alphabets = {"a" + "b" + "c" + "d" + "e" + "f" + "g" + "h" + "i" + "j" + "k" + "l" + "m" + "n" +
            "o" + "p" + "q" + "r" + "s" + "t" + "u" + "v" + "w" + "x" + "y" + "z"};
    List<String> alphaList = new ArrayList<String>(Arrays.asList(alphabets));

    void btnDisable(){

        for(int b=0 ; b < alphabets.length; b++){
            String ltt = (String) alphaList.get(b);
            if(!bagList.contains(ltt)){
                //btn.setDisable(true)
            }
        }
    }

    void gameOver(){

       // if(bagList.size() || !(bagList.contains("a") || bagList.contains("e") || bagList.contains("i") || bagList.contains("o") || bagList.contains("u"))){

       // }
    }


    @FXML
    void submitButton(ActionEvent event) {

        String word = wordInputBox.getText().toLowerCase();

        //Word Condition Bool
        boolean wordCheck = true;

        if(word.length() == 0){
            errorBox.setText("Word is empty");
            wordCheck = false;
        }
        if(word.length() < 2 ) {
            errorBox.setText("Word length is too short! more than 2 required.");
            wordCheck = false;
        }
        if(word.length() > 8){
            errorBox.setText("Word length is too long! less than 8 required.");
            wordCheck = false;
        }
        if(word.indexOf("a") == -1 && word.indexOf("e") == -1 && word.indexOf("i") == -1 && word.indexOf("o") == -1 &&
                word.indexOf("u") == -1 ) {
            errorBox.setText("Word must contain one vowel");
            wordCheck = false;
        }
        if(previousWordList.contains(word)){
            errorBox.setText("Word is already used! Please use another word");
            wordCheck = false;
        }

        if(wordCheck){
            previousWordList.add(word.toLowerCase());
            //calc total points
            for(int a= 0; a < word.length(); a++){
                score += getValueOfLetter(word.charAt(a));
            }
            totalScoreLabel.setText(Integer.toString(score));
            System.out.println("total sc:" + score);

            //Remove letter Or set Err if doesnt have
            for(int i =0; i < word.length(); i++){

                String letter = Character.toString(word.charAt(i));
                if(!bagList.contains(letter)){
                    errorBox.setText("Bag doesn't contain letter you used: " + letter);
                }
                else {
                    //Remove letters from Bag
                    bagList.remove(letter);
                }
            }

            //Remove Err
            errorBox.setText("");

            //Reset Input field
            wordInputBox.setText("");

            //Check Gameover

        }
    }

    @FXML
    void setPreviousWordButton(ActionEvent event) {

        previousWordBox.setText(previousWordList.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ")));
    }

    @FXML
    void keyButton(ActionEvent event) {

        String source = ((Button)event.getSource()).getText();
        System.out.println(source);

        String currentInput = wordInputBox.getText();
        String finalInput = currentInput + source;
        wordInputBox.setText(finalInput);
    }
}
