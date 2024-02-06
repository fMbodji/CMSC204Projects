/*
 * Class: CMSC204
 * Instructor: Huseyin Aygun       
 * Description: Generic Lab
 * Due: 02/06/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
 * 
   Print your Name here: Fatima Mbodji
*/
	public class DataSetGen<T extends Measurable>{
		
		private double sum;
		private T maximum;
		private int count;
	
		public DataSetGen() {
			sum = 0;
		    count = 0;
		    maximum = null;
		}
		
		public void add(T x){
		      sum = sum + x.getMeasure();
		      if (count == 0 || maximum.getMeasure() < x.getMeasure())
		         maximum = x;
		      count++;
		}
		
		public double getAverage(){
		      if (count == 0) 
		    	  return 0;
		      else 
		    	  return sum / count;
		}
		 
		public T getMaximum() {
				return maximum;
		}
	
		public double getMeasure() {
			return maximum.getMeasure();
		}
	
	}
