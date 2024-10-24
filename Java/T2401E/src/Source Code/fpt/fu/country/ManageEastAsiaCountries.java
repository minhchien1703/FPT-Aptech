package fpt.fu.country;

public class ManageEastAsiaCountries {
	/**
	 * All Message Exception
	 */
	public static String LIMIT_COUNTRY = "Unable to add more country!",
			NO_COUNTRY = "No Country to display!",
			NO_RESULT = "Search not found!", NO_DATA = "No country to search!",
			AREA_NOT_DIGIT = "Area is digit!",
			AREA_LESS_THAN_ZERO = "Area is less than zero!",
			NAME_NULL_EMPTY = "Name can't null or empty!";
	private EastAsiaCountries[] data = new EastAsiaCountries[11];
	private int nextCountry = 0;

	public float checkArea(String area) throws Exception {
		float totalArea = 0;
		try {
			totalArea = Float.parseFloat(area);
			if (totalArea < 0)
				throw new Exception(AREA_LESS_THAN_ZERO);
		} catch (NumberFormatException num) {
			throw new Exception(AREA_NOT_DIGIT);
		} catch (NullPointerException e) {
			throw new Exception(AREA_NOT_DIGIT);
		}
		return totalArea;
	}

	public String checkCountryName(String name) throws Exception {
		if (name == null || "".endsWith(name))
			throw new Exception(NAME_NULL_EMPTY);
		return name;
	}

	public void addCountryInformation(EastAsiaCountries country)
			throws Exception {
		if (nextCountry < data.length) {
			data[nextCountry] = country;
			nextCountry++;
		} else {
			throw new Exception(LIMIT_COUNTRY);
		}
	}

	public EastAsiaCountries getRecentlyEnteredInformation() throws Exception {
		if (nextCountry > 0) {
			return data[nextCountry - 1];
		} else {
			throw new Exception(NO_COUNTRY);
		}
	}

	public EastAsiaCountries[] sortInformationByAscendingOrder()
			throws Exception {
		if (nextCountry > 0) {
			EastAsiaCountries temp = null;
			int n = nextCountry;
			for (int i = 0; i < n; i++) {
				for (int j = 1; j < (n - i); j++) {
					if (data[j].getCountryName().compareTo(
							data[j - 1].getCountryName()) > 0) {
						// swap the elements!
						temp = data[j - 1];
						data[j - 1] = data[j];
						data[j] = temp;
					}
				}
			}
			EastAsiaCountries[] data = new EastAsiaCountries[n];
			for (int i = 0; i < n; i++) {
				data[i] = this.data[i];
			}
			return data;
		} else {
			throw new Exception(NO_COUNTRY);
		}
	}

	public EastAsiaCountries[] searchInformationByName(String name)
			throws Exception {
		if (nextCountry > 0) {
			int length = 0;
			for (int i = 0; i < nextCountry; i++) {
				if (name.equals(data[i].getCountryName())) {
					length++;
				}
			}
			EastAsiaCountries[] data = new EastAsiaCountries[length];
			int index = 0;
			for (int i = 0; i < nextCountry; i++) {
				if (name.equals(this.data[i].getCountryName())) {
					data[index] = this.data[i];
					index++;
				}
			}
			if (length == 0) {
				throw new Exception(NO_RESULT);
			}
			return data;
		} else {
			throw new Exception(NO_DATA);
		}
	}

}
