import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Movimento here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Personagem extends Actor
{
    // Matriz com imagens do personagem
    protected GreenfootImage[][] imagens;
    
    // Esquerda ou Direita = 1
    protected int direcao; 
    
    // Contador de ciclos
    protected int ciclo = 1; 
    
    // velocidade de movimentação - quanto maior mais rapido
    protected int velocidade;
    
    // velocidade de movimentação - quanto menor mais rapido
    protected int velocidadeAnimacao;
    
    protected static int disparos;
    
        
    // Metodo que faz a animação dos personagens
    public void anima() 
    {
        
        for(int i=0; i<=imagens[0].length; i++)
        {
            
            // Altera imagem do personagem de acordo com intervalo de ciclos
            if ((ciclo < velocidadeAnimacao * i) || (ciclo < velocidadeAnimacao))
            {
                setImage(imagens[direcao][i]);
                break;
            }
            else if (ciclo == velocidadeAnimacao * (imagens[0].length-1))
            {
                ciclo = 0;
                setImage(imagens[direcao][i]);
            }
        }
    }
}
