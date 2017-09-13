package edureka.DataDriven;

import java.util.HashMap;

public class HashMapTest {
	
	public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        HashMap<String,String> map = new HashMap<String, String>();
        map.put("FaceBookloginUrl", "facebook.com");
        map.put("AmazonUrl", "amazon.com");
        map.put("browser", "firefox,chrome");
        
        System.out.println(map.get("AmazonUrl"));
        
        
    }

}
