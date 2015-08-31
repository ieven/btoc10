package com.multipless.egogoal.btoc.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * @author ChenKai
 * @date 2015年8月31日
 */
public class XMLUtil {
	public static Map<String, String> getPostDataToMap(String postData) throws Exception{
		Map<String, String> retMap = new HashMap<String, String>() ;
		
		Document doc = DocumentHelper.parseText(postData) ;
		Element rootEle = doc.getRootElement() ;
		
		//取得当前节点下所有子节点信息
		List<?> eleList = rootEle.elements() ;
		
		for (Iterator<?> iterator = eleList.iterator(); iterator.hasNext();) {
			Element element = (Element) iterator.next();
			retMap.put(element.getName(), element.getTextTrim()) ;
		}

		return retMap ;
	}
	public static void main(String[] args) throws Exception {
//		String s = "<xml><OpenId><![CDATA[111222]]></OpenId><AppId><![CDATA[wwwwb4f85f3a797777]]></AppId><IsSubscribe>1</IsSubscribe> <ProductId><![CDATA[777111666]]></ProductId><TimeStamp>1369743908</TimeStamp><NonceStr><![CDATA[YvMZOX28YQkoU1i4NdOnlXB1]]></NonceStr><AppSignature><![CDATA[a9274e4032a0fec8285f147730d88400392acb9e]]></AppSignature><SignMethod><![CDATA[sha1]]></SignMethod></xml>";
		String s = "<xml><OpenId>111222</OpenId><AppId>wwwwb4f85f3a797777</AppId><IsSubscribe>1</IsSubscribe> <ProductId>777111666</ProductId><TimeStamp>1369743908</TimeStamp><NonceStr>YvMZOX28YQkoU1i4NdOnlXB1</NonceStr><AppSignature>9274e4032a0fec8285f147730d88400392acb9e</AppSignature><SignMethod>sha1</SignMethod></xml>";
		Map<String, String> postDataToMap = getPostDataToMap(s);
		System.out.println(postDataToMap);
	}
}
