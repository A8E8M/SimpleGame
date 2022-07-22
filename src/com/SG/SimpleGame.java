package com.SG;

import java.io.IOException;
import java.util.Scanner;

public class SimpleGame {
    public static void main(String[] args) {
        GameLogic game = new GameLogic("класс");

        boolean oneTwo = true; // true - ход игрока один, false - ход игрока два
        Scanner input = new Scanner(System.in);
        System.out.println("Добро пожаловать в игру \"Угадай слово\"!");

        System.out.print("Введите имя первого игрока: ");
        Player playerOne = new Player(input.nextLine());

        System.out.print("Введите имя второго игрока: ");
        Player playerTwo = new Player(input.nextLine());

        System.out.println("Поехали! Загаданное слово: " + game.getMaskWord());

        do {
            char letter;
            int ball;
            if (oneTwo) {
                System.out.print(playerOne.getName()+ ", введи букву: ");
                letter = input.next().charAt(0);
                ball = game.setLetter(letter);
            } else {
                System.out.print(playerTwo.getName()+ ", введи букву: ");
                letter = input.next().charAt(0);
                ball = game.setLetter(letter);
            }
            System.out.println(game.getMaskWord());
            if (oneTwo) {
                playerOne.setScore(ball);
            } else {
                playerTwo.setScore(ball);
            }
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

