package quake.parser;
import java.io.IOException;
import java.util.List;
import quake.Jogos;
import quake.quakelogtxt.criar;
import quake.relatorio.relatorio;
import quake.procuarajogo.procura;
public class App {
    public static int n; 
    public static void main( String[] args ) throws IOException {
        List<Jogos> jogo = logparse.parse("games.log");
        
		criar.criarLogParser(jogo);
        System.out.println("bem vindo ao Log do Quake 3 arena: \n");
        System.out.println("Escolha uma opão a baixo \n");
        System.out.println("1 apra ver o relatorio do jogo \n");
        System.out.println("2 para procurar um Game especifico \n");
        
        relatorio.relarorio(jogo);
		procura.apiProcurar(jogo, n);

        
    }


}
