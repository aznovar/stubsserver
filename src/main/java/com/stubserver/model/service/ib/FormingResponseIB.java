package com.stubserver.model.service.ib;

import com.stubserver.helpers.DateGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.stubserver.helpers.FileReader.getStringFromFile;
import static com.stubserver.helpers.XmlUtils.*;

@Service
@Slf4j
public class FormingResponseIB implements IbRemote<String> {

    private static String currentDate = DateGenerator.getDate("yyyy-MM-dd hh:mm:ss aa");
    private static String startTime = DateGenerator.getDate("yyyy-MM-dd hh:mm:ssss aa");
    private static String stopTime = DateGenerator.getDateWithMills("yyyy-MM-dd hh:mm:ssss aa", 680);

    @Override
    public String formingResponse(String requestString) throws Exception {

        String requestXML = evaluateXpath(requestString, "//aXMLInput");
        log.info("EVALUATED XPATH HERE: " + requestXML);
        String correlationId = evaluateXpath(requestXML, "//m[@n='CorrelationId']/@v");
        String policyPeriodID = evaluateXpath(requestXML, "//program/@policyPeriod_id");

        String responsestring = getStringFromDocumentForCDATA("src/main/resources/stubdata/ib/resp_1.xml");
        if (requestString.contains("program_id=\"71\"") && requestString.contains("n=\"GWOfferingTypeId\" v=\"MACCIDENTPROTECTION\"")) {
            responsestring = getStringFromDocumentForCDATA("src/main/resources/stubdata/ib/resp_1.xml");
        }
        if (requestString.contains("program_id=\"71\"") && requestString.contains("n=\"GWOfferingTypeId\" v=\"MAUTOPROTECTION\"")
                && requestString.contains("n=\"InsurantSecondName\" v=\"АНДЕРРАЙТОВИЧ\"")) {
            responsestring = getStringFromDocumentForCDATA("src/main/resources/stubdata/ib/resp_3.xml");
        }
        if (requestString.contains("program_id=\"71\"") && requestString.contains("n=\"GWOfferingTypeId\" v=\"MANTICRISIS\"")) {
            responsestring = getStringFromDocumentForCDATA("src/main/resources/stubdata/ib/resp_3.xml"); //replace this
        }
        if (requestString.contains("program_id=\"14\"")) {
            responsestring = getStringFromDocumentForCDATA("src/main/resources/stubdata/ib/resp_2.xml");
        }
        if (requestString.contains("program_id=\"35\"") || requestString.contains("n=\"CancelReasonId\"")) {
            responsestring = getStringFromDocumentForCDATA("src/main/resources/stubdata/ib/respCancel.xml");
        }
        responsestring = formOutputXml(responsestring, correlationId, policyPeriodID);
        return responsestring;
    }

    private static String formOutputXml(String responsestring, String correlationId, String policyPeriodID) throws Exception {
        String responseTemplate = getStringFromFile("src/main/resources/stubdata/ib/IB_expected.xml");
        responsestring = setElement("//m[@i='CORRELATIONID']/@v", responsestring, correlationId);
        responsestring = setElement("//program/@policyPeriod_id", responsestring, policyPeriodID);
        responsestring = setElement("//result/@gen_date", responsestring, currentDate);
        responsestring = setElement("//stats/stop_time", responsestring, stopTime);
        responsestring = setElement("//stats/start_time", responsestring, startTime);
        responsestring = setElement("//return", responseTemplate, responsestring);
        return responsestring;
    }
}
