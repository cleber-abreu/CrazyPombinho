import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class Pombo extends Personagem
{  
   private static boolean espacoPressionado = false;

   public int velocidadePombo                           = Geral.VELOCIDADEINICIAL;
   public int ataquePombo                               = Geral.ATAQUEINICIAL;
   public int resistenciaPombo                          = Geral.RESISTENCIAINICIAL;
   public int maxTirosPombo                             = Geral.MAXTIROSINICIAL; // Máximo de tiro
   public int probabilidadeTiroCriticoPombo             = Geral.PROBABILIDADE_TIRO_CRITICOINICIAL;
   public int pontosPombo                               = Geral.PONTOSINICIAL;
   
   
   // Construtor
   public Pombo()
   {
      //CARREGAR IMAGENS
      imagens = new GreenfootImage[2][6];
      for(int i=0; i<6; i++) {
          // Imagens do pombo virado para esquerda
          imagens[0][i] = new GreenfootImage("pombo-esq" + i + ".png");

          // Imagens do pombo virado para direita          
          imagens[1][i] = new GreenfootImage("pombo-dir" + i + ".png");
      }
      
      Greenfoot.playSound("pombo.mp3");
      
      // direção para direita
      direcao = 1;
      
      // velocidade de movimentação
      velocidadeAnimacao = 5;
      
    }
    
   public void act() 
    {
        
        ciclo++;
        
        // Metodo que gera animações do personagem
        anima();
        verificaToque();
        /**
          * Verfica ações de teclado **
          */
         
        // Movimentos - Setas
        if (Greenfoot.isKeyDown("left"))
        {
            direcao = 0;

            move(-velocidadePombo);
        }
        
        if (Greenfoot.isKeyDown("right"))
        {
            direcao = 1;
           
            move(velocidadePombo);
        }
        
        if (Greenfoot.isKeyDown("up"))
        {
            setLocation(getX(), getY() - velocidadePombo);
        }
        
        if (Greenfoot.isKeyDown("down") && getY() < 320)
        {
            setLocation(getX(), getY() + velocidadePombo);
        }

        // Espaço - Tiro
        if (Greenfoot.isKeyDown("space") && disparos < maxTirosPombo)
        {
            if(!espacoPressionado)
            { 
               espacoPressionado = true;
               dispara();
            }
            
        }else 
            {
                espacoPressionado = false;
            }
    }
    
    private void dispara(){
        
        
        if(Greenfoot.getRandomNumber(100) < probabilidadeTiroCriticoPombo){
            getWorld().addObject(new Coco(true), getX(), getY() + 24);
            disparos++;
        }else{
            getWorld().addObject(new Coco(false), getX(), getY() + 24);
            disparos++;
        }
    }
    
   private void verificaToque(){
       List atqsInimigo = this.getIntersectingObjects(AtqInimigo.class);
       
       if(!atqsInimigo.isEmpty()){
           for(int x = 0; x < atqsInimigo.size(); x++){
               Partida.vidas--;
               getWorld().removeObject((AtqInimigo)atqsInimigo.get(x));
               
           }
       }
       
       
       
   }
    
    
    
}

