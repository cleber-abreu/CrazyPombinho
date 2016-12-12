import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Soldado here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Soldado extends Inimigo
{
    
    public void criaInimigo(){
        this.setLocation((Greenfoot.getRandomNumber(2) * Geral.LARGURADATELA), 423);
    }
    public Soldado()
    {
        resistencia = Geral.RESISTENCIA_SOLDADO;
        recompensa = Geral.RECOMPENSA_SOLDADO;
        
        imagens = new GreenfootImage[2][7];
        destino = 20 + Greenfoot.getRandomNumber(Geral.LARGURADATELA - 40);
        velocidade = 1;
        velocidadeAnimacao = 5;
        probabilidadeDisparo = 50;
        
        for(int i=0; i < imagens[0].length; i++) {
            // Imagens virada para esquerda
            imagens[0][i] = new GreenfootImage("Soldado-esq" + i + ".png");

            // Imagens virada para direita          
            imagens[1][i] = new GreenfootImage("Soldado-dir" + i + ".png");
        }
        
    }
   
    public void act() 
    {
        ciclo++;
        
        if (atacando == 0)
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
        
        if (Greenfoot.getRandomNumber(10000) < probabilidadeDisparo)
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
            if ((((Pombo)pombos.get(0)).getX()) > getX() )
            {
                setImage("Soldado-ataque-80.png");
                getWorld().addObject(new Missil(80), getX(), getY() - 32);
            }
            else
            {
                setImage("Soldado-ataque-100.png");
                getWorld().addObject(new Missil(100), getX(), getY() - 32);
            }
            
            atacando++;
        }
    }   
}
