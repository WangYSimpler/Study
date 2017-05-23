package com.simple.gofirst.logView;



public class ColorSelect {

	
	private String red = "#FF0000";
	private String pure = "#8B008B";
	private String yellow = "#FFFF00";
	private String bule = "#3A5FCD";
	private String lakeBule = "#00E5EE";
	private String blackBule = "#00688B";
	private String pureBule = "#1E90FF";
	private String yellowGreen = "#7CFC00";
	
	
	private String getColorHEX(String colorStr)
	{
		String color = colorStr;
		
		String colorHex = "";
		
		if (color.equals("red")) {
			colorHex = red;
		}else if (color.equals("pure")) {
			colorHex = pure;
			
		}else if (color.equals("yellow")) {
			colorHex = yellow;
			
		}else if (color.equals("bule")) {
			colorHex = bule;
			
		}else if (color.equals("lakeBule")) {
			colorHex = lakeBule;
			
		}else if (color.equals("pureBule")) {
			colorHex = pureBule;
			
		}else if (color.equals("yellowGreen")) {
			colorHex = yellowGreen;
			
		}else if (color.equals("blackBule")) {
			colorHex = blackBule;
			
		}
		
		else if(color.matches("#(.*)"))
		{
			colorHex = color;
		}
		
		return colorHex;
		
	}
	
	public String  getColorHead(String colorStr)
	{
		String color = colorStr;
		return "<font color=\"" + this.getColorHEX(color) + "\">";
	}
	
	
	public String  getColorEnd(String colorStr)
	{
		return "</font>";
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ColorSelect cSelect = new ColorSelect();
		System.out.println(cSelect.getColorHead("red") );
	}

}

