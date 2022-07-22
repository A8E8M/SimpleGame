package com.SG;

public class GameLogic {
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
    public boolean setLetter (char letter) {
        boolean yesNo = false; // true - верная буква, false - неверная буква
        for (int i = 0; i < maskWord.length(); i++) {
            if (maskWord.charAt(i) != '-') {
                maskWord2.append(maskWord.charAt(i));
            } else if (letter == word.charAt(i)) {
                maskWord2.append(letter);
                yesNo = true;
            } else {
                maskWord2.append("-");
            }
        }

        maskWord=maskWord2.toString();
        maskWord2.delete(0, maskWord2.length());
        return yesNo;
    }
}
