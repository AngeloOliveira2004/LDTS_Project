package org.space.invaders.model;

import static java.lang.Math.signum;

public class Vector2D extends Position {
    public Vector2D(int x, int y) {
        super(x, y);
    }
    public double distanceModule(){
        return Math.sqrt(getX()*getX() + getY()*getY());
    }

    public void resize(double newSize){
        if(distanceModule() == 0)
            return;
        scale((int) (newSize/distanceModule()));
    }
    //TODO CAST THE POSITION TO DOUBLE OR THIS ONE TO INT
    public void scale(int scale_){
        setX(getX()*scale_);
        setY(getY()*scale_);
    }
    public double dotProduct(Vector2D vec){
        return vec.getX()*getX() + vec.getY()*getY();
    }
    public Vector2D rotate(double angle)
    {
        double pointAngle = Math.acos(dotProduct(new Vector2D(1,0))/distanceModule());

        if(signum(getY()) == -1)
            pointAngle = Math.PI*2 - pointAngle;


        double distance = distanceModule();
        double newX = Math.cos(angle + pointAngle)* distance;
        double newY = Math.sin(angle + pointAngle)* distance;
        //TODO MAYBE CAST THE CONSTRUCTOR TO DOUBLE AS WELL
        return new Vector2D((int) newX,(int) newY);
    }
    @Override
    public Position clone(){
        return new Vector2D(getX() , getY());
    }
}
