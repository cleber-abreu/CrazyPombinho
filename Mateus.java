import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Pessoa1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mateus extends Inimigo
{
    
    public Mateus()
    {
        imagens = new GreenfootImage[2][5];
        GreenfootImage a = getImage();
        resistencia = Geral.RESISTENCIA_Mateus;
        recompensa = Geral.RECOMPENSA_Mateus;
     
        
        
        destino = 20 + Greenfoot.getRandomNumber(Geral.LARGURADATELA - 40);
        velocidade = 1;
        velocidadeAnimacao = 5;
        probabilidadeDisparo = 50;
        
        for(int i=0; i<5; i++) {
            // Imagens da pessoa virada para esquerda
            imagens[0][i] = new GreenfootImage("Mateus-esq" + i + ".png");

            // Imagens da pessoa virada para direita          
            imagens[1][i] = new GreenfootImage("Mateus-dir" + i + ".png");
        }
        
    }
   
    public void act() 
    {
        ciclo++;
        
        if(atacando == 0)
        {
            anima();
            
            //Mover, se direcao = 0: movimento negativo; se direcao = 1: movimento positivo
            move( (2 * direcao - 1)  * velocidade);
            
            // <0   1>
            if (getX() < destino)
            {
                direcao = 1;
            }
            else if (getX() > destino)
            {
                direcao = 0;
            }
            else
            {
                dispara();
                destino = 20 + Greenfoot.getRandomNumber(Geral.LARGURADATELA - 40);
            }
            
        }
        else if(atacando < velocidadeAnimacao * 4)
        {
            atacando++;
            probabilidadeDisparo = 25;
        }
        else {
            atacando = 0;
            ciclo = 0;
            probabilidadeDisparo = 50;
        }
        
        if(Greenfoot.getRandomNumber(10000) < probabilidadeDisparo)
        {
            dispara();
        }
        this.verificarTouching();
    }
    
    public void dispara()
    {
        List pombos = getWorld().getObjects(Pombo.class);
        
        if (!pombos.isEmpty())
        {
            if ((((Pombo)pombos.get(0)).getX()) - getX() < 96 && (((Pombo)pombos.get(0)).getX() - getX()) > -96)
            {
                setImage("Mateus-ataque-90.png");
                getWorld().addObject(new Bala(90), getX() +7, getY() - 30);
            }
            else if ((((Pombo)pombos.get(0)).getX()) < getX() )
            {
                setImage("Mateus-ataque-135.png");
                getWorld().addObject(new Bala(135), getX() -8 , getY() - 30);
            }
            else
            {
                setImage("Mateus-ataque-45.png");
                getWorld().addObject(new Bala(45), getX() +14, getY() - 30);
            }
        
            atacando++;
        }
    }
    
}
