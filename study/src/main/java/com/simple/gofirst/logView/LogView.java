package com.simple.gofirst.logView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;


public class LogView {

	// 展示日志
	public String displayLogs(String pathStr, String fontColorJsonStr) {

		String fontColorJson = fontColorJsonStr;
		
		Map<String, String> colorMap = this.getColorMap(fontColorJson);
		
		String path = pathStr;
		return this.findKeyLogs(path, null, false, colorMap);
	}

	// 日志中第一个关键字
	public String displaySearchKeylogs(String pathStr, String keyStr, String fontColorJsonStr) {
		String path = pathStr;
		String key = keyStr;

		String fontColorJson = fontColorJsonStr;
		
		Map<String, String> colorMap = this.getColorMap(fontColorJson);
		
		//String keyFontColor = "red";

		return this.findKeyLogs(path, key, true, colorMap);
	}

	// 日志中全部的关键字
	public String displaySearchAllKeyslogs(String pathStr, String keyStr, String fontColorJsonStr) {
		String path = pathStr;
		String key = keyStr;

//		String fontColorJson = fontColorJsonStr;
//		String keyFontColor = "pure";
		String fontColorJson = fontColorJsonStr;
		Map<String, String> colorMap = this.getColorMap(fontColorJson);
		
		return this.findKeyLogs(path, key, false, colorMap);
	}

	private Map<String, String> getColorMap(String colorJsonStr) {
		String colorJson = colorJsonStr;

		Map<String, String> traditionColorMap = new HashMap<String,String>();
		traditionColorMap.put("pointColor", "pure");
		traditionColorMap.put("paramColor", "bule");
		traditionColorMap.put("valueColor", "blackBule");
		traditionColorMap.put("targetColor", "bule");
		traditionColorMap.put("startColor", "yellowGreen");
		traditionColorMap.put("startValueColor", "#228B22");
		traditionColorMap.put("searchColor", "red");

		Gson colorGson = new Gson();
		if (colorJson != null &&(!colorJson.equals(""))  && (!colorJson.equals("0"))) {
			Map<String, String> colorTempMap = colorGson.fromJson(colorJson, (Type)traditionColorMap);
			traditionColorMap.putAll(colorTempMap);
		}
		Map<String, String> colorMap = new HashMap<String, String>();
		colorMap.putAll(traditionColorMap);

		return colorMap;
	}

	private boolean ownSubStringflag(String sourceStr, String subStr) {
		String src = sourceStr, sub = subStr;
		boolean ownSubStringBoolean = false;
		if (src.indexOf(sub) > -1)
			;
		{
			ownSubStringBoolean = true;
		}

		return ownSubStringBoolean;
	}

	private int subStrPoisition(String srcStr, String key) {
		return srcStr.indexOf(key);
	}

	private String setkeyColor(String srcStr, String keyStr, String colorStr) {
		String src = srcStr;
		String key = keyStr;
		String color = colorStr;

		ColorSelect colorS = new ColorSelect();
		/// 颜色开头
		String colorHead = colorS.getColorHead(color);
		/// 颜色结束
		String colorEnd = colorS.getColorEnd(color);

		src = this.setkeyHeadColor(src, key, colorHead);
		src = this.setkeyEndColor(src, key, colorEnd);

		return src;
	}

	/// 在字符串中制定的字符创设置颜色
	private String setkeyHeadColor(String srcStr, String keyStr, String colorHeadStr) {
		String src = srcStr;
		String key = keyStr;
		String color = colorHeadStr;

		/// 是不是存在该关键字
		boolean keyFlag = this.ownSubStringflag(src, key);
		if (keyFlag) {
			int subPosition = this.subStrPoisition(src, key);
			src = this.insertStrInPosition(src, color, subPosition);
		}

		return src;
	}

	private String setkeyEndColor(String srcStr, String keyStr, String colorHeadStr) {
		String src = srcStr;
		String key = keyStr;
		String color = colorHeadStr;

		/// 是不是存在该关键字
		boolean keyFlag = this.ownSubStringflag(src, key);
		if (keyFlag) {
			int subPosition = this.subStrPoisition(src, key);
			src = this.insertStrInPosition(src, color, (subPosition + key.length()));
		}

		return src;
	}

