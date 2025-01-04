package com.mygdx.game;

import com.badlogic.gdx.Game;
//import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
//import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.screen.MainMenuScreen;

public class MyGdxGame extends Game {
	SpriteBatch batch;
    Screen screen;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
        screen = new MainMenuScreen(this);
        LocalAccount.init();
        setScreen(screen);
	}

	@Override
	public void render () {
        super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
