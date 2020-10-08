package springdemo.mvc;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Student {
	private String firstName;
	private String lastName;
	private String country;
	private String favoriteLanguage;
	private String[] operatingSystem;

	private LinkedHashMap<String, String> countryOptions;
	private List<String> favoriteLanguages;
	private List<String> operatingSystems;

	public Student() {
		countryOptions = new LinkedHashMap<String, String>();

		countryOptions.put("US", "USA");
		countryOptions.put("RUS", "Russia");
		countryOptions.put("CAN", "Canada");
		countryOptions.put("JAP", "Japan");
		countryOptions.put("CHN", "China");

		favoriteLanguages = new ArrayList<String>();
		favoriteLanguages.add("Java");
		favoriteLanguages.add("Python");
		favoriteLanguages.add("C++");
		favoriteLanguages.add("JavaScript");

		operatingSystems = new ArrayList<String>();
		operatingSystems.add("Windows");
		operatingSystems.add("Linux");
		operatingSystems.add("MacOS");
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}

	public List<String> getFavoriteLanguages() {
		return favoriteLanguages;
	}

	public void setFavoriteLanguages(List<String> favoriteLanguages) {
		this.favoriteLanguages = favoriteLanguages;
	}

	public void setCountryOptions(LinkedHashMap<String, String> countryOptions) {
		this.countryOptions = countryOptions;
	}

	public String[] getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String[] operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	public List<String> getOperatingSystems() {
		return operatingSystems;
	}

	public void setOperatingSystems(List<String> operatingSystems) {
		this.operatingSystems = operatingSystems;
	}

}
