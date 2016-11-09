package cn.jimtoner.weather.soap;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

/**
 * Created by jimtoner on 05/11/2016.
 */
public class SoapParser {

    public WeatherInfo parseWeather(InputStream weather) {
        WeatherInfo weatherInfo = new WeatherInfo();
        InputStream is = weather;
        SoapInfo info = getWeather(is);
        info.fill(weatherInfo);

        return weatherInfo;
    }

    /**
     * 对服务器端返回的XML进行解析
     * @return 字符串 用#分割
     */
    public static SoapInfo getWeather(InputStream is) {
        try {
            Document doc;
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.parse(is);
            NodeList nl = doc.getElementsByTagName("string");
            SoapInfo soapInfo = new SoapInfo();
            soapInfo.parse(nl);
//            StringBuffer sb = new StringBuffer();
//            for (int count = 0; count < nl.getLength(); count++) {
//                Node n = nl.item(count);
//                if(n.getFirstChild().getNodeValue().equals("查询结果为空！")) {
//                    sb = new StringBuffer("#") ;
//                    break ;
//                }
//                sb.append(n.getFirstChild().getNodeValue() + "#");
//            }
            is.close();
            return soapInfo;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
