package quake;

import java.util.Map;

public class Jogos {
    private String nome;
	private Integer totalMortes;
	private Map<String, Integer> mortesJogador;

    /**
     * @return String return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return Integer return the totalMortes
     */
    public Integer getTotalMortes() {
        return totalMortes;
    }

    /**
     * @param totalMortes the totalMortes to set
     */
    public void setTotalMortes(Integer totalMortes) {
        this.totalMortes = totalMortes;
    }

    /**
     * @return Map<String, Integer> return the mortesJogador
     */
    public Map<String, Integer> getMortesJogador() {
        return mortesJogador;
    }

    /**
     * @param mortesJogador the mortesJogador to set
     */
    public void setMortesJogador(Map<String, Integer> mortesJogador) {
        this.mortesJogador = mortesJogador;
    }

    @Override
	public String toString() {
		return "Relatorio do: " + "\n" + nome + "\n" + " Tiveram: " + totalMortes + " mortes" + "\n" + " e os jogadores tiveram " + mortesJogador + " em abates"+ "\n";
	}

}

