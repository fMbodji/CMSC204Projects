
public class ArraySum {

	public int sumOfArray(Integer[] myArray, int index) {
		int sum=0;
		if(index==0)
			 sum+= myArray[index]; 
		else
		{
			sum = myArray[index] + sumOfArray(myArray, index-1);
		}
		return sum;
	}

}
