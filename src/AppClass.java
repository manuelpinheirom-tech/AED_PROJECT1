import dataStructures.DoublyLinkedList;
import dataStructures.Iterator;
import dataStructures.exceptions.NoSuchElementException;

import java.io.Serializable;

public class AppClass implements App, Serializable {
    private static final long serialVersionUID = 1L;

    DoublyLinkedList<City> cities;

    public AppClass(){
        this.cities = new DoublyLinkedList();
    }

    //tenho de meter exceção aqui pa qnd ja existe mas pila nao tenho paciencia agora
    public void addCity(String cityName,  String countryName, int population) throws NoSuchElementException {
        Iterator<City> iterator = this.cities.iterator();
        while (iterator.hasNext()){
            City city = iterator.next();
            if(city.getName().equals(cityName) &&  city.getCountry().equals(countryName)){
                throw  new NoSuchElementException();
            }
        }
        City c = new CityClass(countryName, population, cityName);
        iterator = this.cities.iterator();
        int position = 0;
        while (iterator.hasNext()){
            City current = iterator.next();
            if(c.compareTo(current) < 0){
                cities.add(position ++, c);
            }
        }
        cities.addLast(c);
    }

    public void removeCity(String cityName, String countryName) throws NoSuchElementException {
        Iterator<City> iterator = this.cities.iterator();
        int pos = 0;
        boolean removed = false;
        while(iterator.hasNext()){
            City current = iterator.next();
            if(current.getName().equals(cityName) &&  current.getCountry().equals(countryName)){
                cities.remove(pos);
                removed = true;
            }
            pos++;
        }
        if(!removed){
            throw  new NoSuchElementException();
        }

    }

    public int getPopulation(String city, String country) throws NoSuchElementException {
        Iterator<City> iterator = this.cities.iterator();
        while (iterator.hasNext()){
            City current = iterator.next();
            if(current.getName().equals(city) &&  current.getCountry().equals(country)){
                return current.getInhabitants();
            }
        }
        throw  new NoSuchElementException();
    }

    public Iterator<City> listCities()throws NoSuchElementException{
        if(this.cities.isEmpty()){
            throw  new NoSuchElementException();
        }
        return this.cities.iterator();
    }
}
