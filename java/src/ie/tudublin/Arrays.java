/* package ie.tudublin;

import processing.core.PApplet;

public class Arrays extends PApplet
{
	String[] months = {"jan", "feb", "mar", "apr","may","june","july","aug","sep","oct","nov","Dec","jan"};
    float[] rainfall = {200,260,300,150,100,50,10,40,67,160, 400};
	//Creae bar chart 
	public float map1(float a, float b, float c, float d, float e)
	{	
		//map1
		float range1 = c - b; 
		float range2 = e - d;
		float howfar = a - b;

		return d (howfar/range1)*range2;
	}

	public void settings()
	{
		size(500, 500);
		String[] m1 = months;
		months[0] = "XXX";
		print(m1[0]);

		for (int i = 0; i<months.length; i ++)
		{
			println("Month:" + months[i] + "\t" + rainfall[i]);
		}

		for (String s: m1){
        println(s);
		}
		float min=0;
		int max = 0;
		int mini;

		for (int i = 0; i <months.length; i ++)
		{
			rainfall[i] = max;
			if (rainfall[i]>max)
			{
				rainfall[i] = max;
			}
			
			min = rainfall[0];
			
			if (rainfall[i]<min)
			{
				rainfall[i] = min;
			}
			 
	
		}
		mini = (int)min;


		println(months[max]+"has the most rain"+"\n"+ months[mini]+ "has the least rainfall");

		float total = 0;
		for (float f:rainfall)
		{
			total +=f;
		}

		float avg = total / (float) rainfall.length;

		//Draw bar chart
		println(map1(a:5,b: 0, c:10, d:0, e:100)); //50
		println(map(a:25,b:20,c:30,d:200,e:300)); //250
		println(map(a:26, b:25, c:35, d:0, e:100); //10

	}

	public void setup() {
		colorMode(HSB);
		background(0);

		

		
	}
	
	public void draw()
	{
		for (int i = 0; i < months.length;i++)
		{
			float w = width / months.length;
			float x = map1(i,b:0,months.length, d:0, width);
			rect(x,height, -rainfall(i))
		}	
	}
}
 */