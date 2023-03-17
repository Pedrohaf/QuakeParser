package quake.procuarajogo;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import quake.Jogos;


public class procura {
    public static void apiProcurar(List<Jogos> jogo, int x) throws IOException{
        int n = x;
        int cout = 0;
        for (Jogos game : jogo){
            cout++;
            if(cout == n){
                System.out.println(game.toString());
            }
        }
        

    } 
    
    
}

