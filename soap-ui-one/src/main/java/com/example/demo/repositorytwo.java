package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.example.demo.gs_producing_web_service.Capital;
import com.example.demo.gs_producing_web_service.Currency;

@Component
public class repositorytwo {
private static final Map<String, Capital> capital = new HashMap<>();
	
	@PostConstruct
	public void initDataone()
	{
	Capital uk = new Capital();
	uk.setCapital("London");
	uk.setCountry("United Kingdom");
	uk.setCurrency(Currency.GBP);
	uk.setPopulation(63705000);

	capital.put(uk.getCapital(), uk);
	
	Capital poland = new Capital();
	poland.setCapital("Warsaw");
	poland.setCountry("poland");
	poland.setCurrency(Currency.PLN);
	poland.setPopulation(38186860);

	capital.put(poland.getCapital(), poland);

	Capital spain = new Capital();
	spain.setCapital("Madrid");
	spain.setCountry("Spain");
	spain.setCurrency(Currency.EUR);
	spain.setPopulation(46704314);

	capital.put(spain.getCapital(), spain);

	}
	public Capital findCapital(String name) {
		Assert.notNull(name, "The country's name must not be null");
		return capital.get(name);
	}

}
