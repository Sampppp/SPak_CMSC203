import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility {
	TwoDimRaggedArrayUtility(){
		
	}
	//Returns the total of the selected column in the two dimensional array index 0 refers to the first column.
	static double getColumnTotal(double[][] data, int col) {
		double total = 0.0;
		for(int i = 0; i < data.length; i++) {
			try {
				total += data[i][col];
			}
			catch(Exception e){
				continue;
			}	
		}
		return total;
	}
	
	//Returns the total of the selected row in the two dimensional array index 0 refers to the first row.
	static double getRowTotal(double[][] data, int row) {
		double total = 0.0;
		for(int i = 0; i < data[row].length; i++) {
			total += data[row][i];
		}
		return total;
	}
		
	//Returns the total of all the elements of the two dimensional array
	static double getTotal(double[][] data) {
		double total = 0.0;
		for(int i = 0; i < data.length; i++) {
			total += getRowTotal(data, i);
		}
		return total;
	}
		
	//Returns the average of the elements in the two dimensional array
	static double getAverage(double[][] data) {
		int div = 0;
		for(int i = 0; i < data.length; i++) {
			div += data[i].length;
		}
		return (getTotal(data) / div);
	}
	
	//Returns the largest element in the two dimensional array
	static double getHighestInArray(double[][] data) {
		double temp = getHighestInRow(data, 0);
		for(int i = 1; i < data.length; i++) {
			if(temp < getHighestInRow(data, i))
				temp = getHighestInRow(data, i);
		}
		return temp;
	}
	
	//Returns the largest element of the selected column in the two dimensional array index 0 refers to the first column.
	static double getHighestInColumn(double[][] data, int col) {
		return data[getHighestInColumnIndex(data, col)][col];
	}
	
	//Returns index of the largest element of the selected column in the two dimensional array index 0 refers to the first column.
	static int getHighestInColumnIndex(double[][] data, int col) {
		int index = 0;
		int i = 0;
		double temp = data[0][0];
		for(; i < data.length; i++) {
			if(col >= data[i].length)
				continue;
			temp = data[i][col];
			break;
		}
		for(i++; i < data.length; i++) {
			if(col >= data[i].length)
				continue;
			if(temp < data[i][col]) {
				temp = data[i][col];
				index = i;
			}
		}
		return index;
	}
	
	//Returns the largest element of the selected row in the two dimensional array index 0 refers to the first row.
	static double getHighestInRow(double[][] data, int row) {
		return data[row][getHighestInRowIndex(data, row)];
	}
	
	//Returns the largest element of the selected row in the two dimensional array index 0 refers to the first row.
	static int getHighestInRowIndex(double[][] data, int row) {
		double temp = data[row][0];
		int i = 1;
		for(; i < data[row].length; i++) {
			if(temp < data[row][i])
				temp = data[row][i];
		}
		return i;
	}
	
	//Returns the smallest element in the two dimensional array
	static double getLowestInArray(double[][] data) {
		double temp = getLowestInRow(data, 0);
		for(int i = 1; i < data.length; i++) {
			if(temp > getLowestInRow(data, i))
				temp = getLowestInRow(data, i);
		}
		return temp;
	}
	
	//Returns the smallest element of the selected column in the two dimensional array index 0 refers to the first column.
	static double getLowestInColumn(double[][] data, int col) {
		return data[getLowestInColumnIndex(data, col)][col];
	}
	
	//Returns the index of the smallest element of the selected column in the two dimensional array index 0 refers to the first column.
	static int getLowestInColumnIndex(double[][] data, int col) {
		int index = 0;
		int i = 0;
		double temp = data[0][0];
		for(; i < data.length; i++) {
			if(col >= data[i].length)
				continue;
			temp = data[i][col];
			break;
		}
		for(i++; i < data.length; i++) {
			if(col >= data[i].length)
				continue;
			if(temp > data[i][col]) {
				temp = data[i][col];
				index = i;
			}	
		}
		return index;
	}
	
	//Returns the smallest element of the selected row in the two dimensional array index 0 refers to the first row.
	static double getLowestInRow(double[][] data, int row) {
		return data[row][getLowestInRowIndex(data, row)];
	}
	
	//Returns the index of the smallest element of the selected row in the two dimensional array index 0 refers to the first row.
	static int getLowestInRowIndex(double[][] data, int row) {
		double temp = data[row][0];
		int i = 1;
		for(; i < data[row].length; i++) {
			if(temp > data[row][i])
				temp = data[row][i];
		}
		return i;
	}
	
	
		
	//Reads from a file and returns a ragged array of doubles The maximum rows is 10 and the maximum columns for each row is 10 
	//Each row in the file is separated by a new line Each element in the row is separated by a space 
	//Suggestion: You need to know how many rows and how many columns there are for each row to create a ragged array.
	static double[][] readFile(File file){
		int row = 0;
		int col = 1;
		String tempRow = "";
		String tempVal = "";
		
		int index1 = 0;
		int index2 = 0;
		
		try {
			Scanner in = new Scanner(file);
			
			//loops through a file to cound # of lines
			while(in.hasNextLine()) {
				row++;
				in.nextLine();
			}
			in.close();
			
			double[][] array = new double[row][];
			
			
			//Scanner restarts back at the top of file
			in = new Scanner(file);
			
			for(int i = 0; in.hasNextLine(); i++) {
				//Line is saved as a string
				tempRow = in.nextLine();
				//String is split into a string array
				String[] stringRow = tempRow.split(" ");
				//Second index is declared to have the same length as string array
				array[i] = 	new double[stringRow.length];
				
				for(int j = 0; j < stringRow.length; j++) {
					//each value of the string array is parsed into a double
					array[i][j] = Double.parseDouble(stringRow[j]);
				}
			}	
			in.close();
			return array;
		} 
		//catch block for file error exceptions
		catch (FileNotFoundException e) {
			System.out.println("An error occuered: ");
			e.printStackTrace();
			return null;
		}
	}
	
	//Writes the ragged array of doubles into the file.
	static void writeToFile(double[][] data, File outputFile) {
		try {
			FileWriter write = new FileWriter(outputFile);
			
			for(int i = 0; i < data.length; i++) {
				for(int j = 0; j < data[i].length; j++) {
					//writes out the row
					write.write(String.format("%.2f ", data[i][j]));
				}
				//next line after row is written
				write.write("\n");
			}
			write.close();
		} 
		//catch block for file error exceptions
		catch (IOException e) {
			System.out.println("An error occuered: ");
			e.printStackTrace();
		}
		
	}
	
}
