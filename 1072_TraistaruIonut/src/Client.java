import java.util.ArrayList;

import Strategy.ModDepunere;

public class Client {
	int id;
	String nume;
	String prenume;
	String telefon;
	ContCredit contCredit;
	ContDebit contDebit;
	ArrayList<OperatieCont> listaOperatiiCredit;
	ArrayList<OperatieCont> listaOperatiiDebit;
	static ContFactory contFactory = new ContFactory();
	
	private Client() {
		this.listaOperatiiCredit = new ArrayList<OperatieCont>();
		this.listaOperatiiDebit = new ArrayList<OperatieCont>();
	}
	
	public void adaugaOperatieCredit(OperatieCont operatieCredit) {
		this.listaOperatiiCredit.add(operatieCredit);
	}
	
	public void trimiteOperatiiCredit() {
		for(OperatieCont oc : listaOperatiiCredit) {
			oc.executa(this.contCredit);
		}
	}
	
	public void adaugaOperatieDebit(OperatieCont operatieDebit) {
		this.listaOperatiiDebit.add(operatieDebit);
	}
	
	public void trimiteOperatiiDebit() {
		for(OperatieCont oc : listaOperatiiDebit)
			oc.executa(this.contDebit);
	}
	
	public int getId() {
		return id;
	}

	public String getNume() {
		return nume;
	}

	public String getPrenume() {
		return prenume;
	}

	public String getTelefon() {
		return telefon;
	}

	public ContCredit getContCredit() {
		return contCredit;
	}

	public ContDebit getContDebit() {
		return contDebit;
	}
	

	public void setContCredit(ContCredit contCredit) {
		this.contCredit = contCredit;
	}

	public void setContDebit(ContDebit contDebit) {
		this.contDebit = contDebit;
	}
	
	public void setModDepunereContCredit(ModDepunere modDepunere) {
		this.getContCredit().setModDepunere(modDepunere);
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", nume=" + nume + ", prenume=" + prenume + ", telefon=" + telefon + ", contCredit="
				+ contCredit + ", contDebit=" + contDebit + "]";
	}


	public static class BuilderClient{
		Client client;
		
		public BuilderClient(int id,String nume,String prenume) {
			this.client = new Client();
			this.client.id = id;
			this.client.nume = nume;
			this.client.prenume = prenume;
		}
		
		public BuilderClient adaugaTelefon(String telefon) {
			this.client.telefon = telefon;
			return this;
		}
		
		public BuilderClient adaugaContCredit() {
			this.client.setContCredit((ContCredit) contFactory.creareCont(TipCont.CONTCREDIT, this.client.id));
			return this;
		}
		
		public BuilderClient adaugaContDebit() {
			this.client.setContDebit((ContDebit) contFactory.creareCont(TipCont.CONTDEBIT, this.client.id));
			return this;
		}
		
		public Client build() {
			return this.client;
		}
	}
}
