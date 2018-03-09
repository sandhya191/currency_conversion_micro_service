package com.examples.web;

import java.net.HttpURLConnection;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 
 * @author Sandhya
 * Currency Exchage Service Proxy
 */

//@FeignClient(name="currency-exchange-service-1", url="localhost:8003")
@RibbonClient(name="netflix-zuul-api-gateway-server")
@FeignClient(name="currency-exchange-service-1")
public interface CurrencyExchangeServiceProxy {
	
	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchangeValue
	       (@PathVariable("from") String from, @PathVariable ("to") String to);
	
	

}
