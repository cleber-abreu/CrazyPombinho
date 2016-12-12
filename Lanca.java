import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Lanca extends AtqInimigo
{
    
    public Lanca(int angulo)
    {
       super(angulo);
       Greenfoot.playSound("scorpion.mp3");
    }   
    
    public void act() 
    {        
        move(4);
        
        this.verificaTouching();
    }  
}
