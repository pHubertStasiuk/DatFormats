package model.xml.jaxb;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.math.BigDecimal;

public class BigDecimalAdapter extends XmlAdapter<String, BigDecimal> {

    public BigDecimal unmarshal(String s) throws Exception {
        return new BigDecimal(s);
    }

    public String marshal(BigDecimal bigDecimal) throws Exception {
        return bigDecimal.toPlainString();
    }
}
