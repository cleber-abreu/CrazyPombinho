import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;
/**
 * Botoes do menu principal
 */
public class BotaoMenuPrincipal extends Botao
{
	private GreenfootImage imagemBotaoMenuPrincipal;
    
    public BotaoMenuPrincipal(String texto, int distancia)
    {
        
        corDentro = new Color(0,0,0);
        corBorda = new Color(140,230,60);
        corTexto = new Color(140,230,60);
        
        margem = 5;
        larguraBotao = 210;
        alturaBotao = 50; 
        
        fonteBotao = new Font("sanserif",Font.BOLD,25);
		
		imagemBotaoMenuPrincipal = getImage();
        imagemBotaoMenuPrincipal.setColor(corBorda);
        imagemBotaoMenuPrincipal.fill();
        imagemBotaoMenuPrincipal.scale(larguraBotao, alturaBotao);
        imagemBotaoMenuPrincipal.setColor(corDentro);
        int largura = imagemBotaoMenuPrincipal.getWidth() - 2 * margem;
        int altura = imagemBotaoMenuPrincipal.getHeight() - 2 * margem;
        imagemBotaoMenuPrincipal.fillRect(margem, margem, largura, altura);
		
		imagemBotaoMenuPrincipal.setColor(corTexto);
        imagemBotaoMenuPrincipal.setFont(fonteBotao);
        imagemBotaoMenuPrincipal.drawString(texto, distancia, 35);
    }  

}
