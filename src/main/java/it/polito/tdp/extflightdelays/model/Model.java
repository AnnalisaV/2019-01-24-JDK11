package it.polito.tdp.extflightdelays.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultDirectedWeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

import it.polito.tdp.extflightdelays.db.ExtFlightDelaysDAO;

public class Model {

	private ExtFlightDelaysDAO dao; 
	private Graph<String, DefaultWeightedEdge> graph; 
	
	public Model() {
		this.dao= new ExtFlightDelaysDAO(); 
		
	}
	
	public void creaGrafo() {
		this.graph= new DefaultDirectedWeightedGraph<>(DefaultWeightedEdge.class); //devo fare un loop (voli cappio del testo)
		
		//vertex
		Graphs.addAllVertices(this.graph, this.dao.loadAllStates()); 
		
		//edges
		for (CoupleStates c : this.dao.getCouples()) {
			// essendo orientato non mi chiedo nulla, aggiungo
			Graphs.addEdge(this.graph, c.getState1(), c.getState2(), c.getPeso()); 
		}
		
		System.out.println("Grafo con : "+this.graph.vertexSet().size()+" vertex and "+this.graph.edgeSet().size()+" edges\n");
		
	}
	
	public List<String> getVertex(){
		List<String> lista= new ArrayList<>(this.graph.vertexSet());
		lista.sort(null); //automatico in alfabetico come nel modo naturale delle String
		return lista; 
		
	}
	
	public List<StateAndNumber> getCollegati(String state){
		List<StateAndNumber> lista= new ArrayList<>(); 
		
		for (String s : Graphs.successorListOf(this.graph, state)) {
			int velivoli=(int) graph.getEdgeWeight(graph.getEdge(state, s)); 
		
			lista.add(new StateAndNumber(s, velivoli)); 
			
		}
		Collections.sort(lista);
		return lista; 
	}
}
