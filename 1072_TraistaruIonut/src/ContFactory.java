
public class ContFactory {
	
	public Cont creareCont(TipCont tipCont,int id) {
		
		Cont cont = null;
		
		switch(tipCont) {
		case CONTCREDIT:
			cont = new ContCredit(id);
			break;
		case CONTDEBIT:
			cont = new ContDebit(id);
			break;
		}
		return cont;
	}
	
}
