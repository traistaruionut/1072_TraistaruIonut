import java.util.ArrayList;

public class Banca {
	ArrayList<Angajat> listaAngajati;
	ArrayList<Client> listaClienti;
	private static Banca instanta = null;
	
	private Banca() {
		this.listaAngajati = new ArrayList<Angajat>();
		this.listaClienti = new ArrayList<Client>();
	}
	
	public static Banca getInstance() {
		if(instanta==null) {
			return new Banca();
		}
		return instanta;
	}
	
	public void adaugaAngajat(Angajat angajat) {
		if(angajat!=null && !angajat.getNume().equalsIgnoreCase("")) {
			listaAngajati.add(angajat);
		}else {
			System.out.println("\tERR: Angajatul nu a fost introdus in sistem!");
		}
	}
	
	public void stergeAngajat(Angajat angajat) {
		if(listaAngajati.size()>0 && angajat!=null && !angajat.getNume().equalsIgnoreCase("")) {
			listaAngajati.remove(angajat);
		}else {
			System.out.println("\tERR: Angajatul nu a putut fi sters din sistem!");
		}
	}
	
	public void adaugaClient(Client client) {
		if(client!=null && !client.getNume().equalsIgnoreCase("")){
			listaClienti.add(client);
		}else {
			System.out.println("\tERR: Clientul nu a putut fi introdus in sistem!");
		}
	}
	
	public void stergeClient(Client client) {
		if(listaClienti.size()>0 && client!=null && !client.getNume().equalsIgnoreCase("")) {
			listaClienti.remove(client);
		}else {
			System.out.println("\tERR: Clientul nu a putut fi sters din sistem!");
		}
	}

	public ArrayList<Angajat> getListaAngajati() {
		return listaAngajati;
	}

	public void setListaAngajati(ArrayList<Angajat> listaAngajati) {
		this.listaAngajati = listaAngajati;
	}

	public ArrayList<Client> getListaClienti() {
		return listaClienti;
	}

	public void setListaClienti(ArrayList<Client> listaClienti) {
		this.listaClienti = listaClienti;
	}
	
}
