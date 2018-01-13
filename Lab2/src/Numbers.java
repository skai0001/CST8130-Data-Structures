import java.util.Arrays;
import java.util.Random;

public class Numbers {

	private int size;
	private Integer[] array ;

	public Numbers(){ // default constructor 

	}

	public Numbers(int size){ // initial constructor
		this.size=size;
		array = new Integer [size];

	}

	public void generateNumbers(){

		for (int i = 0 ; i <array.length ;i++)
		{
			array[i]= (int)(Math.random()* 100+1);	
		}
	}
	public int count(Integer x){
		int c = 0; 
		for(Integer c1 : array) {
				
			if(c1 == x) 
				c++; 
		} 
		return c;
	}


	public String toString(){
		String s ="";
		
		for( Integer x : array ){
			 
			s += x + " " ;
		}
		
		return s;
	}




}
