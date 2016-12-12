import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class SalvarArquivo {
    
    
    final File ARQUIVO;
    SalvarArquivo(String caminho){
        this.ARQUIVO = new File(caminho);
    }
        
    //  *************** Ler e Gravar Arquivo
    public ArrayList<Integer> lerArquivo(){
        Scanner scan = null;
        ArrayList<Integer> retorno = new ArrayList<Integer>();
        
        try{
            this.criarArquivo();
            
            scan = new Scanner(this.ARQUIVO);
            
            while(scan.hasNext()){
                retorno.add(scan.nextInt());
            }

        }catch(Exception e){
        }finally{
            if(scan != null){
                scan.close();
            }
        }
        return retorno;
        
        
    }
    
    public void gravarArquivo(ArrayList<Integer> escrever){
        PrintWriter writer = null;
        try{
            this.criarArquivo();
            
            writer = new PrintWriter(ARQUIVO);
            
            for (Integer str : escrever) {
                writer.println(str);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(writer != null){
                writer.close();
            }
        }
    }
    
    public void criarArquivo(){
        try{
            if(!ARQUIVO.exists()){
                //pasta.mkdirs();
                ARQUIVO.createNewFile();
                this.gravarArquivo(new ArrayList<Integer>(){{
                    add(Geral.VELOCIDADEINICIAL);
                    add(Geral.ATAQUEINICIAL);
                    add(Geral.RESISTENCIAINICIAL);
                    add(Geral.MAXTIROSINICIAL);
                    add(Geral.PROBABILIDADE_TIRO_CRITICOINICIAL);
                    add(Geral.PONTOSINICIAL);
                   
                }});
            }
        }catch(Exception e){
            
        }
    }



}
