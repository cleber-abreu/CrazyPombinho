import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Font;

/**
 * Cenario responsavel por dar upgrade no pombo 
 */
public class MenuShop extends Cenario
{
    //TODOS os botões do cenario
    BotaoMenuShop[] evoluir = new BotaoMenuShop[21];
    Texto[] texto = new Texto[10];
    
    //Exibir total de pontos do jogador, precisa do metodo colocaPontosNaTela()
    GreenfootImage fundo1;
    private Actor pontuacao1;
    private GreenfootImage pontos1;
    Color corTexto1;
    
    
    public MenuShop()
    {    
        super(Geral.LARGURADATELA, Geral.ALTURADATELA); 
        
        pontuacao1 = new Texto();
        //Nomes dos status
        evoluir[0] = new BotaoMenuShop("Velocidade", 14, 130);
        evoluir[1] = new BotaoMenuShop("Ataque", 31, 130);
        evoluir[2] = new BotaoMenuShop("Resistencia", 11, 130);
        evoluir[3] = new BotaoMenuShop("Tiros", 38, 130);
        evoluir[4] = new BotaoMenuShop("Critico", 31, 130);
        
        //Colocar status na tela
        addObject(evoluir[0], 120, 80);
        addObject(evoluir[1], 120, 160);
        addObject(evoluir[2], 120, 240);
        addObject(evoluir[3], 120, 320);
        addObject(evoluir[4], 120, 400);
        
        //valor do status atual
        evoluir[5] = new BotaoMenuShop("", 19, 50);
        evoluir[6] = new BotaoMenuShop("", 19, 50);
        evoluir[7] = new BotaoMenuShop("", 19, 50);
        evoluir[8] = new BotaoMenuShop("", 19, 50);
        evoluir[9] = new BotaoMenuShop("", 13, 50);
        
        //colocar status na tela
        addObject(evoluir[5], 205, 80);
        addObject(evoluir[6], 205, 160);
        addObject(evoluir[7], 205, 240);
        addObject(evoluir[8], 205, 320);
        addObject(evoluir[9], 205, 400);
        
        //Custo para elovuir o status
        evoluir[10] = new BotaoMenuShop("", 18, 80);
        evoluir[11] = new BotaoMenuShop("", 18, 80);
        evoluir[12] = new BotaoMenuShop("", 18, 80);
        evoluir[13] = new BotaoMenuShop("", 18, 80);
        evoluir[14] = new BotaoMenuShop("", 18, 80);
        
        //Colocar custo na tela
        addObject(evoluir[10], 265, 80);
        addObject(evoluir[11], 265, 160);
        addObject(evoluir[12], 265, 240);
        addObject(evoluir[13], 265, 320);
        addObject(evoluir[14], 265, 400);
        
        //Botao responsal por aumentar o status
        evoluir[15] = new BotaoMenuShop("+", 13, 40);
        evoluir[16] = new BotaoMenuShop("+", 13, 40);
        evoluir[17] = new BotaoMenuShop("+", 13, 40);
        evoluir[18] = new BotaoMenuShop("+", 13, 40);
        evoluir[19] = new BotaoMenuShop("+", 13, 40);
        
        //Colocar botao responsavel por aumentar o status na tela
        addObject(evoluir[15], 320, 80);
        addObject(evoluir[16], 320, 160);
        addObject(evoluir[17], 320, 240);
        addObject(evoluir[18], 320, 320);
        addObject(evoluir[19], 320, 400);
        
        //Botao Voltar
        evoluir[20] = new BotaoMenuShop("Voltar", 25, 110);
        addObject(evoluir[20], 670, 435);
        
        
        atualizarMenu();
        addObject(pontuacao1, Geral.LARGURADATELA-90, 30);
        
    }
    
