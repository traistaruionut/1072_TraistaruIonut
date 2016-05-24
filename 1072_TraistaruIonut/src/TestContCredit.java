import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.*;

import Strategy.Cash;
import Strategy.ModDepunere;

public class TestContCredit {
	
	private final static int CONTCREDIT_ID = 1;
	ContCredit contCredit;
	ModDepunere modDepunere;
	
	@Before
	public void initializare() {
		this.contCredit = new ContCredit(CONTCREDIT_ID);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testContCreditNotNULL() {
		Assert.assertNotNull(contCredit);
	}
	
	@Test
	public void testSetSuma() {
		float valoareAsteptata = 1;
		float valoareInput = 1;
		contCredit.setSuma(valoareInput);
		
//		Assert.assertEquals(valoareAsteptata,contCredit.getSuma(), 0);
		
		//am ales aceasta implementare datorita faptului ca metoda
		//assertEquals pentru float este deprecated
		if(valoareAsteptata!=contCredit.getSuma()) {
			fail("Valoarea nu este cea asteptata");
		}
	}
	
	@Test
	public void depuneSumaValoriNormale() {
		this.contCredit.modDepunere = new Cash();
		float sumaDepunere = 1;
		float valoareAsteptata = contCredit.modDepunere.obtineSuma(sumaDepunere);
		contCredit.depuneSuma(sumaDepunere);
		float sumaCont = contCredit.getSuma();
		Assert.assertEquals(valoareAsteptata, sumaCont, 0);
	}
	
	@Test
	public void depuneSumaValoareZero() {
		this.contCredit.modDepunere = new Cash();
		float sumaDepunere = 0;
		float valoareAsteptata = contCredit.modDepunere.obtineSuma(sumaDepunere);
		contCredit.depuneSuma(sumaDepunere);
		float sumaCont = contCredit.getSuma();
		Assert.assertEquals(valoareAsteptata, sumaCont, 0);
	}
	
	@Test
	public void depuneSumaValoareNegative() {
		this.contCredit.modDepunere = new Cash();
		float sumaDepunere = -36;
		float valoareAsteptata = contCredit.modDepunere.obtineSuma(sumaDepunere);
		contCredit.depuneSuma(sumaDepunere);
		float sumaCont = contCredit.getSuma();
		Assert.assertEquals(valoareAsteptata, sumaCont, 0);
	}
	
	@Test
	public void depuneSumaMaxFloat() {
		this.contCredit.modDepunere = new Cash();
		float sumaDepunere = Float.MAX_VALUE;
		float valoareAsteptata = contCredit.modDepunere.obtineSuma(sumaDepunere);
		contCredit.depuneSuma(sumaDepunere);
		float sumaCont = contCredit.getSuma();
		Assert.assertEquals(valoareAsteptata, sumaCont, 0);
	}
	
	
	
}
