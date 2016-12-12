import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Bala extends AtqInimigo
{
    public Bala(int angulo)
    {
       super(angulo);
       Greenfoot.playSound("bala.mp3");
    }   
    
    
    public void act() 
    {        
        move(4);
        
        this.verificaTouching();
    }    
}
