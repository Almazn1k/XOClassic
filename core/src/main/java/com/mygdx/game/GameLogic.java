package com.mygdx.game;

public class GameLogic {

    private String[][] sprites = {
            {"N", "N", "N"},
            {"N", "N", "N"},
            {"N", "N", "N"},
    };

    private boolean isX = true;
    private int c = 0;

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public boolean checkTurn(int x, int y){
        if (x >=131&&x<=240){
            if (y >=117&&y<=243){
                if(sprites[0][0].equals("N")){
                    if (isX){
                        sprites[0][0] = "X";
                        isX = false;
                    }
                    else {
                        sprites[0][0] = "O";
                        isX = true;
                    }
                    c++;
                    return true;
                }
            }
            else if (y >=260&&y<=384){
                if(sprites[1][0].equals("N")){
                    if (isX){
                        sprites[1][0] = "X";
                        isX = false;
                    }
                    else {
                        sprites[1][0] = "O";
                        isX = true;
                    }
                    c++;
                    return true;
                }
            }
            else if (y >=402&&y<=521){
                if(sprites[2][0].equals("N")){
                    if (isX){
                        sprites[2][0] = "X";
                        isX = false;
                    }
                    else {
                        sprites[2][0] = "O";
                        isX = true;
                    }
                    c++;
                    return true;
                }
            }
            else {
                return false;
            }
        }
        else if (x >=253&&x<=386){
            if (y >=117&&y<=243){
                if(sprites[0][1].equals("N")){
                    if (isX){
                        sprites[0][1] = "X";
                        isX = false;
                    }
                    else {
                        sprites[0][1] = "O";
                        isX = true;
                    }
                    c++;
                    return true;
                }
            }
            else if (y >=260&&y<=384){
                if(sprites[1][1].equals("N")){
                    if (isX){
                        sprites[1][1] = "X";
                        isX = false;
                    }
                    else {
                        sprites[1][1] = "O";
                        isX = true;
                    }
                    c++;
                    return true;
                }
            }
            else if (y >=402&&y<=521){
                if(sprites[2][1].equals("N")){
                    if (isX){
                        sprites[2][1] = "X";
                        isX = false;
                    }
                    else {
                        sprites[2][1] = "O";
                        isX = true;
                    }
                    c++;
                    return true;
                }
            }
            else {
                return false;
            }
        }
        if (x >=399&&x<=506){
            if (y >=117&&y<=243){
                if(sprites[0][2].equals("N")){
                    if (isX){
                        sprites[0][2] = "X";
                        isX = false;
                    }
                    else {
                        sprites[0][2] = "O";
                        isX = true;
                    }
                    c++;
                    return true;
                }
            }
            else if (y >=260&&y<=384){
                if(sprites[1][2].equals("N")){
                    if (isX){
                        sprites[1][2] = "X";
                        isX = false;
                    }
                    else {
                        sprites[1][2] = "O";
                        isX = true;
                    }
                    c++;
                    return true;
                }
            }
            else if (y >=402&&y<=521){
                if(sprites[2][2].equals("N")){
                    if (isX){
                        sprites[2][2] = "X";
                        isX = false;
                    }
                    else {
                        sprites[2][2] = "O";
                        isX = true;
                    }
                    c++;
                    return true;
                }
            }
            else {
                return false;
            }
        }
        System.out.println(x);
        System.out.println(y);
        return false;
    }

    public int checkVictory(){
        if (sprites[0][0].equals("X") && sprites[1][0].equals("X") && sprites[2][0].equals("X")){
            return 1;
        }
        else if (sprites[0][1].equals("X") && sprites[1][1].equals("X") && sprites[2][1].equals("X")){
            return 1;
        }
        else if (sprites[0][2].equals("X") && sprites[1][2].equals("X") && sprites[2][2].equals("X")){
            return 1;
        }
        else if (sprites[0][0].equals("X") && sprites[0][1].equals("X") && sprites[0][2].equals("X")){
            return 1;
        }
        else if (sprites[1][0].equals("X") && sprites[1][1].equals("X") && sprites[1][2].equals("X")){
            return 1;
        }
        else if (sprites[2][0].equals("X") && sprites[2][1].equals("X") && sprites[2][2].equals("X")){
            return 1;
        }
        else if (sprites[0][0].equals("X") && sprites[1][1].equals("X") && sprites[2][2].equals("X")){
            return 1;
        }
        else if (sprites[0][2].equals("X") && sprites[1][1].equals("X") && sprites[2][0].equals("X")){
            return 1;
        }

        if (sprites[0][0].equals("O") && sprites[1][0].equals("O") && sprites[2][0].equals("O")){
            return 2;
        }
        else if (sprites[0][1].equals("O") && sprites[1][1].equals("O") && sprites[2][1].equals("O")){
            return 2;
        }
        else if (sprites[0][2].equals("O") && sprites[1][2].equals("O") && sprites[2][2].equals("O")){
            return 2;
        }
        else if (sprites[0][0].equals("O") && sprites[0][1].equals("O") && sprites[0][2].equals("O")){
            return 2;
        }
        else if (sprites[1][0].equals("O") && sprites[1][1].equals("O") && sprites[1][2].equals("O")){
            return 2;
        }
        else if (sprites[2][0].equals("O") && sprites[2][1].equals("O") && sprites[2][2].equals("O")){
            return 2;
        }
        else if (sprites[0][0].equals("O") && sprites[1][1].equals("O") && sprites[2][2].equals("O")){
            return 2;
        }
        else if (sprites[0][2].equals("O") && sprites[1][1].equals("O") && sprites[2][0].equals("O")){
            return 2;
        }

        return 0;
    }

    public String getSpritesElement(int i, int j){
        return sprites[i][j];
    }

    public int getSpritesLength(){
        return sprites.length;
    }

    public void setSpritesElement(int i,int j,String value){
        sprites[i][j] = value;
    }

    public boolean getIsX(){
        return isX;
    }

}
