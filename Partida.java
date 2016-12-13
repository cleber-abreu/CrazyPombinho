import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Font;
import java.util.List;

public class Partida extends Cenario
{   
    
    ArrayList<Inimigo> inimigos;
    GreenfootImage fundo;
    int probabilidadeAparecerInimigo;
    private Actor pontuacao;
    private GreenfootImage pontos;
    public static GreenfootSound musica = new GreenfootSound("Mission_1-1.mp3");
    Color corTexto;
    boolean emJogo;
    Mensagem ok;
    public static int vidas;
    int fase;
    
    /*Construto:
     * Recebe por parametro:
     *      ArrayList de inimigos(inimigos que irao aparecer durante a partida
     *      A imagem do background
     *      Probabilidade de aparecer inimigos
     *      e qual fase o jogador esta jogando(para ter uma recompensa justa)
     */
    
    public Partida(ArrayList<Inimigo> inimigos, GreenfootImage fundo, int probabilidadeAparecerInimigo, int fase)
    {    
        super(Geral.LARGURADATELA, Geral.ALTURADATELA);
        this.inimigos = inimigos;
        this.fundo = fundo;
        this.probabilidadeAparecerInimigo = probabilidadeAparecerInimigo;
        this.fase = fase;
        pontuacao = new Texto();
        colocaPontosNaTela();
        addObject(pontuacao, Geral.LARGURADATELA-90, 30);
        iniciaPartida();  
        
    }

    /**
     * Montar cenário para iniciar partida
     */
    private void iniciaPartida()
    {
        //seta o fundo
        setBackground(fundo);
        
        // cria o pombo
        addObject(Geral.pombo, 467, 80);
        
        musica.playLoop();
        Geral.pombo.disparos = 0;
        emJogo = true;
        vidas = Geral.pombo.resistenciaPombo;
        
    }
    
    public void act() 
    {
      
      //Se a lista de inimigos nao estiver vazia sortea se vai aparecer inimigo na tela  
      if(!inimigos.isEmpty()){
          if(Greenfoot.getRandomNumber((this.getObjects(Inimigo.class).size() + 1) * 2500)  < probabilidadeAparecerInimigo){
           sorteiaInimigo(inimigos);
        }
        //Se ela estiver vazia e o jogo nao tiver acabado, exibir texto de fim
      }else if(this.getObjects(Inimigo.class).size() == 0 && emJogo){
          Mensagem vitoria = new Mensagem("Voce Venceu!!", 250, 100, 25, 40, 35);
          addObject(vitoria, 375, 225);
          ok = new Mensagem("Ok", 70, 50, 25, 20, 35);
          addObject(ok, 375, 250);
          emJogo = false;
          Geral.pombo.pontosPombo += (35 * fase) + (Math.pow(2,fase)*15) + (Math.pow(3,fase) * 3);
          musica.pause();
      }else if(Greenfoot.mouseClicked(this.ok)){
          musica.stop();
          Greenfoot.setWorld(new MenuFase());
      }
      if(vidas < 0){
          musica.stop();
          
          List pombos = getObjects(Pombo.class);
          
      }
      if(vidas < -1){
          Greenfoot.setWorld(new MenuFase());
      }
      
        
    }
    
    public void sorteiaInimigo(ArrayList<Inimigo> inimigos){
        
        //Sorteia um inimigo da lista
        int index = Greenfoot.getRandomNumber(inimigos.size());
        //Adiciona ele no world(ele só vai ter imagem quando se mover)
        addObject(inimigos.get(index),0,0);
        //Adiciona ele na posicao correta
        inimigos.get(index).criaInimigo();
        //Apaga ele da lista
        inimigos.remove(index);
        
    }
    
    public void colocaPontosNaTela(){
        pontos = new GreenfootImage(150, 32);
        corTexto = new Color(0,0,0,200);
        
        Color cor = new Color(255,255,255, 100);
        pontos.setColor(cor);
        
        pontos.fill();
        pontos.setColor(corTexto);
        pontos.setFont(new Font("sanserif", Font.BOLD, 25));
        pontos.drawString(Integer.toString(Geral.pombo.pontosPombo), 5, 25);
        pontuacao.setImage(pontos);      
        
    }
    
        
    public void started()
    {
        musica.playLoop();
    }

    public void stopped()
    {
        musica.pause();
    }
    
}
