package cn.jimtoner.weather;

import cn.jimtoner.weather.soap.SoapParser;
import cn.jimtoner.weather.soap.WeatherInfo;
import cn.jimtoner.weather.soap.WeatherSoap;

import java.io.InputStream;

/**
 * @ClassName WeatherReporter
 * @Description TODO 天气信息数据来源(http://www.webxml.com.cn/)
 * 根据城市或地区名称查询获得未来三天内天气情况、现在的天气实况、天气和生活指数:
 * 调用方法如下：输入参数：theCityName = 城市中文名称(国外城市可用英文)或城市代码(不输入默认为上海市)，如：上海 或 58367，如有
 * 城市名称重复请使用城市代码查询(可通过 getSupportCity 或 getSupportDataSet 获得)；返回数据： 一个一维数组 String(22)，共有
 * 23个元素。String(0) 到 String(4)：省份，城市，城市代码，城市图片名称，最后更新时间。String(5) 到 String(11)：当天的 气温，
 * 概况，风向和风力，天气趋势开始图片名称(以下称：图标一)，天气趋势结束图片名称(以下称：图标二)，现在的天气实况，天气和生活
 * 指数。String(12) 到String(16)：第二天的 气温，概况，风向和风力，图标一，图标二。String(17) 到 String(21)：第三天的 气温，
 * 概况，风向和风力，图标一，图标二。String(22) 被查询的城市或地区的介绍
 * @author zyj jayzh1993@gmail.com
 * @date 2013-10-14
 */
public class WeatherReporter {
	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
        WeatherSoap soap = new WeatherSoap();
        InputStream inputStream = soap.getSoapInputStream("广州");
        SoapParser parser = new SoapParser();
        WeatherInfo weatherInfo = parser.parseWeather(inputStream);
		System.out.println(weatherInfo);
	}
}