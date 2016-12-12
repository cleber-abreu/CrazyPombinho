import java.util.ArrayList;
import greenfoot.*; 
/**
 * Write a description of class Regras here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Geral{
    
    // ________________  TELA  ________________//
    //Dimençoes
    public static final int LARGURADATELA = 750;
    public static final int ALTURADATELA = 480;
    //BackGrounds
    public static GreenfootImage backgroundFase01 = new GreenfootImage("fase1.png");
    public static GreenfootImage backgroundFase02 = new GreenfootImage("fase2.png");
    public static GreenfootImage backgroundFase03 = new GreenfootImage("fase3.png");
    public static GreenfootImage backgroundFase04 = new GreenfootImage("fase4.png");
    public static GreenfootImage backgroundFase05 = new GreenfootImage("fase5.png");
    public static GreenfootImage backgroundFase06 = new GreenfootImage("fase6.png");
    public static GreenfootImage backgroundFase07 = new GreenfootImage("fase7.png");
    
    
    // ________________  POMBO  ________________//
    //INICIAL
    public static Pombo pombo = new Pombo();
    public static final int VELOCIDADEINICIAL                   = 2;
    public static final int ATAQUEINICIAL                       = 1;
    public static final int RESISTENCIAINICIAL                  = 0;
    public static final int MAXTIROSINICIAL                     = 2;
    public static final int PROBABILIDADE_TIRO_CRITICOINICIAL   = 5;
    public static final int PONTOSINICIAL                       = 800;
    
    //MAXIMO
    public static final int VELOCIDADEMAX                       = 7;
    public static final int ATAQUEMAX                           = 6;
    public static final int RESISTENCIAMAX                      = 5;
    public static final int MAXTIROSMAX                         = 7;
    public static final int PROBABILIDADE_TIRO_CRITICOMAX       = 65;
    
    //Custo
    public static int[] velocidadeCusto                         = new int[VELOCIDADEMAX-VELOCIDADEINICIAL+1];
    public static int[] ataqueCusto                             = new int[ATAQUEMAX-ATAQUEINICIAL+1];
    public static int[] resistenciaCusto                        = new int[RESISTENCIAMAX-RESISTENCIAINICIAL+1];
    public static int[] maxTirosCusto                           = new int[MAXTIROSMAX-VELOCIDADEINICIAL+1];
    public static int[] probabilidadeTiroCriticoCusto           = new int[((PROBABILIDADE_TIRO_CRITICOMAX-PROBABILIDADE_TIRO_CRITICOINICIAL)/10)+1];
        
    
    
    
    //________________  INIMIGOS   ________________//
    //Status Inimigos
    public static final int RESISTENCIA_Mateus = 5;
    public static final int RECOMPENSA_Mateus = 20;
    
    public static final int RESISTENCIA_SCORPION = 18;
    public static final int RECOMPENSA_SCORPION = 50;
    
    public static final int RESISTENCIA_SOLDADO = 46;
    public static final int RECOMPENSA_SOLDADO = 80;
    
    //Inimigos cada fase
    public static ArrayList<Inimigo> inimigos = new ArrayList<Inimigo>();

    
    
    public static SalvarArquivo arquivo;
    
    public Geral(){
       arquivo = new SalvarArquivo("jogo.prog");
       
       for(int x = 0; x < velocidadeCusto.length; x++){
           int aumento = 150;
           velocidadeCusto[x] = aumento * (x+1);
       }
       for(int x = 0; x < ataqueCusto.length; x++){
           int aumento = 180;
           ataqueCusto[x] = aumento * (x+1);
       }
       for(int x = 0; x < resistenciaCusto.length; x++){
           int aumento = 500;
           resistenciaCusto[x] = aumento * (x+1);
       }
       for(int x = 0; x < maxTirosCusto.length; x++){
           int aumento = 150;
           maxTirosCusto[x] = aumento * (x+1);
       }
       for(int x = 0; x < probabilidadeTiroCriticoCusto.length; x++){
           int aumento = 150;
           probabilidadeTiroCriticoCusto[x] = aumento * (x+1);
       }
       
        
    }
    
    public static ArrayList<Inimigo> criarVetorInimigo(int fase){
       ArrayList<Inimigo> inimigos= new ArrayList<Inimigo>();
       
       if(fase == 1){
           inimigos.add(new Mateus());
           inimigos.add(new Mateus());
           inimigos.add(new Mateus());
           inimigos.add(new Scorpion());
           inimigos.add(new BalaGigante());
        }else if(fase == 2){
           inimigos.add(new Mateus());
           inimigos.add(new Mateus());
           inimigos.add(new Mateus());
           inimigos.add(new Mateus());
           inimigos.add(new Scorpion());
           inimigos.add(new BalaGigante());
        }else if(fase == 3){ 
           inimigos.add(new Mateus());
           inimigos.add(new Mateus());
           inimigos.add(new Scorpion());
           inimigos.add(new Scorpion());
           inimigos.add(new Scorpion());
           inimigos.add(new BalaGigante());
           inimigos.add(new BalaGigante());
           inimigos.add(new Soldado());
           inimigos.add(new Soldado());
        }else if(fase == 4){
           inimigos.add(new Mateus());
           inimigos.add(new Mateus());
           inimigos.add(new Scorpion());
           inimigos.add(new Scorpion());
           inimigos.add(new Scorpion());
           inimigos.add(new Scorpion());
           inimigos.add(new BalaGigante());
           inimigos.add(new BalaGigante());
           inimigos.add(new BalaGigante());
           inimigos.add(new Soldado());
           inimigos.add(new Soldado());
           inimigos.add(new Soldado());
           inimigos.add(new Soldado());
        }else if(fase == 5){
           inimigos.add(new Mateus());
           inimigos.add(new Scorpion());
           inimigos.add(new Scorpion());
           inimigos.add(new Scorpion());
           inimigos.add(new Scorpion());
           inimigos.add(new Scorpion());
           inimigos.add(new Scorpion());
           inimigos.add(new BalaGigante());
           inimigos.add(new BalaGigante());
           inimigos.add(new BalaGigante());
           inimigos.add(new BalaGigante());
           inimigos.add(new Soldado());
           inimigos.add(new Soldado());
           inimigos.add(new Soldado());
           inimigos.add(new Soldado());
           inimigos.add(new Soldado());
        }else if(fase == 6){
           inimigos.add(new Mateus());
           inimigos.add(new Scorpion());
           inimigos.add(new Scorpion());
           inimigos.add(new Scorpion());
           inimigos.add(new Scorpion());
           inimigos.add(new Scorpion());
           inimigos.add(new Scorpion());
           inimigos.add(new BalaGigante());
           inimigos.add(new BalaGigante());
           inimigos.add(new BalaGigante());
           inimigos.add(new BalaGigante());
           inimigos.add(new BalaGigante());
           inimigos.add(new BalaGigante());
           inimigos.add(new Soldado());
           inimigos.add(new Soldado());
           inimigos.add(new Soldado());
           inimigos.add(new Soldado());
           inimigos.add(new Soldado());
           inimigos.add(new Soldado());
           
        }else if(fase == 7){
           inimigos.add(new Mateus());
           inimigos.add(new Mateus());
           inimigos.add(new Mateus());
           inimigos.add(new Mateus());
           inimigos.add(new Mateus());
           inimigos.add(new Scorpion());
           inimigos.add(new Scorpion());
           inimigos.add(new Scorpion());
           inimigos.add(new Scorpion());
           inimigos.add(new Scorpion());
           inimigos.add(new Scorpion());
           inimigos.add(new BalaGigante());
           inimigos.add(new BalaGigante());
           inimigos.add(new BalaGigante());
           inimigos.add(new BalaGigante());
           inimigos.add(new BalaGigante());
           inimigos.add(new BalaGigante());
           inimigos.add(new BalaGigante());
           inimigos.add(new BalaGigante());
           inimigos.add(new BalaGigante());
           inimigos.add(new Soldado());
           inimigos.add(new Soldado());
           inimigos.add(new Soldado());
           inimigos.add(new Soldado());
           inimigos.add(new Soldado());
           inimigos.add(new Soldado());
           inimigos.add(new Soldado());
           inimigos.add(new Soldado());
    }
       return inimigos; 
    }
    
}
