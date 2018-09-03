package lab_03a;

/*
 * cityNames.stream()
						.forEach(city -> {
							
							ArrayList <String> ziptype = (ArrayList<String>)zipArray.stream() // what is stream object ?? are there multiple ?
									.filter(c -> c.getCountyName().equals(cnty))
									.filter(c -> c.getCityName().equals(city))
									.map(c -> c.getTypeZip());
 */


	public class zipCodeClass {
		private 	int zipCode;
		private String typeZip;
		private 	String cityName;
		private	String countyName;
		private	int estPop;

		public zipCodeClass (int zipCode, String typeZip, String cityName, String countyName, int estPop) {
				this.zipCode=zipCode;
				this.typeZip=typeZip;
				this.cityName=cityName;
				this.countyName=countyName;
				this.estPop=estPop;
			}

		public int getZipCode() {
			return zipCode;
			}
		public void setZipCode(int zipCode) {
			this.zipCode=zipCode;
			}
		
		public String getTypeZip() {
			return typeZip;
			}
		public void setTypeZip(String typeZip) {
			this.typeZip=typeZip;
			}
		
		public String getCountyName() {
			return countyName;
			}
		public void setCountyName(String countyName) {
			this.countyName=countyName;
			}
		
		public String getCityName() {
			return cityName;
			}
		public void setCityName(String cityName) {
			this.cityName=cityName;
			}

		public int getEstPop() {
			return estPop;
			}
		public void setEstPop(int estPop) {
			this.estPop=estPop;
			}
		
		}