	// 制定位置插入特定字符床
	private String insertStrInPosition(String srcStr, String decStr, int position) {

		StringBuffer stringBuffer = new StringBuffer(srcStr);
		return stringBuffer.insert(position, decStr).toString();
	}

	private String findKeyLogs(String pathStr, String keyStr, boolean firstkeyFlagBool, Map<String, String> colorFontMap) {

		String path = pathStr;
		String key = keyStr;
		boolean firstKeyFlag = firstkeyFlagBool;
		Map<String, String> colorFont = new HashMap<String,String>();
		colorFont.putAll(colorFontMap);
		//String keyFontColor = colorFontMap;

		String htmlHeadStr = "<!doctype html><html lang=\"en\">" + "<head>  <meta charset=\"UTF-8\">"
				+ "  <meta name=\"Description\" content=\"\">" + "  <title>logView</title>" + "</head>" + " <body>";

		String htmlEndStr = "</body>" + "</html>";
		String htmlBodyStr = "";

		htmlBodyStr = this.getCommonLogStr(path, key, firstKeyFlag, colorFont);

		String htmlFinalResultStr = htmlHeadStr + htmlBodyStr + htmlEndStr;

		return htmlFinalResultStr;

	}

	// 设置字体颜色
	@SuppressWarnings("unused")
	private String SetFontYellow(String fontStr) {
		String str = fontStr;
		String yellowHeadStr = "<font color=\"#00FFFF\">";
		String yellowEndStr = "</font>";

		return yellowHeadStr + str + yellowEndStr;
	}

	@SuppressWarnings("unused")
	private String SetFontBule(String fontStr) {
		String str = fontStr;
		String buleHeadStr = "<font color=\"#0000FF\">";
		String buleEndStr = "</font>";

		return buleHeadStr + str + buleEndStr;
	}

	@SuppressWarnings("unused")
	private String SetFontRed(String fontStr) {
		String str = fontStr;
		String redHeadStr = "<font color=\"#FF0000\">";
		String redEndStr = "</font>";

		return redHeadStr + str + redEndStr;
	}

	@SuppressWarnings("unused")
	private String SetFontPurple(String fontStr) {
		String str = fontStr;
		String purpleHeadStr = "<font color=\"#473C8B\">";
		String purpleEndStr = "</font>";

		return purpleHeadStr + str + purpleEndStr;
	}

	/*** 颜色配置结束 **/

