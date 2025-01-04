package com.mygdx.game.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
//import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.LocalAccount;
import com.mygdx.game.LocalAccount.OSkins;
import com.mygdx.game.LocalAccount.XSkins;

public class SkinChooseScreen implements Screen{
    private final Game game;

    ImageButton toxicX, back, defaultX, defaultO, eyesO, defaults;
    Image text;
    Stage stage;
    
    SkinChooseScreen(Game game){
        this.game = game;
    }

    private void loadTextures(){
        back = new ImageButton(new TextureRegionDrawable((new Texture("buttons/back.png"))));
        defaultX = new ImageButton(new TextureRegionDrawable(new Texture("inventory/x/default/inactive.png")),new TextureRegionDrawable(new Texture("inventory/x/default/chosen.png")),new TextureRegionDrawable(new Texture("inventory/x/default/chosen.png")));
        toxicX = new ImageButton(new TextureRegionDrawable(new Texture("inventory/x/toxicx/inactive.png")), new TextureRegionDrawable(new Texture("inventory/x/toxicx/chosen.png")), new TextureRegionDrawable(new Texture("inventory/x/toxicx/chosen.png")));
        defaultO = new ImageButton(new TextureRegionDrawable(new Texture("inventory/o/default/inactive.png")),new TextureRegionDrawable(new Texture("inventory/o/default/chosen.png")),new TextureRegionDrawable(new Texture("inventory/o/default/chosen.png")));
        eyesO = new ImageButton(new TextureRegionDrawable(new Texture("inventory/o/eyes/inactive.png")),new TextureRegionDrawable(new Texture("inventory/o/eyes/chosen.png")),new TextureRegionDrawable(new Texture("inventory/o/eyes/chosen.png")));
        text = new Image(new Texture("fonts/chooseskin.png"));
        defaults = new ImageButton(new TextureRegionDrawable(new Texture("buttons/defaults.png")));
    }

    private void loadBounds(){
        defaultX.setBounds(215, 370, 100, 100);
        toxicX.setBounds(325,370,100,100);
        defaultO.setBounds(215, 240, 100, 100);
        eyesO.setBounds(325, 240, 100, 100);
        back.setBounds(20, 20, 100, 50);
        text.setBounds((650-400)/2, 480, 400, 100);
        defaults.setBounds(195, 140, 250, 62);
    }

    private void addActors(){
        stage.addActor(toxicX);
        stage.addActor(defaultX);
        stage.addActor(defaultO);
        stage.addActor(eyesO);
        stage.addActor(back);
        stage.addActor(text);
        stage.addActor(defaults);
    }

    private void loadListeners(){
        defaultX.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                LocalAccount.getAccount().setCurrentXSkin(XSkins.DEFAULT);
                System.out.println("Skin has chosen!");
            }
        });

        toxicX.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                LocalAccount.getAccount().setCurrentXSkin(XSkins.TOXIC_X);
                System.out.println("Skin has chosen!");
            }
        });

        defaultO.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                LocalAccount.getAccount().setCurrentOSkin(OSkins.DEFAULT);
                System.out.println("Skin has chosen!");
            }
        });

        eyesO.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                LocalAccount.getAccount().setCurrentOSkin(OSkins.EYES_O);
                System.out.println("Skin has chosen!");
            }
        });

        back.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                System.out.println("Main Menu!");
                game.setScreen(new GameMenuScreen(game));
            }
        });

        defaults.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                LocalAccount.getAccount().setCurrentXSkin(XSkins.DEFAULT);
                LocalAccount.getAccount().setCurrentOSkin(OSkins.DEFAULT);
            }
        });
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
        ScreenUtils.clear(0,0,0,0);
        btnUpdate();
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
       stage.dispose();
    }

    public void btnUpdate(){
        if (LocalAccount.getAccount().getCurrentXSkin().equals(XSkins.DEFAULT)){
            defaultX.setChecked(true);
            toxicX.setChecked(false);
        }
        if (LocalAccount.getAccount().getCurrentXSkin().equals(XSkins.TOXIC_X)){
            defaultX.setChecked(false);
            toxicX.setChecked(true);
        }

        if (LocalAccount.getAccount().getCurrentOSkin().equals(OSkins.DEFAULT)){
            defaultO.setChecked(true);
            eyesO.setChecked(false);
        }
        if(LocalAccount.getAccount().getCurrentOSkin().equals(OSkins.EYES_O)){
            defaultO.setChecked(false);
            eyesO.setChecked(true);
        }
    }

}