import Strategy.ModDepunere;

public class ContCredit extends Cont {

	protected int id;
	protected float suma;
	ModDepunere modDepunere;

	public ContCredit(int id) {
		this.id = id;
		this.suma = 0;
	}

	public void setSuma(float suma) {
		this.suma = suma;
	}
	
	public float getSuma() {
		return this.suma;
	}

	@Override
	public void print() {
		System.out.println("Contul de credit cu ID: " + this.id + " si suma: " + this.suma);
	}

	@Override
	public void depuneSuma(float suma) {
		if (suma > 0) {
			this.suma += modDepunere.obtineSuma(suma);
			System.out.println("Au fost depusi in contul de Credit " + this.id + " RON" + this.suma);
		}
	}

	@Override
	public void retrageSuma(float suma) {
		if (suma > 0) {
			this.suma -= suma;
			if (this.suma < suma) {
				System.out.println("!!!Suma din cont este negativa!!(" + this.suma + ")");
			}
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
		return "ContCredit [id=" + id + ", suma=" + suma + "]";
	}

	@Override
	public void verificareCont() {
		System.out.println("!!!Proces verificare cont credit!!!");
	}

	@Override
	public void verificareSold() {
		System.out.println("!!!Proces verificare sold cont credit!!!");
	}

}
