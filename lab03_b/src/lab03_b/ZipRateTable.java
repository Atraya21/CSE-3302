package lab03_b;

public class ZipRateTable {
	
	private	int ZipCode;
	private	int Rating;

	public ZipRateTable (int ZipCode, int Rating) {
		this.ZipCode=ZipCode;
		this.Rating=Rating;
	}
	
	public int getZipCode() {
		return ZipCode;
		}
	public void setZipCode(int ZipCode) {
		this.ZipCode=ZipCode;
		}
	public int getRating() {
		return Rating;
		}
	public void setRating(int Rating) {
		this.Rating=Rating;
		}
}
