

public class OperatieDepunere implements OperatieCont {
	
	public Angajat angajat;
	public Cont cont;
	float suma;
	
	public OperatieDepunere(Angajat angajat,Cont cont,float suma) {
		this.angajat = angajat;
		this.suma = suma;
		this.cont = cont;
	}
	
	@Override
	public void executa(Cont cont) {
		angajat.realizeazaDepunere(this.cont, this.suma);
	}

}
