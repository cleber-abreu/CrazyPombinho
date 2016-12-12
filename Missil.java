import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Missil extends AtqInimigo
{
    private int aux;
    
    //Missil gira
    public Missil(int angulo)
    {
       super(angulo);
       Greenfoot.playSound("missil.mp3");
    }
    
    public void act() 
    {
        setRotation(angulo);
        if (aux % 2 == 0)
        {
                
            if (angulo >= -80 && angulo < 88) 
                angulo++;
            else if (angulo > -264) 
                angulo--;
        }
        
        aux++;
        move(4);
        
        this.verificaTouching();
    }    
}
