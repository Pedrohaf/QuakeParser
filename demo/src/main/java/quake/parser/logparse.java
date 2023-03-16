package quake.parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import quake.Jogos;

public class logparse {
   public static List<Jogos> parse( String fileName ) throws IOException {
		
		BufferedReader br = new BufferedReader( new FileReader( fileName ) );
		Pattern joPattern = Pattern.compile( "(ClientUserinfoChanged)");
		java.util.regex.Matcher joMatcher = joPattern.matcher( "" );
		Pattern iPattern = Pattern.compile( "(InitGame)" );
		java.util.regex.Matcher iMatcher = iPattern.matcher( "" );
		Pattern fPattern = Pattern.compile( "(ShutdownGame)" );
		java.util.regex.Matcher fMatcher = fPattern.matcher( "" );
		Pattern mPattern = Pattern.compile( "(Kill)" );
		java.util.regex.Matcher matcher = mPattern.matcher( "" );
		
		int cont = 0;
		Map<String, Integer> mortesJogador = null;
		Integer totalMortes = null;
		String line;
		Jogos jogo = null;
		List<Jogos> jogos = new ArrayList<Jogos>();
		try {
			while ( ( line = br.readLine() ) != null ) {
				line = line.trim();
				matcher.reset( line );
				iMatcher.reset( line );
				fMatcher.reset( line );
				joMatcher.reset( line );

				if ( iMatcher.find() ) {
					cont++;
					if ( jogo != null && !jogos.contains( jogo ) ) {
						jogo.setTotalMortes(totalMortes);
						jogo.setMortesJogador(mortesJogador);
						jogos.add(jogo );
					}
					jogo = new Jogos();
					totalMortes = 0;
					mortesJogador = new HashMap<String, Integer>();
					jogo.setNome( "game_" + cont );

				} else if ( joMatcher.find() ) {
					String[] split = line.split( "\\\\" );
					if ( mortesJogador.get( split[1] ) == null )
						mortesJogador.put( split[1], 0 );

				} else if ( matcher.find() ) {
					totalMortes++;
					String[] split = line.split( "killed" );
					String[] splitPrimeiro = split[0].split( ":" );
					String[] splitSegundo = split[1].split( "by" );
					String primeiroj = splitPrimeiro[splitPrimeiro.length - 1].trim();
					String segundoj = splitSegundo[0].trim();
					if ( primeiroj.equalsIgnoreCase( MAPAS ) )
						mortesJogador.put( segundoj, mortesJogador.get( segundoj ).intValue() - 1 );
					else {
						mortesJogador.put( primeiroj, mortesJogador.get( primeiroj ).intValue() + 1 );
					}

				} else if ( fMatcher.find() ) {
					jogo.setTotalMortes(totalMortes);
					jogo.setMortesJogador(mortesJogador);
					jogos.add( jogo);
				}
			}

		} finally {
			br.close();
		}
		return jogos;
	}
    

	private static final String MAPAS = "<world>";
}
