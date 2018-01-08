package org.zorro.jaxrs.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.zorro.jaxrs.bean.Country;
import org.zorro.jaxrs.service.CountryService;

@Path("/countries")
public class CountryController {

	CountryService countryService = new CountryService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List getCountries() {

		List listOfCountries = countryService.getAllCountries();
		return listOfCountries;
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Country getCountryById(@PathParam("id") int id) {
		return countryService.getCountry(id);
	}

	@GET
	@Path("/country")
	@Produces(MediaType.APPLICATION_JSON)
	public Country getCountryById(@QueryParam("id") int id, @QueryParam("countryName") String countryName) {
		return countryService.getCountry(id, countryName);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Country addCountry(Country country) {
		return countryService.addCountry(country);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Country updateCountry(Country country) {
		return countryService.updateCountry(country);

	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteCountry(@PathParam("id") int id) {
		countryService.deleteCountry(id);
	}

}