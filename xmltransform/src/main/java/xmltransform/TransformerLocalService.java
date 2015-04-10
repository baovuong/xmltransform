package xmltransform;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.xml.transform.TransformerException;

public interface TransformerLocalService {
	public String transformInput(String inputXML, InputStream transformerContents) throws TransformerException, UnsupportedEncodingException;
}
