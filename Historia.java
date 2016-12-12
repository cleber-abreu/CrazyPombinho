import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Conta Historia do jogo
 */
public class Historia extends Cenario
{

    Botao voltar;
    public Historia()
    {    
        super(Geral.LARGURADATELA, Geral.ALTURADATELA);
        voltar = new BotaoMenuShop("Voltar", 25, 110);
        
        addObject(voltar, 690, 455);
    }
    
    public void act(){
        if(Greenfoot.mouseClicked(voltar)){
           Botao.somAoClicar.play();
           Greenfoot.setWorld(new MenuFase());
            
        }
        
    }
}
