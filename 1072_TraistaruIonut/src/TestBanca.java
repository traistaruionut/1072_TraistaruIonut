import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestBanca {
	
	Banca banca;
	Angajat angajat;
	Client client;
	
	@Before
	public void initializare() {
		this.banca = Banca.getInstance();
		this.angajat = new Angajat("angajatTest");
		client = new Client.BuilderClient(1, "first", "client")
				.adaugaTelefon("07231111")
				.adaugaContCredit()
				.adaugaContDebit()
				.build();
	}
	
	@Test
	public void testBancaNull() {
		Assert.assertNotNull("testBancaNull -- Valoarea asteptata != null",banca);
	}
	
	//verifica daca un angajat este adaugat in listaAngajatilor
	@Test
	public void verificareAdaugareAngajat() {
		int numarAngajati = this.banca.getListaAngajati().size();
		this.banca.adaugaAngajat(angajat);
		int valoareTestata = this.banca.getListaAngajati().size();
		
		if(numarAngajati==valoareTestata) {
			fail("\tERR-angajatul nu a fost adaugat in lista");
		}
	}
	
	//verific daca ultimul obiect adaugat in lista este cel dorit
	@Test
	public void verificaAngajatAdaugat() {
		this.banca.adaugaAngajat(angajat);
		ArrayList<Angajat> listaAngajati = this.banca.getListaAngajati();
		Assert.assertEquals("Ultimul angajat adaugat nu este cel asteptat",this.angajat, listaAngajati.get(listaAngajati.size()-1));
	}
	
	//verificare prin intermediul numarului elementelor prezente in arraylist
	@Test
	public void verificaStergereAngajat() {
		
		Angajat angajat1 = new Angajat("deSters");
		banca.adaugaAngajat(angajat1);
		int numarAngajati = this.banca.getListaAngajati().size();
		banca.stergeAngajat(angajat1);
		int valoareTestata = this.banca.getListaAngajati().size();
		
		Assert.assertNotEquals("Valorile sunt egale!!",numarAngajati,valoareTestata);
	}
	
	//verific daca un client este adaugat in listaClienti
	@Test
	public void verificareAdaugareClient() {
		int numarClienti = this.banca.getListaClienti().size();
		this.banca.adaugaClient(client);
		int valoareTestata = this.banca.getListaClienti().size();
		Assert.assertNotEquals("verificareAdaugareClient() Valorile sunt egale!!",numarClienti,valoareTestata);
	}
	
	//verific daca ultimul client adaugat in lista este cel dorit
	@Test
	public void verificareClientAdaugat() {
		this.banca.adaugaClient(client);
		ArrayList<Client> listaClienti = this.banca.getListaClienti();
		Assert.assertEquals("Ultimul client adaugat nu este cel asteptat",this.client, listaClienti.get(listaClienti.size()-1));
	}
	
	//verificare stergere din listaClienti
	@Test
	public void verificaStergereClient() {
		Client client2 = new Client.BuilderClient(2, "second", "client")
				.adaugaTelefon("07231111")
				.adaugaContCredit()
				.adaugaContDebit()
				.build();
		banca.adaugaClient(client2);
		int numarClienti = this.banca.getListaClienti().size();
		banca.stergeClient(client2);
		int valoareTestata = this.banca.getListaClienti().size();
		Assert.assertNotEquals("verificaStergereClient() Valorile sunt egale!!",numarClienti,valoareTestata);
	}
	
}
