import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class Inimigos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Inimigo extends Personagem
{
   protected int destino;
   protected int probabilidadeDisparo;
   protected int atacando;
   protected int resistencia;
   protected int recompensa;
   protected boolean vivo;
   
   
   public void criaInimigo(){
        this.setLocation((Greenfoot.getRandomNumber(2) * Geral.LARGURADATELA), 415);
        boolean vivo = true;
    }
    
   public void verificarTouching(){
       List intercecao = getIntersectingObjects(Coco.class);
       
       if(!intercecao.isEmpty()){
           for(int x = 0; x < intercecao.size(); x++){
               //Se o coco tocar o inimigo ele toma 3*ataque do pombo se o ataque for critico ou dano normal
               this.resistencia -= ((Coco)intercecao.get(x)).critico ? Geral.pombo.ataquePombo*3 : Geral.pombo.ataquePombo;
               getWorld().removeObject((Coco)intercecao.get(x));
               disparos--;
           }
       }
       
       //Verifica se a resistencia esta maior do que zero, se não remove a instancia da tela
       if(this.resistencia <= 0){
          Geral.pombo.pontosPombo += this.recompensa;
          ((Partida)getWorld()).colocaPontosNaTela();
         
          getWorld().removeObject(this);
                   } 
    }
}
