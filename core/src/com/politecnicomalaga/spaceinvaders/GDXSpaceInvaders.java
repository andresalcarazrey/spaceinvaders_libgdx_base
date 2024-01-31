package com.politecnicomalaga.spaceinvaders;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.Random;

public class GDXSpaceInvaders extends ApplicationAdapter {

	//ESTADO
	private SpriteBatch batch;
	private ObjetoVolador ovni;

	private Texture naveT;

	private int contadorFrames;



	//COMPORTAMIENTO

	//RESTO COMPORTAMIENTOS

	//¿CONSTRUCTOR? NO TENGO, pero me dicen que create hace las veces de contructor
	@Override
	public void create () {

		contadorFrames = 0;
		Random r = new Random();
        naveT = new Texture("nave.png");
		batch = new SpriteBatch();
		ovni = new ObjetoVolador(r.nextInt(400)+50,r.nextInt(300)+100,0,0,naveT);

	}

	@Override
	public void render () {

		contadorFrames++;
		Random r = new Random();

		//Controlar lo que pasa
		ovni.moverse();
		if (contadorFrames == 29) {
			contadorFrames = 0;
			ovni.setVelX(r.nextFloat() * 10 - 5);
			ovni.setVelY(r.nextFloat() * 10 - 5);
		}

		if (ovni.getPosX()+ovni.getImg().getWidth()<-10) {
			ovni.setPosX(Gdx.graphics.getWidth()+5);
		}

		if (ovni.getPosY()+ovni.getImg().getHeight()<-10) {
			ovni.setPosY(Gdx.graphics.getHeight()+5);
		}

		if (ovni.getPosX()>Gdx.graphics.getWidth()+10) {
			ovni.setPosX(-5);
		}

		if (ovni.getPosY()>Gdx.graphics.getHeight()+10) {
			ovni.setPosY(-5);
		}


		//dibujar despues
		ScreenUtils.clear(0f, 0f, 0f, 1);

		batch.begin();
		ovni.render(batch);
		batch.end();


	}
	
	@Override
	public void dispose () {
		batch.dispose();
        naveT.dispose();

	}

}
