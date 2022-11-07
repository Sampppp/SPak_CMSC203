/*
 * Class: CMSC203 
 * Instructor: David Kujit
 * Description: HolidayBonus calculates bonuses according to the passed in array and TwoDimRaggedArrayUtility provides methods to read the data in ragged arrays
 * Due: 11/7/2022
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Samson Pak
*/
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
