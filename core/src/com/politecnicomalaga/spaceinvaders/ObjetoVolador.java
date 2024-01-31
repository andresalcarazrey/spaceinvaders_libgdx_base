package com.politecnicomalaga.spaceinvaders;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ObjetoVolador {

    //Atributos

    protected float posX, posY;
    protected Texture img;
    protected float velX, velY;


    //Métodos
    //Constructor


    public ObjetoVolador(float pX, float pY, float vX, float vY, Texture img) {
        this.img = img;
        posX = pX;
        posY = pY;
        velX = vX;
        velY = vY;
    }

    //Resto de Métodos
    public void render(SpriteBatch sp) {

        sp.draw(img,posX,posY);
    }

    public void moverse() {
        posX += velX;
        posY += velY;
    }

    public void setVelX(float velX) {
        this.velX = velX;
    }

    public void setVelY(float velY) {
        this.velY = velY;
    }

    public float getPosX() {
        return posX;
    }

    public void setPosX(float posX) {
        this.posX = posX;
    }

    public float getPosY() {
        return posY;
    }

    public void setPosY(float posY) {
        this.posY = posY;
    }

    public Texture getImg() {
        return img;
    }

    public void setImg(Texture img) {
        this.img = img;
    }
}
