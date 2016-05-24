package Strategy;

public class Cash implements ModDepunere{

	//la depunere cash nu se percepe taxa
	@Override
	public float obtineSuma(float suma) {
		return suma;
	}

}
