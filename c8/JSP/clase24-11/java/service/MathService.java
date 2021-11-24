package service;

public class MathService {
	
	public String[] getNames() {
		String[] a = {"pepsi","guaymallen","jugo","chupetin"};
		return a;
	}
	
	public int cuadrado(int n){
		return n*n;
	}

	public double porcentaje(int n, double p){
		return (n*p) / 100;	
	}
}
