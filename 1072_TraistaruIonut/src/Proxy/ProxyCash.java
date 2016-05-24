package Proxy;

import Strategy.Cash;
import Strategy.ModDepunere;

public class ProxyCash implements ModDepunere{
	
	private Cash cash;
	
	@Override
	public float obtineSuma(float suma) {
		
		if(this.cash == null) {
			cash = new Cash();
		}
		float rezultat = cash.obtineSuma(suma);
		System.out.println("~~Prelucrari prin intermediul Proxy: "+rezultat);
		return rezultat;
	}

}
