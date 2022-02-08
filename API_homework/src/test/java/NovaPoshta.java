import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@Test
public class NovaPoshta {
    private static org.apache.log4j.Logger log = Logger.getLogger(NovaPoshta.class);

    //1 - проверяем, что данной наклодной не существует
    public void trackingDocument() throws IOException {
        BasicConfigurator.configure();
        String uri = "https://api.novaposhta.ua/v2.0/json/";

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(uri);
        String json = "{\n" +
                "    \"apiKey\": \"eeff06636b156bd6bf732c288d088766\",\n" +
                "    \"modelName\": \"TrackingDocument\",\n" +
                "    \"calledMethod\": \"getStatusDocuments\",\n" +
                "    \"methodProperties\": {\n" +
                "        \"Documents\": [\n" +
                "            {\n" +
                "                \"DocumentNumber\": \"20400048799000\",\n" +
                "                \"Phone\":\"\"\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "    \n" +
                "}";

        StringEntity stringEntity = new StringEntity(json);
        httpPost.setEntity(stringEntity);
        httpPost.setHeader("Accept","application/json");
        httpPost.setHeader("Content-type", "application/json");
        CloseableHttpResponse response = httpClient.execute(httpPost);

        assertThat(response.getStatusLine().getStatusCode(),equalTo(200));

        HttpEntity entity = response.getEntity();
        if(entity!=null) {
            String data = IOUtils.toString(entity.getContent(),"utf8");
            log.info("Data: " + data);
            DocumentContext docCtx = JsonPath.parse(data);
            JSONArray jsonArray = docCtx.read("$..Status");
            assertThat(jsonArray,contains("Номер не найден"));

        } else {
            log.info("Empty response");
        }

    }

    // 2 - проверка, что рассчёт цены поссылки успешный
    @Test
    public void getDocumentPrice() throws IOException {
        BasicConfigurator.configure();
        String uri = "https://api.novaposhta.ua/v2.0/json/";

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(uri);
        String json = "{\n" +
                "  \"modelName\": \"InternetDocument\",\n" +
                "  \"calledMethod\": \"getDocumentPrice\",\n" +
                "  \"methodProperties\": {\n" +
                "    \"CitySender\": \"8d5a980d-391c-11dd-90d9-001a92567626\",\n" +
                "    \"CityRecipient\": \"db5c88e0-391c-11dd-90d9-001a92567626\",\n" +
                "    \"Weight\": \"10\",\n" +
                "    \"ServiceType\": \"WarehouseWarehouse\",\n" +
                "    \"Cost\": \"100\",\n" +
                "    \"CargoType\": \"Cargo\",\n" +
                "    \"SeatsAmount\": \"1\",\n" +
                "    \"RedeliveryCalculate\": {\n" +
                "      \"CargoType\": \"Money\",\n" +
                "      \"Amount\": \"100\"\n" +
                "    },\n" +
                "    \"OptionsSeat\": [\n" +
                "      {\n" +
                "        \"weight\": 5,\n" +
                "        \"volumetricWidth\": 20,\n" +
                "        \"volumetricLength\": 25,\n" +
                "        \"volumetricHeight\": 25,\n" +
                "        \"packRef\": \"f6f72e4d-5daf-11e3-b441-0050568002cf\"\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "}";

        StringEntity stringEntity = new StringEntity(json);
        httpPost.setEntity(stringEntity);
        httpPost.setHeader("Accept","application/json");
        httpPost.setHeader("Content-type", "application/json");
        CloseableHttpResponse response = httpClient.execute(httpPost);

        assertThat(response.getStatusLine().getStatusCode(),equalTo(200));

        HttpEntity entity = response.getEntity();
        if(entity!=null) {
            String data = IOUtils.toString(entity.getContent(),"utf8");
            log.info("Data: " + data);
            DocumentContext docCtx = JsonPath.parse(data);
            JSONArray jsonArray = docCtx.read("$..success");
            assertThat(jsonArray,contains(true));

        } else {
            log.info("Empty response");
        }
    }

    //3 ориентировачная дата доставки
    @Test
    public void getDocumentDeliveryDate() throws IOException {
        BasicConfigurator.configure();
        String uri = "https://api.novaposhta.ua/v2.0/json/";

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(uri);
        String json = " {\n" +
                " \"apiKey\": \"eeff06636b156bd6bf732c288d088766\",\n" +
                " \"modelName\": \"InternetDocument\",\n" +
                " \"calledMethod\": \"getDocumentDeliveryDate\",\n" +
                " \"methodProperties\": {\n" +
                " \"DateTime\": \"09.02.2022\",\n" +
                " \"ServiceType\": \"WarehouseDoors\",\n" +
                " \"CitySender\": \"8d5a980d-391c-11dd-90d9-001a92567626\",\n" +
                " \"CityRecipient\": \"8d5a980d-391c-11dd-90d9-001a92567626\"\n" +
                " }\n" +
                "}";

        StringEntity stringEntity = new StringEntity(json);
        httpPost.setEntity(stringEntity);
        httpPost.setHeader("Accept","application/json");
        httpPost.setHeader("Content-type", "application/json");
        CloseableHttpResponse response = httpClient.execute(httpPost);

        assertThat(response.getStatusLine().getStatusCode(),equalTo(200));

        HttpEntity entity = response.getEntity();
        if(entity!=null) {
            String data = IOUtils.toString(entity.getContent(),"utf8");
            log.info("Data: " + data);
            DocumentContext docCtx = JsonPath.parse(data);

            JSONArray jsonArray = docCtx.read("$..success");
            assertThat(jsonArray,contains(true));

            jsonArray = docCtx.read("$..timezone");
            assertThat(jsonArray,contains("Europe/Kiev"));

        } else {
            log.info("Empty response");
        }
    }

}
