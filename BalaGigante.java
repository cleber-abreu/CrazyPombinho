import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BalaGigante here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BalaGigante extends Inimigo
{
    private int direcao;
    
    public BalaGigante()
    {
       
        velocidade = 4; 
    }
        
    
    public void act() 
    {
       
       move(direcao * velocidade);
       
       if(isTouching(Pombo.class))
       {
           // remove o pombo
           removeTouching(Pombo.class);
           Partida.musica.stop();
           Greenfoot.setWorld(new MenuFase());
       }
        
       if (getX() == 0 || getX() == Geral.LARGURADATELA - 1)
       {
          getWorld().removeObject(this);
       }else if(isTouching(Coco.class)){
           removeTouching(Coco.class);
           disparos--;
       }
       
    } 
    
    public void criaInimigo(){
        this.setLocation((Greenfoot.getRandomNumber(2) * Geral.LARGURADATELA), 435);
        
        direcao = Greenfoot.getRandomNumber(2);
        this.setLocation((Geral.LARGURADATELA - 2) - (direcao * (Geral.LARGURADATELA - 3)), 50 + Greenfoot.getRandomNumber(280));
        this.direcao = 2 * direcao - 1;
        if (this.direcao < 0){
           setImage("BalaGigante-esq.png");
        }else{
           setImage("BalaGigante-dir.png"); 
        }
    }
}
