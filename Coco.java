import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/** ATAQUE DO POMBO
 *  Tem chance de vir critico(causa 3x o dano)
 *  
 */

public class Coco extends Ataque
{
    public boolean critico;
    
    public Coco(boolean critico)
    {
        fimTrajetoria = Geral.ALTURADATELA- 10;
        this.critico = critico;
        if (critico)
        {
            setImage("coco2.png");
        }
    }
    
    public void act() 
    {       
       if(getY() > fimTrajetoria)
        {
            getWorld().removeObject(this);
            Pombo.disparos--;
        }
        else
        {
            setLocation(getX(), getY() + velocidade);
        }
       
        
    }
    
    
}
