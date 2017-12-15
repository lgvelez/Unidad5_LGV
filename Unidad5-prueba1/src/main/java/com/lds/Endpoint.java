package com.lds;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import java.rmi.RemoteException;
import org.apache.axis2.AxisFault;
import com.lds.soap.GlobalWeatherStub;
import com.lds.soap.GlobalWeatherStub.GetCitiesByCountry;
import com.lds.soap.GlobalWeatherStub.GetCitiesByCountryResponse;
import com.lds.soap.GlobalWeatherStub.GetWeather;
import com.lds.soap.GlobalWeatherStub.GetWeatherResponse;

@Path("/servlet")
public class Endpoint {

	@GET
	@Path("/Ciudad/{Ciudad}")
	@Produces("text/plain")
	public String servlet3( @PathParam("Ciudad") String ciudad) throws RemoteException {
		
		GlobalWeatherStub globalWeatherStub = new GlobalWeatherStub();
		GetCitiesByCountry getCitiesByCountry = new GetCitiesByCountry();
		getCitiesByCountry.setCountryName(ciudad);

		GetCitiesByCountryResponse getCitiesByCountryResponse = globalWeatherStub.getCitiesByCountry(getCitiesByCountry);
		
		//System.out.println(getCitiesByCountry.getCountryName());
		return (getCitiesByCountryResponse.getGetCitiesByCountryResult());
		
	}

	
}
