package com.yourcompany;

import org.json.*;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import java.io.IOException;
import static org.junit.Assert.*;


/**
 * Demonstrates how to write a JUnit test that test an API
 *
 * @author Neil Manvar
 */
public class SampleSauceTest {

    @Test
    public void testPriceLineAutosuggestSanFrancisco()
          throws ClientProtocolException, IOException, JSONException{
       HttpUriRequest request = new HttpGet( "http://www.priceline.com/svcs/ac/index/hotels/san/6/3/3/3" );

       HttpResponse httpResponse =	 HttpClientBuilder.create().build().execute( request );

       String bodyAsString = EntityUtils.toString(httpResponse.getEntity());

       JSONObject obj = new JSONObject(bodyAsString);

       String itemName = obj.getJSONArray("searchItems").getJSONObject(0).getString("itemName");

       assertEquals("San Francisco, CA", itemName);
    }

    @Test
    public void testPriceLineAutosuggestSanDiego()
          throws ClientProtocolException, IOException, JSONException{
       HttpUriRequest request = new HttpGet( "http://www.priceline.com/svcs/ac/index/hotels/diego/6/3/3/3" );

       HttpResponse httpResponse =   HttpClientBuilder.create().build().execute( request );

       String bodyAsString = EntityUtils.toString(httpResponse.getEntity());

       JSONObject obj = new JSONObject(bodyAsString);

       String itemName = obj.getJSONArray("searchItems").getJSONObject(0).getString("itemName");

       assertEquals("San Diego, CA", itemName);
    }

}
