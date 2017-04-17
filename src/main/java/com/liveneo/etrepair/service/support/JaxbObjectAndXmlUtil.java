package com.liveneo.etrepair.service.support;

import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * 使用 jaxb 做对象和 xml 之间的转换工具
 * 
 * @author fcy
 *
 */
public class JaxbObjectAndXmlUtil {
    /**
     * xml转换成对象
     * @param xmlStr
     * @param type
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T xml2Object(String xmlStr, Class<T> type) {
        T t = null;
        try {
            JAXBContext context = JAXBContext.newInstance(type);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            t = (T) unmarshaller.unmarshal(new StringReader(xmlStr));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        return t;
    }

    /**
     * 对象转换成xml文件
     * @param object
     * @return
     */
    public static String object2Xml(Object object) {
        StringWriter writer = new StringWriter();
        try {
            JAXBContext context = JAXBContext.newInstance(object.getClass());
            Marshaller marshal = context.createMarshaller();
            marshal.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // 格式化输出
            marshal.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");// 编码格式,默认为utf-8
            marshal.setProperty(Marshaller.JAXB_FRAGMENT, false);// 是否省略xml头信息
            marshal.setProperty("jaxb.encoding", "utf-8");
            marshal.marshal(object, writer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new String(writer.getBuffer());
    }
}
