import Strategy.ModDepunere;

public class ContDebit extends Cont{

	protected int id;
	protected float suma;
	ModDepunere modDepunere;
	
	public ContDebit(int id) {
		this.id = id;
	}
	
	@Override
	public void print() {
		System.out.println("Contul de debit cu ID: "+this.id+" si suma: "+this.suma);
	}

	@Override
	public void depuneSuma(float suma) {
		if(suma>0) {
			this.suma += modDepunere.obtineSuma(suma);
			System.out.println("Au fost depusi in contul "+this.id+" RON"+this.suma);
		}
	}

	@Override
	public void retrageSuma(float suma) {
		if(this.suma<suma || suma<0) {
			System.out.println("!!!Suma pe care doriti sa o retrageti este mai mare decat suma din cont");
		}else {
			this.suma -= suma;
		}
	}

	public ModDepunere getModDepunere() {
		return modDepunere;
	}

	public void setModDepunere(ModDepunere modDepunere) {
		this.modDepunere = modDepunere;
	}

	@Override
	public String toString() {
		return "ContDebit [id=" + id + ", suma=" + suma + "]";
	}

	@Override
	public void verificareCont() {
		System.out.println("!!!Proces verificare cont debit!!!");
	}

	@Override
	public void verificareSold() {
		System.out.println("!!!Proces verificare suma sold cont debit!!!");
	}
	
}
