import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class MenuFase here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuFase extends Cenario
{

    Botao[] fases = new Botao[8];
    BotaoMenuFase[] opcoes = new BotaoMenuFase[3];
    
    public MenuFase()
    {    
        super(Geral.LARGURADATELA, Geral.ALTURADATELA);
        
        
        opcoes[0] = new BotaoMenuFase("Salvar", 65);
        opcoes[1] = new BotaoMenuFase("Shop", 75);
        opcoes[2] = new BotaoMenuFase("Voltar", 70);
        
        addObject(opcoes[0], 135, 50);
        addObject(opcoes[1], 375, 50);
        addObject(opcoes[2], 615, 50);
        
        
        
        for(int i = 0; i < fases.length; i++){
            fases[i] = new Botao();
            fases[i].setImage(new GreenfootImage("parque0" + i + "croc.jpg"));
        }
                
        addObject(fases[0], 105, 290);
        addObject(fases[1], 285, 290);
        addObject(fases[2], 465, 290);
        addObject(fases[3], 645, 290);
        
        addObject(fases[4], 105, 410);
        addObject(fases[5], 285, 410);
        addObject(fases[6], 465, 410);
        addObject(fases[7], 645, 410);
        
    }
    
    public void act(){
        if(Greenfoot.mouseClicked(fases[0])){
            Botao.somAoClicar.play();
            Greenfoot.setWorld(new Historia());
        }
        if(Greenfoot.mouseClicked(fases[1])){
            Botao.somAoClicar.play();
            Greenfoot.setWorld(new Partida(Geral.criarVetorInimigo(1), Geral.backgroundFase01, 40, 1));
        }
        if(Greenfoot.mouseClicked(fases[2])){
            Botao.somAoClicar.play();
            Greenfoot.setWorld(new Partida(Geral.criarVetorInimigo(2), Geral.backgroundFase02, 50, 2));
        }
        if(Greenfoot.mouseClicked(fases[3])){
            Botao.somAoClicar.play();
            Greenfoot.setWorld(new Partida(Geral.criarVetorInimigo(3), Geral.backgroundFase03, 60, 3));
        }
        if(Greenfoot.mouseClicked(fases[4])){
            Botao.somAoClicar.play();
            Greenfoot.setWorld(new Partida(Geral.criarVetorInimigo(4), Geral.backgroundFase04, 70, 4));
        }
        if(Greenfoot.mouseClicked(fases[5])){
            Botao.somAoClicar.play();
            Greenfoot.setWorld(new Partida(Geral.criarVetorInimigo(5), Geral.backgroundFase05, 80, 5));
        }if(Greenfoot.mouseClicked(fases[6])){
            Botao.somAoClicar.play();
            Greenfoot.setWorld(new Partida(Geral.criarVetorInimigo(6), Geral.backgroundFase06, 90, 6));
        }if(Greenfoot.mouseClicked(fases[7])){
            Botao.somAoClicar.play();
            Greenfoot.setWorld(new Partida(Geral.criarVetorInimigo(7), Geral.backgroundFase07, 100, 7));
        }if(Greenfoot.mouseClicked(opcoes[0])){
            Botao.somAoClicar.play();
            this.salvarJogo();
        }if(Greenfoot.mouseClicked(opcoes[1])){
            Botao.somAoClicar.play();
            Greenfoot.setWorld(new MenuShop());
        }if(Greenfoot.mouseClicked(opcoes[2])){
            Botao.somAoClicar.play();
            Greenfoot.setWorld(new MenuPrincipal());
        }
        
    }
    
    public void salvarJogo(){
        
        ArrayList<Integer> salvar = new ArrayList<Integer>();
        
        salvar.add(Geral.pombo.velocidadePombo);
        salvar.add(Geral.pombo.ataquePombo);
        salvar.add(Geral.pombo.resistenciaPombo);
        salvar.add(Geral.pombo.maxTirosPombo);
        salvar.add(Geral.pombo.probabilidadeTiroCriticoPombo);
        salvar.add(Geral.pombo.pontosPombo);
        
        Geral.arquivo.gravarArquivo(salvar);
        
        
        
    }
}
