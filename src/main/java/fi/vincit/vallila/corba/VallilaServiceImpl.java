package fi.vincit.vallila.corba;

import fi.vincit.vallila.corba.generated.Data;
import fi.vincit.vallila.corba.generated.VallilaServiceOperations;

public class VallilaServiceImpl implements VallilaServiceOperations {

	private int beers = 0;

	@Override
	public Data getData() {
		return new Data("Ismo", this.beers);
	}

	@Override
	public void setBeers(int beers) {
		this.beers = beers;
	}

}