    public void act(){
        
        /*  VERIFICA EM QUAL (+) O JOGADOR CLICOU
         * 
         *  se a pontuacao for maior ou igual que o custo para evoluir
         *  diminui os pontos do jogador e aumenta o status
         */
        if(Greenfoot.mouseClicked(evoluir[15])){
            Botao.somAoClicar.play();
            if(Geral.pombo.pontosPombo >= Geral.velocidadeCusto[Geral.pombo.velocidadePombo - Geral.VELOCIDADEINICIAL]){
                Geral.pombo.pontosPombo -= Geral.velocidadeCusto[Geral.pombo.velocidadePombo - Geral.VELOCIDADEINICIAL];
                Geral.pombo.velocidadePombo++;
                this.atualizarMenu();  
            }

        }else if(Greenfoot.mouseClicked(evoluir[16])){
            Botao.somAoClicar.play();
            if(Geral.pombo.pontosPombo >= Geral.ataqueCusto[Geral.pombo.ataquePombo - Geral.ATAQUEINICIAL]){
               Geral.pombo.pontosPombo -= Geral.ataqueCusto[Geral.pombo.ataquePombo - Geral.ATAQUEINICIAL];
               Geral.pombo.ataquePombo++;
               this.atualizarMenu();
            }            
        }else if(Greenfoot.mouseClicked(evoluir[17])){
            Botao.somAoClicar.play();
            if(Geral.pombo.pontosPombo >= Geral.resistenciaCusto[Geral.pombo.resistenciaPombo - Geral.RESISTENCIAINICIAL]){
               Geral.pombo.pontosPombo -= Geral.resistenciaCusto[Geral.pombo.resistenciaPombo - Geral.RESISTENCIAINICIAL];
               Geral.pombo.resistenciaPombo++;
               this.atualizarMenu(); 
            }     
            
        }else if(Greenfoot.mouseClicked(evoluir[18])){
            Botao.somAoClicar.play();
            if(Geral.pombo.pontosPombo >= Geral.maxTirosCusto[Geral.pombo.maxTirosPombo - Geral.MAXTIROSINICIAL]){
               Geral.pombo.pontosPombo -= Geral.maxTirosCusto[Geral.pombo.maxTirosPombo - Geral.MAXTIROSINICIAL];
               Geral.pombo.maxTirosPombo++;
               this.atualizarMenu(); 
            }  
            
        }else if(Greenfoot.mouseClicked(evoluir[19])){
            Botao.somAoClicar.play();
            
            if(Geral.pombo.pontosPombo >= Geral.probabilidadeTiroCriticoCusto[(Geral.pombo.probabilidadeTiroCriticoPombo -Geral.PROBABILIDADE_TIRO_CRITICOINICIAL)/10]){
               Geral.pombo.pontosPombo -= Geral.probabilidadeTiroCriticoCusto[(Geral.pombo.probabilidadeTiroCriticoPombo -Geral.PROBABILIDADE_TIRO_CRITICOINICIAL)/10];
               Geral.pombo.probabilidadeTiroCriticoPombo += 10; 
               this.atualizarMenu(); 
            } 
            //Botao voltar
        }else if(Greenfoot.mouseClicked(evoluir[20])){
            Botao.somAoClicar.play();
            Greenfoot.setWorld(new MenuFase());
        }
    }
    
    public void atualizarMenu(){
        
        //Se o status estiver no maximo... retira o custo e o (+) da tela
        if(Geral.pombo.velocidadePombo >= Geral.VELOCIDADEMAX){
            removeObject(evoluir[15]);
            removeObject(evoluir[10]);
        }if(Geral.pombo.ataquePombo >= Geral.ATAQUEMAX ){
            removeObject(evoluir[16]);
            removeObject(evoluir[11]);
        }if(Geral.pombo.resistenciaPombo >= Geral.RESISTENCIAMAX ){
            removeObject(evoluir[17]);
            removeObject(evoluir[12]);
        }if(Geral.pombo.maxTirosPombo >= Geral.MAXTIROSMAX ){
            removeObject(evoluir[18]);
            removeObject(evoluir[13]);
        }if(Geral.pombo.probabilidadeTiroCriticoPombo >= Geral.PROBABILIDADE_TIRO_CRITICOMAX ){
            removeObject(evoluir[19]);
            removeObject(evoluir[14]);
        }
         
        //Atuliza o custo e os status
        evoluir[5].setImage((new BotaoMenuShop(Integer.toString(Geral.pombo.velocidadePombo), 19, 50)).getImage());
        evoluir[6].setImage((new BotaoMenuShop(Integer.toString(Geral.pombo.ataquePombo), 19, 50)).getImage());
        evoluir[7].setImage((new BotaoMenuShop(Integer.toString(Geral.pombo.resistenciaPombo), 19, 50)).getImage());
        evoluir[8].setImage((new BotaoMenuShop(Integer.toString(Geral.pombo.maxTirosPombo), 19, 50)).getImage());
        evoluir[9].setImage((new BotaoMenuShop(Integer.toString(Geral.pombo.probabilidadeTiroCriticoPombo), 13, 50)).getImage());
        
        evoluir[10].setImage((new BotaoMenuShop(Integer.toString(Geral.velocidadeCusto[Geral.pombo.velocidadePombo - Geral.VELOCIDADEINICIAL]), 18, 80)).getImage());
        evoluir[11].setImage((new BotaoMenuShop(Integer.toString(Geral.ataqueCusto[Geral.pombo.ataquePombo - Geral.ATAQUEINICIAL]), 18, 80)).getImage());
        evoluir[12].setImage((new BotaoMenuShop(Integer.toString(Geral.resistenciaCusto[Geral.pombo.resistenciaPombo - Geral.RESISTENCIAINICIAL]), 18, 80)).getImage());
        evoluir[13].setImage((new BotaoMenuShop(Integer.toString(Geral.maxTirosCusto[Geral.pombo.maxTirosPombo - Geral.MAXTIROSINICIAL]), 18, 80)).getImage());
        evoluir[14].setImage((new BotaoMenuShop(Integer.toString(Geral.probabilidadeTiroCriticoCusto[(Geral.pombo.probabilidadeTiroCriticoPombo -Geral.PROBABILIDADE_TIRO_CRITICOINICIAL)/10]), 18, 80)).getImage());
        
        //atualiza os pontos na tela
        this.colocaPontosNaTela();
    }
    
    public void colocaPontosNaTela(){
        pontos1 = new GreenfootImage(150, 32);
        corTexto1 = new Color(0,0,0,200);
        
        Color cor = new Color(255,255,255, 100);
        pontos1.setColor(cor);
        
        pontos1.fill();
        pontos1.setColor(corTexto1);
        pontos1.setFont(new Font("sanserif", Font.BOLD, 25));
        pontos1.drawString(Integer.toString(Geral.pombo.pontosPombo), 5, 25);
        pontuacao1.setImage(pontos1);      
        
    }
}
