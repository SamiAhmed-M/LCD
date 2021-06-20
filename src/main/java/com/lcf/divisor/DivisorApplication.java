package com.lcf.divisor;
/** Given four integer numbers find the LCD  Least common divisor */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;
import java.util.Arrays;

@SpringBootApplication
public class DivisorApplication {

	public static void main(String[] args) {
		SpringApplication.run(DivisorApplication.class, args);
		Scanner myObj = new Scanner(System.in);
		// prompt user
		System.out.println("Please enter four integer numbers for which LCD is to be found");
		int []arr = new int[4];
		for (int i=0; i<4; i++)
		{
			arr[i] = myObj.nextInt();
		}
		myObj.close();
		Calculate calc = new Calculate();
		System.out.println("LCD is: " + calc.divisor(arr));
	}

}

class Calculate{
	
	public int divisor(int [] arr)
	{
		// sort the array element to find the smallest elt
		Arrays.sort(arr);
		int elt = arr[0], lcd=0, flag = 0;  // smallest element
		for (int i=1;i<=elt;i++) // when checking GCF use for\(int i=elt;i>=1;i--\)
		{
			if (elt % i == 0)
			{
				// check same with the rest of the elements
				if (arr[1]%i == 0 && arr[2]%i == 0 && arr[3]%i == 0)
				{
					lcd = i;
					flag = 1;
				}
			}
		}
		
		if (flag == 0)
		{
			// no LCD for the input 
			lcd = 0;
		}
		return lcd;
	}
	
}
