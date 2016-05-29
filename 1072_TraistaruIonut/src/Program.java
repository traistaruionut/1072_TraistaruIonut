import Proxy.ProxyCash;
import Strategy.Cash;
import Strategy.ModDepunere;
import Strategy.TransferBancar;

public class Program {
	private static final String OPERATIE_DEPUNERE = "depunere";
	private static final String OPERATIE_RETRAGERE = "retragere";
	
	public static void main(String[] args) {
		
		Banca banca = Banca.getInstance();		
		Angajat angajat = new Angajat("angajat1");
		
		Client client1 = new Client.BuilderClient(1, "first", "client")
				.adaugaTelefon("07231111")
				.adaugaContCredit()
				.adaugaContDebit()
				.build();
		client1.setModDepunereContCredit(new TransferBancar());
		
		Client client2 = new Client.BuilderClient(2, "second", "client")
				.adaugaTelefon("072322222")
				.adaugaContCredit()
				.adaugaContDebit()
				.build();
		client2.setModDepunereContCredit(new Cash());
		
		banca.adaugaAngajat(angajat);
		banca.adaugaClient(client1);
		banca.adaugaClient(client2);
		
		ModDepunere modDepunereCash = new ProxyCash();
		modDepunereCash.obtineSuma(2);
		
		InterfataSimplificata interfataSimplificata = new InterfataSimplificata(client1, angajat);
		interfataSimplificata.realizeazaOperatie(TipCont.CONTCREDIT, OPERATIE_DEPUNERE, 1);
		interfataSimplificata.realizeazaOperatie(TipCont.CONTCREDIT, OPERATIE_RETRAGERE, 1);
		client1.trimiteOperatiiCredit();
		
		InterfataSimplificata interfataSimplificata2 = new InterfataSimplificata(client2, angajat);
		interfataSimplificata2.realizeazaOperatie(TipCont.CONTCREDIT, OPERATIE_DEPUNERE, 2);
		interfataSimplificata2.realizeazaOperatie(TipCont.CONTCREDIT, OPERATIE_RETRAGERE, 2);
		client2.trimiteOperatiiCredit();
		
		System.out.println(client1.toString());
		System.out.println(client2.toString());
	}
}
