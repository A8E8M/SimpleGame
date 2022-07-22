package com.SG;

import java.util.HashMap;
import java.util.Map;

public class GameLogic {

 //   Map<String, String> mapa = new HashMap<String, String>();
   // mapa
    private final String word; // загаданное слово



    private String maskWord; //маска слова
    private final StringBuilder maskWord2 = new StringBuilder();
    public GameLogic (String word) {
        this.word = word;
        maskWord = "-".repeat(word.length());
    }
    public String getMaskWord (){
        return maskWord;
    }
    public int setLetter (char letter) {
        int ball = 0; // за каждую открытую букву по баллу
        for (int i = 0; i < maskWord.length(); i++) {
            if (maskWord.charAt(i) != '-') {
                maskWord2.append(maskWord.charAt(i));
            } else if (letter == word.charAt(i)) {
                maskWord2.append(letter);
                ball +=1;
            } else {
                maskWord2.append("-");
            }
        }

        maskWord=maskWord2.toString();
        maskWord2.delete(0, maskWord2.length());
        return ball;
    }
}
