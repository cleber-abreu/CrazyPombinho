import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *  Usando a herança para verificar se o pombo encostou em algum ataque do inimigo
 */
public class AtqInimigo extends Ataque
{
   int fimTrajetoria = Geral.ALTURADATELA - 24;
   
   protected int angulo;
    
   public AtqInimigo(int angulo)
   {
       this.angulo = -angulo;
       setRotation(-angulo);
       
   }
   
   protected void verificaTouching() 
    {
        
        if (isTouching(Coco.class))
        {
            // remove o coco
            removeTouching(Coco.class);
            Pombo.disparos--;
            
            // remove disparo
            getWorld().removeObject(this);
        }
        
        else if(getY() > fimTrajetoria || getY() < 5 || getX() > Geral.LARGURADATELA-5 || getX() < 1)
        {
            getWorld().removeObject(this);
        }
        
   }    
}
