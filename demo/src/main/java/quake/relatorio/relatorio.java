package quake.relatorio;


import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


import quake.Jogos;



public class relatorio {
    public static void relarorio(List<Jogos> jogo) throws IOException{
        Map<String, Integer> jMap = new HashMap<String, Integer>();
        for (Jogos game : jogo){
          System.out.println(game.toString());
          for ( Map.Entry<String, Integer> entry : game.getMortesJogador().entrySet() ) {
                if ( !jMap.containsKey( entry.getKey() ) )
                    jMap.put( entry.getKey(), entry.getValue() );
                else
                    jMap.put( entry.getKey(), jMap.get( entry.getKey() ) + entry.getValue() );
            }
        }
        Map<String, Integer> maiorjMap = rankingDeKillsPorJogador( jMap );
        System.out.println("ranking geral de kills por jogador. \n" + maiorjMap.toString() );

    } 
    
    private static Map<String, Integer> rankingDeKillsPorJogador( Map<String, Integer> unsortMap ) {
		List<Map.Entry<String, Integer>> vet = new LinkedList<Map.Entry<String, Integer>>( unsortMap.entrySet() );
		Collections.sort( vet, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare( Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2 ) {
				return ( o2.getValue() ).compareTo( o1.getValue() );
			}
		} );
		Map<String, Integer> rMap = new LinkedHashMap<String, Integer>();
		for ( Iterator<Map.Entry<String, Integer>> it = vet.iterator(); it.hasNext(); ) {
			Map.Entry<String, Integer> entry = it.next();
			rMap.put( entry.getKey(), entry.getValue() );
		}
		return rMap;
	}
}	



		
