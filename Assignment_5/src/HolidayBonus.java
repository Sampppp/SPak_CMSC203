
public class HolidayBonus {

	HolidayBonus(){
		
	}
	
	static double[] calculateHolidayBonus(double[][] data) {
		double[] bonus = new double[data.length];
		for(int i = 0; i < bonus.length; i++) {
			bonus[i] = 0.0;
		}
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[i].length; j++) {	
				
				if(data[i][j] == TwoDimRaggedArrayUtility.getHighestInColumn(data, j))
					bonus[i] += 5000;
				else if(data[i][j] == TwoDimRaggedArrayUtility.getLowestInColumn(data, j))
					bonus[i] += 1000;
				else
					bonus[i] += 2000;
			}
		}
		return bonus;
	}
	
	
	static double calculateTotalHolidayBonus(double[][] data) {
		double total = 0.0;
		for(int i = 0; i < calculateHolidayBonus(data).length; i++) {
			total += calculateHolidayBonus(data)[i];
		}
		return total;
	}
}
