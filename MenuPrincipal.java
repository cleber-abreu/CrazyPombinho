import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 *  
 */
public class MenuPrincipal extends Cenario
{
    
    BotaoMenuPrincipal[] opcoes = new BotaoMenuPrincipal[3];
    
    public MenuPrincipal(){        
        super(Geral.LARGURADATELA, Geral.ALTURADATELA);
        new Geral();   
        Greenfoot.start();

        opcoes[0] = new BotaoMenuPrincipal("Continuar", 47);
        opcoes[1] = new BotaoMenuPrincipal("Novo jogo", 42);
        opcoes[2] = new BotaoMenuPrincipal("Sair", 75);     
        
        addObject(opcoes[0], 135, 435);
        addObject(opcoes[1], 375, 435);
        addObject(opcoes[2], 616, 435);
    }
    
    public void act(){
        /*Se clicar no carregar
         * vai ler arquivo e setar os status do pombo
         */
        if(Greenfoot.mouseClicked(opcoes[0])){
            Botao.somAoClicar.play();
            ArrayList<Integer> dados = Geral.arquivo.lerArquivo();
            
            Geral.pombo.velocidadePombo                           = dados.get(0);
            Geral.pombo.ataquePombo                               = dados.get(1);
            Geral.pombo.resistenciaPombo                          = dados.get(2);
            Geral.pombo.maxTirosPombo                             = dados.get(3);
            Geral.pombo.probabilidadeTiroCriticoPombo             = dados.get(4);
            Geral.pombo.pontosPombo                               = dados.get(5);
            
            Greenfoot.setWorld(new MenuFase());
        }else if(Greenfoot.mouseClicked(opcoes[1])){
            /*Se clicar em novo jogo
             * Vai buscar os status inicial da classe Geral
             */
            Botao.somAoClicar.play();
            
            Geral.pombo.velocidadePombo                           = Geral.VELOCIDADEINICIAL;
            Geral.pombo.ataquePombo                               = Geral.ATAQUEINICIAL;
            Geral.pombo.resistenciaPombo                          = Geral.RESISTENCIAINICIAL;
            Geral.pombo.maxTirosPombo                             = Geral.MAXTIROSINICIAL;
            Geral.pombo.probabilidadeTiroCriticoPombo             = Geral.PROBABILIDADE_TIRO_CRITICOINICIAL;
            Geral.pombo.pontosPombo                               = Geral.PONTOSINICIAL;

            Greenfoot.setWorld(new MenuFase());
        }else if(Greenfoot.mouseClicked(opcoes[2])){
            // Se sair, exit o jogo
            Botao.somAoClicar.play();
            Greenfoot.stop();
            System.exit(0);
        }
        
    }
    
   
}
