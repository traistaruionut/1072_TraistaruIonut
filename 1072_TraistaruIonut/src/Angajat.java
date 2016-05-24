import java.util.ArrayList;
import java.util.List;

public class Angajat {
	
	String nume;
	
	public Angajat(String nume) {
		this.nume = nume;
	}
	
	public void realizeazaDepunere(Cont cont,float suma) {
		System.out.println("Angajatul : "+this.nume+" depune "+suma+" in contul: "+cont);
		cont.depuneNumerar(suma);
		
	}
	
	public void realizeazaRetragere(Cont cont,float suma) {
		System.out.println("Angajatul : "+this.nume+" retrage "+suma+" din contul: "+cont);
		cont.retrageSuma(suma);
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}
}
