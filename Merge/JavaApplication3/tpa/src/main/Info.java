public class Info implements Comparable<Info> {
	private String name, surname, number, city;

	public Info(String name, String surname, String number, String city) {
		super();
		setName(name);
		setSurname(surname);
		setNumber(number);
		setCity(city);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int compareTo(Info o) {
		int valor = name.compareTo(o.name);
		return (valor != 0 ? valor : 1);
	}
}
