package quake.parser;
import java.io.IOException;
import java.util.List;
import quake.Jogos;
import quake.quakelogtxt.criar;

public class App {
    public static void main( String[] args ) throws IOException {
        List<Jogos> jogo = logparse.parse("games.log");
		criar.criarLogParser(jogo);
		
    }


}
