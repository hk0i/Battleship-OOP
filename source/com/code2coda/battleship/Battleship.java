package com.code2coda.battleship;

import com.code2coda.battleship.game.Game;

public class Battleship {

    public static void main(String[] args) {
        System.out.println("Welcome to Battleship!");
        boolean showComputerShips = (args.length > 0 && args[0].equals("--show-computer-ships"));
        Game game = new Game(10, showComputerShips);
    }

}
