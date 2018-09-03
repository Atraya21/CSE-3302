package lab2bclassdec;

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

	public int getzipCode() {
		return zipCode;
		}
	public void setzipCode(int zipCode) {
		this.zipCode=zipCode;
		}
	
	public String gettypeZip() {
		return typeZip;
		}
	public void settypeZip(String typeZip) {
		this.typeZip=typeZip;
		}
	
	public String getcountyName() {
		return countyName;
		}
	public void setcountyName(String countyName) {
		this.countyName=countyName;
		}
	
	public String getcityName() {
		return cityName;
		}
	public void setcityName(String cityName) {
		this.cityName=cityName;
		}

	public int getestPop() {
		return estPop;
		}
	public void setestPop(int estPop) {
		this.estPop=estPop;
		}
	
	}



