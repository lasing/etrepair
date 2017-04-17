package com.liveneo.etrepair.common;

import java.io.StringWriter;
import java.io.Writer;
import java.util.List;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.CompactWriter;

public class XStreamUtil {
    public static XStream getStream() {
        return new XStream();
    }

    public static <T> String toXML(Object obj, Class<T> clazz, List<String> list) {
        XStream stream = XStreamUtil.getStream();
        stream.processAnnotations(clazz);
        Writer writer = new StringWriter();
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                stream.omitField(clazz, list.get(i));
            }
        }
        stream.marshal(obj, new CompactWriter(writer));
        return writer.toString();
    }

    public static <T> T fromXML(String xml, Class<T> clazz) {
        XStream stream = XStreamUtil.getStream();
        stream.processAnnotations(clazz);
        stream.ignoreUnknownElements();
        Object obj = stream.fromXML(xml);
        try {
            return clazz.cast(obj);
        } catch (ClassCastException e) {
            return null;
        }
    }
}
