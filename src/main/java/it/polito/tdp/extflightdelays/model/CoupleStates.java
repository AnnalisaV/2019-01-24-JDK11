package it.polito.tdp.extflightdelays.model;

public class CoupleStates {

	private String state1; 
	private String state2; 
	private int peso; //numero velivoli
	
	/**
	 * @param state1
	 * @param state2
	 * @param peso
	 */
	public CoupleStates(String state1, String state2, int peso) {
		super();
		this.state1 = state1;
		this.state2 = state2;
		this.peso = peso;
	}

	public String getState1() {
		return state1;
	}

	public String getState2() {
		return state2;
	}

	public int getPeso() {
		return peso;
	}
	
	
}
