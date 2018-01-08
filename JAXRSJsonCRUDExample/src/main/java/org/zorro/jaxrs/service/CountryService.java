package org.zorro.jaxrs.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
 
import org.zorro.jaxrs.bean.Country;
 
/*
 * It is just a helper class which should be replaced by database implementation.
 * It is not very well written class, it is just used for demonstration.
 */
public class CountryService {
 
 static HashMap<Integer,Country> countryIdMap=getCountryIdMap();
 
 
 public CountryService() {
  super();
 
  if(countryIdMap==null)
  {
   countryIdMap=new HashMap<Integer,Country>();
  // Creating some objects of Country while initializing
   Country indiaCountry=new Country(1, "India",10000);
   Country chinaCountry=new Country(4, "China",20000);
   Country nepalCountry=new Country(3, "Nepal",8000);
   Country bhutanCountry=new Country(2, "Bhutan",7000);
 
 
   countryIdMap.put(1,indiaCountry);
   countryIdMap.put(4,chinaCountry);
   countryIdMap.put(3,nepalCountry);
   countryIdMap.put(2,bhutanCountry);
  }
 }
 
 public List getAllCountries()
 {
  List countries = new ArrayList(countryIdMap.values());
  return countries;
 }
 
 public Country getCountry(int id)
 {
  Country country= countryIdMap.get(id);
  return country;
 }
 
 public Country getCountry(int id, String countryName) {
	 
	 System.out.println("Searching for id:"+id+" countryName:"+countryName);
	    
	 Country country = countryIdMap.get(id);
	 if(country==null)
	 {
		 System.out.println("Completed Search");   
		 return null;
	 }
	 
	 System.out.println("The country of the respective Nation ID is" + country.getCountryName());
	 if(country.getCountryName().equals(countryName))
	 {
		System.out.println("Found the searched country");
		return country; 
	 }
	    
	 return null;
 }
 public Country addCountry(Country country)
 {
  country.setId(countryIdMap.size()+1);
  countryIdMap.put(country.getId(), country);
  return country;
 }
 
 public Country updateCountry(Country country)
 {
  if(country.getId()<=0)
   return null;
  countryIdMap.put(country.getId(), country);
  return country;
 
 }
 public void deleteCountry(int id)
 {
  countryIdMap.remove(id);
 }
 
 public static HashMap<Integer, Country> getCountryIdMap() {
  return countryIdMap;
 }
}
