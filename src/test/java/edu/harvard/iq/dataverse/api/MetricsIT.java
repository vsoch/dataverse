package edu.harvard.iq.dataverse.api;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import edu.harvard.iq.dataverse.metrics.MetricsUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import static javax.ws.rs.core.Response.Status.OK;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

public class MetricsIT {

    @BeforeClass
    public static void setUpClass() {
        RestAssured.baseURI = UtilIT.getRestAssuredBaseUri();
    }
    
    @Test
    public void testCachingInDataverseByCategory() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date = new Date();
        System.out.println("Before first" + dateFormat.format(date));
        Response response = UtilIT.metricsDataverseByCategory();
        response.then().assertThat()
                .statusCode(OK.getStatusCode());
        date = new Date();
        System.out.println("After first" + dateFormat.format(date));
        response.prettyPrint();
    }

    @Test
    public void testGetDataverseByCategory() {
        Response response = UtilIT.metricsDataverseByCategory();
        response.prettyPrint();
        response.then().assertThat()
                .statusCode(OK.getStatusCode());
    }

    @Test
    public void testGetDataversesByMonth() {
        String yyyymm = "2018-04";
        Response response = UtilIT.metricsDataversesByMonth(yyyymm);
        response.prettyPrint();
        response.then().assertThat()
                .statusCode(OK.getStatusCode());
    }

    @Test
    public void testGetDownloadsByMonth() {
        String yyyymm = "2018-04";
        Response response = UtilIT.metricsDownloadsByMonth(yyyymm);
        response.prettyPrint();
        response.then().assertThat()
                .statusCode(OK.getStatusCode());
    }

    @Test
    public void testGetFilesByMonth() {
        String yyyymm = "2018-04";
        Response response = UtilIT.metricsFilesByMonth(yyyymm);
        response.prettyPrint();
        response.then().assertThat()
                .statusCode(OK.getStatusCode());
    }

    @Test
    public void testGetDatasetsByMonth() {
        String yyyymm = "2018-04";
        Response response = UtilIT.metricsDatasetsByMonth(yyyymm);
        response.prettyPrint();
        response.then().assertThat()
                .statusCode(OK.getStatusCode());
    }

    @Test
    public void testGetDatasetsBySubject() {
        Response response = UtilIT.metricsDatasetsBySubject();
        response.prettyPrint();
        response.then().assertThat()
                .statusCode(OK.getStatusCode());
    }

}
