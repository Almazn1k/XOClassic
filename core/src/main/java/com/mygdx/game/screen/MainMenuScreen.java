package com.mygdx.game.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;

public class MainMenuScreen implements Screen {
    private final Game game;

    Image logo;
    ImageButton login, play, exit,stats;
    Stage stage;


    public MainMenuScreen(Game game) {
        this.game = game;
    }

    private void loadTextures(){
        logo = new Image(new Texture("logoclassic.png"));
        login = new ImageButton(new TextureRegionDrawable((new Texture("buttons/login.png"))));
        play = new ImageButton(new TextureRegionDrawable((new Texture("buttons/play.png"))));
        exit = new ImageButton(new TextureRegionDrawable((new Texture("buttons/exit.png"))));
        stats = new ImageButton(new TextureRegionDrawable((new Texture("buttons/stats.png"))));
    }

    private void loadBounds(){
        login.setBounds(520, 570, 100, 50);
        play.setBounds((640-200)/2, 380-120, 200, 100);
        exit.setBounds((640-200)/2, 380-120-120, 200, 100);
        stats.setBounds(640-70, 640-70, 50, 50);
        logo.setBounds(192, 384, 256, 256);
    }

    private void loadListeners(){
        login.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("Click!");
            }
        });
        play.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("PLAYYYYYYYYYY");
                game.setScreen(new GameMenuScreen(game));
            }
        });
        exit.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("Exiting...");
                Gdx.app.exit();
            }
        });
    }

    private void addActors(){
        stage.addActor(logo);
        stage.addActor(play);
        stage.addActor(exit);
    }

    @Override
    public void show() {
        loadTextures();
        loadBounds();
        loadListeners();

        stage = new Stage();
        addActors();
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 0);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        
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