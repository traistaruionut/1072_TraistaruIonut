
public abstract class Cont {
	public abstract void print();
	public abstract void depuneSuma(float suma);
	public abstract void retrageSuma(float suma);
	public abstract void verificareCont();
	public abstract void verificareSold();
	
	public void depuneNumerar(float suma) {
		verificareCont();
		verificareSold();
		depuneSuma(suma);
	}
	
	public void retrageNumerar(float suma) {
		verificareCont();
		verificareSold();
		retrageSuma(suma);
	}
}
