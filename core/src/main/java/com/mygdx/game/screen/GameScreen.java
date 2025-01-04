package com.mygdx.game.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.GameLogic;
import com.mygdx.game.LocalAccount;

public class GameScreen implements Screen {
    private final Game game;
    GameLogic glogic;

    Image gamefield, turn,x,o,turntext,infobox,victorytext,tietext,xcoin,reward1,reward0, tie;
    ImageButton confirm;
    Stage stage;
    SpriteBatch batch = new SpriteBatch();

    private boolean ingame = true;

    GameScreen(Game game){
        this.game = game;
    }

    private void loadTextures() {
        turntext = new Image(new Texture("fonts/turn.png"));
        tietext = new Image(new Texture("fonts/tie.png"));
        victorytext = new Image(new Texture("fonts/victory.png"));
        turn = new Image(new Texture("sprites/skins/x/x.png"));
        infobox = new Image(new Texture("infobox.png"));
        x = new Image(new Texture(LocalAccount.getAccount().getXSkinPath()));
        o = new Image(new Texture(LocalAccount.getAccount().getOSkinPath()));
        gamefield = new Image(new Texture("gamefield.png"));
        xcoin = new Image(new Texture("shop/wallet/xcoin.png"));
        reward0 = new Image(new Texture("fonts/reward0.png"));
        reward1 = new Image(new Texture("fonts/reward1.png"));
        confirm = new ImageButton(new TextureRegionDrawable(new Texture("buttons/confirm.png")));
        tie = new Image(new Texture("tie.png"));
    }

    private void loadBounds(){
        gamefield.setBounds((640-512)/2, (640-512)/2,512,512);
        turn.setBounds(140,640-80,70,70);
        turntext.setBounds(20,640-70,100,50);
        infobox.setBounds((640-400)/2,(640-400)/2,400,400);
        confirm.setBounds(170, 140, 300,100);
        victorytext.setBounds(170,140+150,300,80);
        tietext.setBounds(170,140+150,300,80);
        reward0.setBounds(270,140+105,150,40);
        reward1.setBounds(270,140+105,150,40);
        xcoin.setBounds(280, 140+108, 32, 32);
        tie.setBounds(280,140+120+120,90,90);
    }

    @Override
    public void show() {
        glogic = new GameLogic();
        loadTextures();
        loadBounds();

        confirm.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new GameMenuScreen(game));
            }
        });

        stage = new Stage();
        stage.addActor(gamefield);
        stage.addActor(turn);
        stage.addActor(turntext);

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(0,0,0,0);
        if(Gdx.input.justTouched() && ingame){
            System.out.println("X: "+Gdx.input.getX());
            System.out.println("Y: "+Gdx.input.getY());
            glogic.checkTurn(Gdx.input.getX(),Gdx.input.getY());
            for(int i=0;i < glogic.getSpritesLength(); i++){
                for(int j=0;j < glogic.getSpritesLength(); j++){
                    if (glogic.getSpritesElement(i,j).equals("O") || glogic.getSpritesElement(i,j).equals("X")){
                        x = new Image(new Texture(LocalAccount.getAccount().getXSkinPath()));
                        o = new Image(new Texture(LocalAccount.getAccount().getOSkinPath()));
                        if (i==0 && j==0){
                            if (glogic.getSpritesElement(i,j).equals("X")){
                                x.setBounds(182-45,442-35,90,90);
                                stage.addActor(x);
                            }
                            else{
                                o.setBounds(182-45,442-35,90,90);
                                stage.addActor(o);
                            }
                        }
                        else if (i==1 && j==0){
                            if (glogic.getSpritesElement(i,j).equals("X")){
                                x.setBounds(182-45,322-50,90,90);
                                stage.addActor(x);
                            }
                            else{
                                o.setBounds(182-45,322-50,90,90);
                                stage.addActor(o);
                            }
                        }
                        else if (i==2 && j==0){
                            if (glogic.getSpritesElement(i,j).equals("X")){
                                x.setBounds(182-45,182-45,90,90);
                                stage.addActor(x);
                            }
                            else{
                                o.setBounds(182-45,182-45,90,90);
                                stage.addActor(o);
                            }
                        }
                        else if (i==0 && j==1){
                            if (glogic.getSpritesElement(i,j).equals("X")){
                                x.setBounds(299-25,442-35,90,90);
                                stage.addActor(x);
                            }
                            else{
                                o.setBounds(299-25,442-35,90,90);
                                stage.addActor(o);
                            }
                        }
                        else if (i==1 && j==1){
                            if (glogic.getSpritesElement(i,j).equals("X")){
                                x.setBounds(321-45,317-45,90,90);
                                stage.addActor(x);
                            }
                            else{
                                o.setBounds(321-45,317-45,90,90);
                                stage.addActor(o);
                            }
                        }
                        else if (i==2 && j==1){
                            if (glogic.getSpritesElement(i,j).equals("X")){
                                x.setBounds(299-45,182-45,90,90);
                                stage.addActor(x);
                            }
                            else{
                                o.setBounds(299-45,182-45,90,90);
                                stage.addActor(o);
                            }
                        }
                        else if (i==0 && j==2){
                            if (glogic.getSpritesElement(i,j).equals("X")){
                                x.setBounds(461-45,442-45,90,90);
                                stage.addActor(x);
                            }
                            else{
                                o.setBounds(452-45,442-45,90,90);
                                stage.addActor(o);
                            }
                        }
                        else if (i==1 && j==2){
                            if (glogic.getSpritesElement(i,j).equals("X")){
                                x.setBounds(461-45,322-45,90,90);
                                stage.addActor(x);
                            }
                            else{
                                o.setBounds(461-45,322-45,90,90);
                                stage.addActor(o);
                            }
                        }
                        else if (i==2 && j==2){
                            if (glogic.getSpritesElement(i,j).equals("X")){
                                x.setBounds(461-45,182-45,90,90);
                                stage.addActor(x);
                            }
                            else{
                                o.setBounds(461-45,182-45,90,90);
                                stage.addActor(o);
                            }
                        }
                    }
                    System.out.println(glogic.getC());
                }
            }
            if (glogic.checkVictory() == 1){
                ingame = false;
                LocalAccount.getAccount().getReward();
                x = new Image(new Texture("sprites/skins/x/x.png"));
                x.setBounds(280,140+120+120,90,90);
                showVictory();
                stage.addActor(x);
            }
            else if (glogic.checkVictory() == 2){
                ingame = false;
                LocalAccount.getAccount().getReward();
                o = new Image(new Texture("sprites/skins/o/o.png"));
                o.setBounds(280,140+120+120,90,90);
                showVictory();
                stage.addActor(o);
            }
            else if (glogic.checkVictory() == 0 && glogic.getC() == 9){
                ingame = false;
                stage.addActor(infobox);
                stage.addActor(confirm);
                stage.addActor(tietext);
                stage.addActor(tie);
                glogic.setC(0);
            }
            if (glogic.getIsX()){
                turn.setDrawable(new SpriteDrawable(new Sprite(new Texture("sprites/skins/x/x.png"))));
            }
            else {
                turn.setDrawable(new SpriteDrawable(new Sprite(new Texture("sprites/skins/o/o.png"))));
            }
        }
        stage.draw();
    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.clear();
        stage.dispose();
    }

    public void showVictory(){
        stage.addActor(infobox);
        stage.addActor(confirm);
        stage.addActor(victorytext);
    }
}
