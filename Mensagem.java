import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;


public class Mensagem extends Texto
{
    private GreenfootImage imagem;
    public Mensagem(String texto, int largJanela, int altJanela, int tamFonte, int distXTexto, int distYTexto){
        
       Font fonteBotao = new Font("sanserif",Font.BOLD,tamFonte);
       
       imagem = getImage();
       imagem.setColor(new Color(140,230,60));
       imagem.fill();
       imagem.scale(largJanela, altJanela);
       imagem.setColor(new Color(0,0,0));
       int largura = imagem.getWidth() - 10;
       int altura = imagem.getHeight() - 10;
       imagem.fillRect(5, 5, largura, altura);
        
       imagem.setColor(new Color(140,230,60));
       imagem.setFont(fonteBotao);
       imagem.drawString(texto, distXTexto, distYTexto);
    } 
}
