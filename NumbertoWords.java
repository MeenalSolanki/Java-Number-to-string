// Java program to print a given number in words. The  
 
 import java.util.Scanner;
  
class NumbertoWords 
{ 


// A function that prints 
// given number in words  
static void convert_to_words(String initialNum) 
{ 
int index;
String decimal="";
    // Get number of digits 
    // in given number contains
	if(initialNum.contains("."))
	{
		 index = initialNum.indexOf(".");
		 decimal =  initialNum.substring(index+1,initialNum.length());

	}
	else {
		index = initialNum.length();
	}
	
	
		
	String str = initialNum.substring(0,index); 
	char[] num = str.toCharArray();
    int len = num.length;
    
	
    // Base cases  
    if (len == 0)  
    { 
        System.out.println("empty string"); 
        return; 
    } 
    if (len > 6)  
    { 
        System.out.println("Length more than 6 is not supported"); 
        return; 
    } 
  
    /* The first string is not used, it is to make  
        array indexing simple */
    String[] single_digits = new String[]{ "Zero", "One",  
                                        "Two", "Three", "Four", 
                                        "Five", "Six", "Seven",  
                                            "Eight", "Nine"}; 
  
    /* The first string is not used, it is to make  
        array indexing simple */
    String[] two_digits = new String[]{"", "Ten", "Eleven", "Twelve",  
                                        "Thirteen", "Fourteen", 
                                        "Fifteen", "Sixteen", "Seventeen", 
                                        "Eighteen", "Nineteen"}; 
  
    /* The first two string are not used, they are to make array indexing simple*/
    String[] tens_multiple = new String[]{"", "", "Twenty", "Thirty", "Forty",  
                                            "Fifty","Sixty", "Seventy",  
                                            "Eighty", "Ninety"}; 
  
    String[] tens_power = new String[] {"Hundred", "Thousand" ,"Lakh"}; 
  
    /* Used for debugging purpose only */
    System.out.print(String.valueOf(num)+": \n"); 
  
    /* For single digit number */
    if (len == 1)  
    { 
        System.out.println(single_digits[num[0] - '0']); 
        return; 
    } 
  
    /* Iterate while num 
        is not '\0' */
    int x = 0; 
	
    while (x < num.length)  
    {

		if(len >= 6)
		{
			 if (num[x]-'0' != 0) 
            { 
                System.out.print(single_digits[num[x] - '0']+" "); 
				 System.out.print(tens_power[len - 4]+" ");  
                
            } 
            len--;
			
		}
		
		else if(len >= 5 && len < 6 )
		{
			 if (num[x]-'0' != 0) 
            { 
                System.out.print(tens_multiple[num[x] - '0']+" "); 
                
            } 
            len--;
			
		}
  
  
        /* Code path for first 2 digits */
         else if (len >= 3 && len < 5) 
        { 
            if (num[x]-'0' != 0) 
            { 
                System.out.print(single_digits[num[x] - '0']+" "); 
                System.out.print(tens_power[len - 3]+" ");  
                // here len can be 3 or 4 
            } 
            --len; 
        } 
		
		
        /* Code path for last 2 digits */
        else
        { 
            /* Need to explicitly handle  
            10-19. Sum of the two digits 
            is used as index of "two_digits" 
            array of strings */
			
			
            if (num[x] - '0' == 1)  
            { 
                int sum = num[x] - '0' +  
                    num[x] - '0'; 
                System.out.println(two_digits[sum]); 
                return; 
            } 
  
            /* Need to explicitely handle 20 */
            else if (num[x] - '0' == 2 &&  
                    num[x + 1] - '0' == 0) 
            { 
                System.out.println("twenty"); 
                return; 
            } 
  
            /* Rest of the two digit  
            numbers i.e., 21 to 99 */
            else
            { 
                int i = (num[x] - '0'); 
                if(i > 0) 
                System.out.print(tens_multiple[i]+" "); 
                else
                System.out.print(""); 
                ++x; 
                if (num[x] - '0' != 0) 
                    System.out.print(single_digits[num[x] - '0']); 
            } 
        } 
        ++x; 
    } 
	if(initialNum.contains(".")){
		System.out.print(" "+decimal +" / 100 ");
	}
	  System.out.print(" Only \n\n");
	  System.out.print("----------------------------------------------------------------------------------------------------------\n");
	  
} 
  
// Driver Code 
public static void main(String[] args) 
{ 

String strNum;
Scanner sc = new Scanner(System.in);

do{
System.out.println("Enter a number smaller then 8 digits");
strNum = sc.nextLine();

}while(strNum.length() > 9);

convert_to_words(strNum); 

} 
} 