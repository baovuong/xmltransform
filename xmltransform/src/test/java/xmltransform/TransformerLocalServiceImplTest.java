package xmltransform;

import org.custommonkey.xmlunit.XMLAssert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TransformerLocalServiceImplTest {

    TransformerLocalService transformerService = new TransformerLocalServiceImpl();

    @BeforeClass
    public static void setUp() throws Exception {
        XMLUnitUtil.setupXMLUnit();

    }

    @Test
    public void testTransformInput() throws Exception {
        String inputString = readFile(this.getClass().getResource("/transformer-xml-input.xml").toURI());
        String expectedOutput = readFile(this.getClass().getResource("/transformer-xml-output.xml").toURI());
        InputStream transformer = new ByteArrayInputStream(readFile(this.getClass().getResource("/transformer-xslt.xslt").toURI()).getBytes(StandardCharsets.UTF_8));
        String outputString = transformerService.transformInput(inputString, transformer );

        XMLAssert.assertXMLEqual(expectedOutput, outputString);

    }

    static String readFile(URI path)
            throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, "UTF-8");
    }


    @Test
    public void testXMLUnit() throws Exception {
        String myControlXML = "<struct>" +
                "       <int>3</int>" +
                "\n <boolean>false</boolean>" +
                "  </struct>";

        String myTestXML = "<struct><boolean>false</boolean><int>3</int></struct>";
        XMLAssert.assertXMLEqual("comparing test xml to control xml", myControlXML, myTestXML);

    }

}