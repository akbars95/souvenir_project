package com.mtsmda.souvenir.tests;

import com.mtsmda.souvenir.external.ws.ExchangeRateBNMMD;
import com.mtsmda.souvenir.model.xml.ValCurs;
import com.mtsmda.souvenir.model.xml.Valute;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MTSMDA on 10.05.2016.
 */
public class BNMMD {

    public static void main(String[] args) throws IOException {
        File file = new File("exchangeRate.xml");
        if (!file.exists()) {
            file.createNewFile();
        }
//        RestTemplate restTemplate = new RestTemplate();
        String forObject = new ExchangeRateBNMMD().getActualRateFromBNM();//restTemplate.getForObject("http://bnm.md/ro/official_exchange_rates?get_xml=1&date=10.05.2016", String.class);
        System.out.println(forObject);

        Writer writer = new FileWriter(file);
        writer.write(forObject);
        writer.close();

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ValCurs.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            ValCurs valCurs = (ValCurs) jaxbUnmarshaller.unmarshal(file);
            System.out.println(valCurs.getValutes().size());
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*ValCurs valCurs = new ValCurs();
        valCurs.setDate("10.05.2016");
        valCurs.setName("Cursul oficial de schimb");

        Valute valute = new Valute();
        valute.setName("Euro");
        valute.setCharCode("EUR");
        valute.setNominal(1);
        valute.setNumCode(978);
        valute.setValue(22.6432);
        valute.setValuteId(47);

        List<Valute> valuteList = new ArrayList<>();
        valuteList.add(valute);
        valCurs.setValutes(valuteList);

        try

        {
            JAXBContext jaxbContext = JAXBContext.newInstance(ValCurs.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(valCurs, file);
            jaxbMarshaller.marshal(valCurs, System.out);

        }

        catch(
                JAXBException e
                )

        {
            e.printStackTrace();
        }*/

    }


}