	/// 查找第一个关键字,
	private String getCommonLogStr(String pathStr, String keyStr, boolean firstkeyFlagBool,Map<String, String> colorFontMap) {
		
		String path = pathStr;
		String key = keyStr;
		Map<String, String> colorFont = new HashMap<String, String>();
		colorFont.putAll(colorFontMap);
		
		File file = new File(path);
		StringBuilder result = new StringBuilder();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));// 构造一个BufferedReader类来读取文件
			String s = null;

			boolean firstFlag = firstkeyFlagBool;

			/// 判断是否是第一个查找到第一个就进行停止
			boolean isfindKeyFlag = false;

			/// 没有查询关键字说明是展示log
			if (key == null) {
				isfindKeyFlag = true;
			}

			while ((s = br.readLine()) != null) {// 使用readLine方法，一次读一行
				if ((s.indexOf("START") != -1) || (s.indexOf("END") != -1)) {
					if ((s.indexOf("START") != -1)) {

						String targetValueStr  = s.substring(s.indexOf("START") + 8, s.length());
						String startValueColor = colorFont.get("startValueColor");
						String startColor      = colorFont.get("startColor");
						s = this.setkeyColor(s, targetValueStr,startValueColor);
						s = this.setkeyColor(s, "START", startColor);
						// int targetStart = s.indexOf("@");

					}
					if ((s.indexOf("END") != -1)) {

						String startValueColor = colorFont.get("startValueColor");
						String startColor      = colorFont.get("startColor");
						String targetValueStr = s.substring(s.indexOf("END") + 5, s.length());
						s = this.setkeyColor(s, targetValueStr, startValueColor);

						s = this.setkeyColor(s, "END", startColor);
						// int targetStart = s.indexOf("@");

					}

				}

				if ((s.indexOf("Target") != -1) || (s.indexOf("Value") != -1) || (s.indexOf("Param") != -1)) {
					// ||(s.indexOf("Value") != -1)||(s.indexOf("Param") != -1)
					if ((s.indexOf("Target") != -1)) {
						
						String targetColor = colorFont.get("targetColor");
						String targetValueStr = s.substring(s.indexOf("@"), s.length());
						s = this.setkeyColor(s, targetValueStr,targetColor);
						String pointColor = colorFont.get("pointColor");
						s = this.setkeyColor(s, "Target", pointColor);
						// int targetStart = s.indexOf("@");

					}
					if (s.indexOf("Value") != -1) {
						String valueColor = colorFont.get("valueColor");
						String valueStr = s.substring(s.indexOf("Value") + 8, s.length());
						s = this.setkeyColor(s, valueStr, valueColor);
						String pointColor = colorFont.get("pointColor");
						s = this.setkeyColor(s, "Value", pointColor);

					}
					if (s.indexOf("Param") != -1) {
						
						String paramColor = colorFont.get("paramColor");
						String paramValueStr = s.substring(s.indexOf("Param") + 8, s.indexOf("Value") - 23);
						s = this.setkeyColor(s, paramValueStr, paramColor);
						String pointColor = colorFont.get("pointColor");
						s = this.setkeyColor(s, "Param", pointColor);
					}

				}

				if ((!isfindKeyFlag) && (s.indexOf(key) != -1)) {

					/// 定位位置
					System.out.println("====开始编号=======");
					System.out.println(s.indexOf(key));
					System.out.println("====结束编码======= ");
					/// 定位位置结束
					String searchColor = colorFont.get("searchColor");
					s = this.setkeyColor(s, key,searchColor);
					if (firstFlag) {
						isfindKeyFlag = true;
					}
					/// 如果有关键字就设置颜色
				}

				// if ((!isfindKeyFlag) && s.matches("(.*)" + key + "(.*)")) {
				// s = this.SetFontRed(s);
				// if (firstFlag) {
				// isfindKeyFlag = true;
				// }
				// /// 如果有关键字就设置颜色
				// } else if (s.matches("(.*)Target(.*)") ||
				// s.matches("(.*)Value(.*)") || s.matches("(.*)Param(.*)")) {
				// s = this.SetFontBule(s);
				// }
				result.append(System.lineSeparator() + s + "<br/><br/>");
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result.toString();
	}

	public static void main(String[] args) throws UnsupportedEncodingException {
		String path = "D:/Error.log";
		// System.out.println(new LogView().displayLogs(path, ""));
		// System.out.println(new LogView().displaySearchKeylogs(path,
		// "DB相应密码",""));

		/*HashMap<String, String> colorMap = new HashMap<String, String>();

		colorMap.put("keyColor", "pure");
		colorMap.put("paramColor", "bule");
		colorMap.put("valueColor", "yellow");
		colorMap.put("targetColor", "red");
		Gson gsonStr = new Gson();*/
		
		
		// String aString = gsonStr.fromJson(gsonStr.toJson(colorMap),new
		// HashMap().getClass()).get("keyColor");
		// String string = str.get
		// System.out.println(aString);

		/*
		 * colorMap.put("paramColor", "red"); colorMap.put("paramColor", "red");
		 * colorMap.put("paramColor", "red"); colorMap.put("paramColor", "red");
		 * colorMap.put("paramColor", "red"); colorMap.put("paramColor", "red");
		 */
		System.out.println(new LogView().displaySearchAllKeyslogs(path, "DB相应密码", "0"));

		/// System.out.println(new LogView().findKeyLogs(path, "Param", true));

	}

}
