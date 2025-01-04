package com.mygdx.game.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.GameLogic;

public class GameMenuScreen implements Screen {
    private final Game game;
    GameLogic glogic;

    ImageButton back, start, skins;
    Stage stage;

    public GameMenuScreen(Game game){
        this.game = game;
    }

    private void loadTextures(){
        back = new ImageButton(new TextureRegionDrawable((new Texture("buttons/back.png"))));
        start = new ImageButton(new TextureRegionDrawable((new Texture("buttons/start.png"))));
        skins = new ImageButton(new TextureRegionDrawable((new Texture("buttons/skins.png"))));
    }

    private void loadListeners(){
        back.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                System.out.println("Main Menu!");
                game.setScreen(new MainMenuScreen(game));
            }
        });
        start.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                System.out.println("Starting the game!");
                game.setScreen(new GameScreen(game));
            }
        });
        skins.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("Skins");
                game.setScreen(new SkinChooseScreen(game));
            }
        });
    }

    private void loadBounds(){
        back.setBounds(20, 20, 100, 50);
        start.setBounds((640-400)/2, 480-120, 400, 100);
        skins.setBounds((640-400)/2, 480-120-120, 400, 100);
    }

    private void addActors(){
        stage.addActor(back);
        stage.addActor(start);
        stage.addActor(skins);
    }

    @Override
    public void show() {
        glogic = new GameLogic();
        loadTextures();
        loadBounds();
        loadListeners();
        stage = new Stage();
        addActors();
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(0,0,0,0);
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
}
