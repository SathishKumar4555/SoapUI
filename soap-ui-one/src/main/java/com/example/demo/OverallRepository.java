package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.example.demo.gs_producing_web_service.Currency;
import com.example.demo.gs_producing_web_service.Overall;

@Component
class OverallRepo {
	private static final Map<String, Overall> overall = new HashMap<>();
	
	public void initDatathree() {
	Overall uk = new Overall();
	uk.setCountry("London");
	uk.setCountry("United Kingdom");
	uk.setCurrency(Currency.GBP);
	uk.setPopulation(63705000);

	overall.put(uk.getCountry(), uk);
	
	Overall poland = new Overall();
	poland.setCapital("Warsaw");
	poland.setCountry("poland");
	poland.setCurrency(Currency.PLN);
	poland.setPopulation(38186860);

	overall.put(poland.getCapital(), poland);

	Overall spain = new Overall();
	spain.setCapital("Madrid");
	spain.setCountry("Spain");
	spain.setCurrency(Currency.EUR);
	spain.setPopulation(46704314);

	overall.put(spain.getCapital(), spain);
	
}
public class OverallRepository extends OverallRepo {
	
	public void initDatatwo() {
		Overall spain = new Overall();
		spain.setCountry("Spain");
		spain.setCapital("Madrid");
		spain.setCurrency(Currency.EUR);
		spain.setPopulation(46704314);

		overall.put(spain.getCountry(), spain);

		Overall poland = new Overall();
		poland.setCountry("Poland");
		poland.setCapital("Warsaw");
		poland.setCurrency(Currency.PLN);
		poland.setPopulation(38186860);

		overall.put(poland.getCountry(), poland);

		Overall uk = new Overall();
		uk.setCountry("United Kingdom");
		uk.setCapital("London");
		uk.setCurrency(Currency.GBP);
		uk.setPopulation(63705000);

		overall.put(uk.getCountry(), uk);
		
		
		
	}

	public Overall findOverall(String name) {
		Assert.notNull(name, "The country's name must not be null");
		return overall.get(name);
	}

}
}
