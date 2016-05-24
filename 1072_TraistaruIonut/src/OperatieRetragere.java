
//retrage numerar din cont
public class OperatieRetragere implements OperatieCont{
	
	Angajat angajat;
	Cont cont;
	float suma;
	
	public OperatieRetragere(Angajat angajat,Cont cont,float suma) {
		this.angajat = angajat;
		this.suma = suma;
		this.cont = cont;
	}
	
	@Override
	public void executa(Cont cont) {
		angajat.realizeazaRetragere(this.cont, this.suma);
	}

}
