package xmltransform;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class TransformerLocalServiceImpl implements TransformerLocalService {
	public String transformInput(String inputXML, InputStream transformerContents) throws TransformerException, UnsupportedEncodingException {
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer t = tf.newTransformer(new StreamSource(transformerContents));
        t.setOutputProperty(OutputKeys.INDENT, "yes");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        t.transform(new StreamSource(new StringReader(inputXML)), new StreamResult(new OutputStreamWriter(outputStream, "utf-8")));
        return new String(outputStream.toByteArray(), "UTF-8");
    }

}
