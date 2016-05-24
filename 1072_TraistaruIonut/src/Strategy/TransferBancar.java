package Strategy;

public class TransferBancar implements ModDepunere{
	
	//la depunere prin transfer bancar percep taxa de 0.05
	@Override
	public float obtineSuma(float suma) {
		return (float) (suma*0.95);
	}

}
