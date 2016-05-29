
public class InterfataSimplificata {

	Client client;
	Angajat angajat;
	
	public InterfataSimplificata(Client client,Angajat angajat) {
		this.client = client;
		this.angajat = angajat;
	}
	
	public void realizeazaOperatie(TipCont tipCont,String tipOperatie,float suma) {
		OperatieDepunere operatieDepunere;
		OperatieRetragere operatieRetragere;
		if(tipOperatie.equalsIgnoreCase("depunere")) {
			if(tipCont == TipCont.CONTCREDIT) {
				operatieDepunere = new OperatieDepunere(angajat, client.getContCredit(), suma);
				client.adaugaOperatieCredit(operatieDepunere);
			}else {
				operatieDepunere = new OperatieDepunere(angajat, client.getContDebit(), suma);
				client.adaugaOperatieDebit(operatieDepunere);
			}
		}else if(tipOperatie.equalsIgnoreCase("retragere")) {
			if(tipCont == TipCont.CONTCREDIT) {
				operatieRetragere = new OperatieRetragere(angajat, client.getContCredit(), suma);
				client.adaugaOperatieCredit(operatieRetragere);
			}else {
				operatieRetragere = new OperatieRetragere(angajat, client.getContDebit(), suma);
				client.adaugaOperatieDebit(operatieRetragere);
			}
		}
	}
	
}
