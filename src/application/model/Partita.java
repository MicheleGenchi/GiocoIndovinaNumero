package application.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Partita {
	private IntegerProperty numeroSegreto = new SimpleIntegerProperty();
	private IntegerProperty tentativoCorrente=new SimpleIntegerProperty();
	private IntegerProperty tentativo=new SimpleIntegerProperty();
	private BooleanProperty attiva=new SimpleBooleanProperty();
	private IntegerProperty ultimoTentativo=new SimpleIntegerProperty();
	
	public int getRisultato() {
		return Integer.compare(tentativo.get(), numeroSegreto.get());
	}

	public Partita() {
		setUltimoTentativo(10);
	}

	public void avvia() {
		setNumeroSegreto(generaNumeroCasuale(1, 100));
		setTentativoCorrente(0);
		setAttiva(true);
	}
	
	public void fine() {
		setTentativoCorrente(0);
		setTentativo(0);
		setAttiva(attiva.not().get());
	}
	
	private int generaNumeroCasuale(int i, int j) {
		// TODO Auto-generated method stub
		return (int) (Math.random() * 100) + 1;
	}

	public final IntegerProperty numeroSegretoProperty() {
		return this.numeroSegreto;
	}

	public final int getNumeroSegreto() {
		return this.numeroSegretoProperty().get();
	}

	public final void setNumeroSegreto(final int numeroSegreto) {
		this.numeroSegretoProperty().set(numeroSegreto);
	}

	public final IntegerProperty tentativoProperty() {
		return this.tentativo;
	}

	public final int getTentativo() {
		return this.tentativoProperty().get();
	}

	public final void setTentativo(final int tentativo) {
		this.tentativoProperty().set(tentativo);
	}

	public final BooleanProperty attivaProperty() {
		return this.attiva;
	}

	public final boolean isAttiva() {
		return this.attivaProperty().get();
	}

	public final void setAttiva(final boolean attiva) {
		this.attivaProperty().set(attiva);
	}

	public final IntegerProperty ultimoTentativoProperty() {
		return this.ultimoTentativo;
	}
	

	public final int getUltimoTentativo() {
		return this.ultimoTentativoProperty().get();
	}
	

	public final void setUltimoTentativo(final int ultimoTentativo) {
		this.ultimoTentativoProperty().set(ultimoTentativo);
	}

	public final IntegerProperty tentativoCorrenteProperty() {
		return this.tentativoCorrente;
	}
	

	public final int getTentativoCorrente() {
		return this.tentativoCorrenteProperty().get();
	}
	

	public final void setTentativoCorrente(final int tentativoCorrente) {
		this.tentativoCorrenteProperty().set(tentativoCorrente);
	}

}
