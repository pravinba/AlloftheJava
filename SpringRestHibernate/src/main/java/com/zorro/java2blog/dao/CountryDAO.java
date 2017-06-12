package com.zorro.java2blog.dao;

import java.util.List;

import com.zorro.java2blog.model.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
 
@Repository
public class CountryDAO {
 
 @Autowired
 private SessionFactory sessionFactory;
 
 public void setSessionFactory(SessionFactory sf) {
  this.sessionFactory = sf;
 }
 
 public List getAllCountries() {
  Session session = this.sessionFactory.getCurrentSession();
  List countryList = session.createQuery("from Country").list();
  return countryList;
 }
 
 public Country getCountry(int id) {
  Session session = this.sessionFactory.getCurrentSession();
  Country country = (Country) session.load(Country.class, new Integer(id));
  //System.out.println("Inside CountryDAO - getCountry()"+country.getCountryName());
  return country;
 }
 
 public Country addCountry(Country country) {
  Session session = this.sessionFactory.getCurrentSession();
  session.merge(country);
  return country;
 }
 
 public void updateCountry(Country country) {
  Session session = this.sessionFactory.getCurrentSession();
  session.update(country);
 }
 
 public void deleteCountry(int id) {
  Session session = this.sessionFactory.getCurrentSession();
  Country p = (Country) session.load(Country.class, new Integer(id));
  if (null != p) {
   session.delete(p);
  }
 } 
}