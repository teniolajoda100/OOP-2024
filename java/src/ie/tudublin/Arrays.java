package ie.tudublin;

import processing.core.PApplet;



public class Arrays extends PApplet
{
	String[] months = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};

	float[] rainfall = {200, 260, 300, 150, 100, 50, 10, 40, 67, 160, 400, 420};

	public float map1(float a, float b, float c, float d, float e)
	{
		float r1 = c -b;
		float r2 = e - d;

		float howFar = a - b;
		return d + (howFar / r1) * r2;
	}

	void randomize()
	{
		for (int i = 0; i < rainfall.length; i++) {
			rainfall[i] = random(500);
		}
	}

	public void settings()
	{
		size(1100,700);

		String[] m1 = months;
		for(int i = 0; i < months.length; i ++)
		{
			println("Month: " + months[i] + "\t" + rainfall[i]);
		}
		for (String s : m1) {
			println(s);
		}

		int minIndex = 0;
		for(int i= 0 ; i < rainfall.length ; i ++)
		{
			if (rainfall[i] < rainfall[minIndex])
			{
				minIndex = i;
			}
		}
		
		int maxIndex = 0;
		for(int i= 0 ; i < rainfall.length ; i ++)
		{
			if (rainfall[i] > rainfall[maxIndex])
			{
				maxIndex = i;
			}
		}

		println("The month with the minimum rainfall was " + months[minIndex] + " with " + rainfall[minIndex] + "rain");
		println("The month with the max rainfall was " + months[maxIndex] + " with " + rainfall[maxIndex] + "rain");
		
		
		float tot = 0;
		for(float f:rainfall)
		{
			tot += f;
		}

		float avg = tot / (float) rainfall.length;

		// a b-c d-e;
		println(map1(5, 0, 10, 0, 100));
		// 50

		println(map1(25, 20, 30, 200, 300));
		// 250

		println(map1(26, 25, 35, 0, 100));
		// 10 


	}

	public void setup() {
		colorMode(HSB);
		background(0);
		randomize();
		
		
	}
 
	

	public void draw() {    
		background(0);
		float barWidth = (width - 100) / (float)months.length; // Calculate the width of each bar
	
		// Find the maximum rainfall value
		float maxRainfall = max(rainfall);
		int rainfallx = 0;
		for(int i = 0; i < months.length; i++) {
			float x = 50 + i * barWidth; // Starting x position of the bar
			float barHeight = map(rainfall[i], 0, maxRainfall, 0, height - 100); // Map the height of the bar
			
			float hue = map(i, 0, months.length, 0, 255);
			float saturation = 255;
			float brightness = 200;
			// Set the fill color using HSB color mode
			fill(hue, saturation, brightness);
			// Draw the bar
			rect(x, height - 50, barWidth, -barHeight); // Draw from the bottom up
			
			// Draw the month labels
			textAlign(CENTER, CENTER);
			fill(250);
			text(months[i], x + barWidth / 2, height - 30);

		}
		
	
		    // Draw the y-axis values
		textAlign(RIGHT, CENTER);
		fill(250);
		for (int i = 0; i <= 110; i += 10) {
			float y = map(i, 0, 110, height - 50, 50); // Map y-coordinate
			text(i, 45, y); 
			// Draw small lines outwards from the y-axis
			line(45, y,50, y);

		}

		stroke(250);
		line(50, height - 50, width - 50, height - 50); // X-axis
		line(50, height - 50, 50, 50); // Y-axis
	
}
	
}
