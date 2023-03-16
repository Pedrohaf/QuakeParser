package quake.quakelogtxt;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import quake.Jogos;

public class criar {
    public static void criarLogParser( List<Jogos> jogo ) throws IOException {
		BufferedWriter writer = null;
		try {
			File logParser = new File( "jogos quake 3 arena" +".txt" );
			writer = new BufferedWriter( new FileWriter( logParser ) );
			for ( Jogos game : jogo ) {
				StringBuilder jogadoBuilder = new StringBuilder();
				StringBuilder morStringBuilder = new StringBuilder();
				for ( Map.Entry<String, Integer> entry : game.getMortesJogador().entrySet() ) {
					jogadoBuilder.append( "\"" + entry.getKey() + "\", " );
					morStringBuilder.append( "\t\t\"" + entry.getKey() + "\": " + entry.getValue() + ",\n" );
				}
				String players = jogadoBuilder.substring( 0, jogadoBuilder.length() - 2 );
				String kills = morStringBuilder.substring( 0, morStringBuilder.length() - 2 );
				writer.write( game.getNome() + ": {\n\t total_kills: " + game.getTotalMortes() + "\n\t players: [" + players + "]" + "\n\t kills: {\n" + kills + "\n\t}" + "\n}" );
				writer.newLine();
			}
		} catch ( Exception e ) {
			e.printStackTrace();
		} finally {
			writer.close();
		}
	}
}
