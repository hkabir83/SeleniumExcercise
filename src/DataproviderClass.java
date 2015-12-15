import org.testng.annotations.DataProvider;


public class DataproviderClass {

	@DataProvider
	public static Object[][] getDataFromOutside(){
		Object[][] data = new Object[2][2];
		
		data[0][0] = "Mr";
		data[0][1] = "Humayun";
		
		data[1][0] = "Mrs";
		data[1][1] = "Kabir";
		
		return data;
		
	}
	
}
