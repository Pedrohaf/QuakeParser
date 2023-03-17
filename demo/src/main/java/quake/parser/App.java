package quake.parser;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import quake.Jogos;
import quake.quakelogtxt.criar;
import quake.relatorio.relatorio;
import quake.procuarajogo.procura;
public class App {
    public static int n = 0; 
    public static void main( String[] args ) throws IOException {
        List<Jogos> jogo = logparse.parse("games.log");
        int opc ;
        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
		criar.criarLogParser(jogo);
        System.out.println("bem vindo ao Log do Quake 3 arena: \n");
        System.out.println("Escolha uma opão a baixo \n");
        System.out.println("1 apra ver o relatorio do jogo \n");
        System.out.println("2 para procurar um Game especifico \n");
        opc = scan.nextInt();
        if(opc == 1){
            relatorio.relarorio(jogo);
        }
        else if(opc == 2){
            System.out.println("voce possui 21 games, Qual você deseja ver. Digite um numero de 1 a 21");
            n = scan2.nextInt();
            System.out.println("\n");
            procura.apiProcurar(jogo, n);
        } 
       

		

        
    }



    


}
