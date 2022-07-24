package com.SG;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SimpleGame {
    public static void main(String[] args) {

        Map<Integer, String> wordCollection = new HashMap<>();
        wordCollection.put(1,"привет");
        wordCollection.put(2,"здравствуйте");
        wordCollection.put(3,"класс");
        wordCollection.put(4,"квартира");
        wordCollection.put(5,"программа");
        int wC = (int) (Math.random()*(wordCollection.size()));
        GameLogic game = new GameLogic(wordCollection.get(wC));

        boolean oneTwo = true; // true - ход игрока один, false - ход игрока два
        Scanner input = new Scanner(System.in);
        System.out.println("Добро пожаловать в игру \"Угадай слово\"!");

        System.out.print("Введите имя первого игрока: ");
        Player playerOne = new Player(input.nextLine());

        System.out.print("Введите имя второго игрока: ");
        Player playerTwo = new Player(input.nextLine());

        System.out.println("Поехали! Загаданное слово: " + game.getMaskWord());

        do {
            if (oneTwo) {
                System.out.print(playerOne.getName()+ ", введи букву: ");
                playerOne.setScore(game.setLetter(input.next().charAt(0)));
            } else {
                System.out.print(playerTwo.getName()+ ", введи букву: ");
                playerTwo.setScore(game.setLetter(input.next().charAt(0)));
            }
            System.out.println(game.getMaskWord());
            oneTwo =! oneTwo;
        } while (game.getMaskWord().contains("-"));

        if (playerOne.getScore()> playerTwo.getScore()){
            System.out.println("Ура! Победил "+ playerOne.getName()+ "!");
        } else if (playerOne.getScore() < playerTwo.getScore()) {
            System.out.println("Ура! Победил "+ playerTwo.getName()+ "!");
        } else {
            System.out.println("Ого, ничья!");
        }
        playerOne.outputScore();
        playerTwo.outputScore();
        input.close();
    }
}

