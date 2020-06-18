package it.polito.tdp.extflightdelays.model;

public class StateAndNumber implements Comparable<StateAndNumber>{

	private String state; 
	private Integer peso;
	
	/**
	 * @param state
	 * @param peso
	 */
	public StateAndNumber(String state, int peso) {
		super();
		this.state = state;
		this.peso = peso;
	}

	public String getState() {
		return state;
	}

	public int getPeso() {
		return peso;
	}

	//peso decrescente
	@Override
	public int compareTo(StateAndNumber o) {
		
		return o.peso.compareTo(this.peso);
	}

	@Override
	public String toString() {
		return this.state+" "+this.getPeso();
	} 
	
	
	
}
