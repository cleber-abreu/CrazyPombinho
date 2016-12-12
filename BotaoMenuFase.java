import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;

public class BotaoMenuFase extends Botao
{
    private GreenfootSound somAoClicar;
	private GreenfootImage imagemBotaoMenuFase;
    
    //Botao do menu de fases
    public BotaoMenuFase(String texto, int distancia)
    {
        corDentro = new Color(0,0,0);
        corBorda = new Color(140,230,60);
        corTexto = new Color(140,230,60);
        
        margem = 5;
        larguraBotao = 210;
        alturaBotao = 50; 
        
        fonteBotao = new Font("sanserif",Font.BOLD,25);
		
		imagemBotaoMenuFase = getImage();
        imagemBotaoMenuFase.setColor(corBorda);
        imagemBotaoMenuFase.fill();
        imagemBotaoMenuFase.scale(larguraBotao, alturaBotao);
        imagemBotaoMenuFase.setColor(corDentro);
        int largura = imagemBotaoMenuFase.getWidth() - 2 * margem;
        int altura = imagemBotaoMenuFase.getHeight() - 2 * margem;
        imagemBotaoMenuFase.fillRect(margem, margem, largura, altura);
		
		imagemBotaoMenuFase.setColor(corTexto);
        imagemBotaoMenuFase.setFont(fonteBotao);
        imagemBotaoMenuFase.drawString(texto, distancia, 35);
		
    }  

   
}
