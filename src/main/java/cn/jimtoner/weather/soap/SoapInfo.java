package cn.jimtoner.weather.soap;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

/**
 * Created by jimtoner on 08/11/2016.
 * Array(0) = "省份 地区/洲 国家名（国外）"
 * Array(1) = "查询的天气预报地区名称"
 * Array(2) = "查询的天气预报地区ID"
 * Array(3) = "最后更新时间 格式：yyyy-MM-dd HH:mm:ss"
 * Array(4) = "当前天气实况：气温、风向/风力、湿度"
 * Array(5) = "第一天 空气质量、紫外线强度"
 * Array(6) = "第一天 天气和生活指数"
 * Array(7) = "第一天 概况 格式：M月d日 天气概况"
 * Array(8) = "第一天 气温"
 * Array(9) = "第一天 风力/风向"
 * Array(10) = "第一天 天气图标 1"
 * Array(11) = "第一天 天气图标 2"
 * Array(12) = "第二天 概况 格式：M月d日 天气概况"
 * Array(13) = "第二天 气温"
 * Array(14) = "第二天 风力/风向"
 * Array(15) = "第二天 天气图标 1"
 * Array(16) = "第二天 天气图标 2
 */
public class SoapInfo {
    private ArrayList<String> mResults = new ArrayList<String>();

    public void parse(NodeList weatherResult) {
        mResults.clear();
        for (int i = 0, size = weatherResult.getLength(); i < size; ++i) {
            Node n = weatherResult.item(i);
            mResults.add(n.getFirstChild().getNodeValue());
        }
    }

    public void fill(WeatherInfo weatherInfo) {

    }
}
