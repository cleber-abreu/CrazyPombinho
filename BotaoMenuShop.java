import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;

public class BotaoMenuShop extends Botao
{
    private GreenfootSound somAoClicar;
	private GreenfootImage imagemBotaoMenuShop;
    
	/* Botoes do menu shop
	 * 
	 */
    
    public BotaoMenuShop(String texto, int distancia, int larguraBotao)
    {
        corDentro = new Color(0,0,0);
        corBorda = new Color(140,230,60);
        corTexto = new Color(140,230,60);
        
        margem = 3;
        this.larguraBotao = larguraBotao;
        alturaBotao = 40; 
        
        fonteBotao = new Font("sanserif",Font.BOLD,20);
		
		imagemBotaoMenuShop = getImage();
        imagemBotaoMenuShop.setColor(corBorda);
        imagemBotaoMenuShop.fill();
        imagemBotaoMenuShop.scale(larguraBotao, alturaBotao);
        imagemBotaoMenuShop.setColor(corDentro);
        int largura = imagemBotaoMenuShop.getWidth() - 2 * margem;
        int altura = imagemBotaoMenuShop.getHeight() - 2 * margem;
        imagemBotaoMenuShop.fillRect(margem, margem, largura, altura);
		
		imagemBotaoMenuShop.setColor(corTexto);
        imagemBotaoMenuShop.setFont(fonteBotao);
        imagemBotaoMenuShop.drawString(texto, distancia, 28);
		
    }  

   
}
