import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Sangue extends Actor
{
    // Contador de ciclos
    protected int ciclo = 1; 
    protected GreenfootImage[] imagens;
    
    public Sangue ()
    {
        //CARREGAR IMAGENS
        imagens = new GreenfootImage[5];
        
        for(int i=0; i<imagens.length; i++) {
            imagens[i] = new GreenfootImage("sangue-" + i + ".png");
        }
    }
    
    public void act() 
    {
        anima();
        ciclo++;
    }
    
    public void anima() 
    {
        
        for(int i=0; i<imagens.length; i++)
        {
            
            // Altera imagem do personagem de acordo com intervalo de ciclos
            if ((ciclo < 10 * i) || (ciclo < 10))
            {
                setImage(imagens[i]);
                break;
            }
            else if (ciclo == 10 * (imagens.length-1))
            {
                 setImage(imagens[i]);
            } 
            else
            {
                Partida.vidas--; 
            }
                
        }
    }
}
