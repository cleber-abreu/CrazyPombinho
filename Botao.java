import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;

/**
 * Botao generico
 */
public class Botao extends Actor
{
    public static GreenfootSound somAoClicar = new GreenfootSound("botoes.mp3");
    
    protected Color corDentro;
    protected Color corBorda;
    protected Color corTexto;
    protected int alturaBotao;
    protected int larguraBotao;
    protected int margem;
    protected Font fonteBotao;
      
}
