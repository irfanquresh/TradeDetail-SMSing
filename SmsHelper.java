/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.trillit;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;

/**
 *
 * @author IRFAN
 */
class SmsHelper {
    
    Setting s= null;
    SmsHelper(Setting setting) {
        this.s=setting;
    }
    public void sendSMS(String phone,String Messgae) {
        try {
            String username = s.getUserName();
            String userid=s.getSenderId();
            String password = s.getPassword();
            Date mydate = new Date(System.currentTimeMillis());
            String data = "";
            data += "Mask="+userid;
            data += "&UserName="+username; // your loginId 
            data += "&Password=" + URLEncoder.encode(password, "UTF-8"); // your password 
            data += "&Message=" + URLEncoder.encode(Messgae, "UTF-8");
            data += "&To=" + URLEncoder.encode(phone, "UTF-8"); // a valid 10 digit phone no. 
            data += "&v=1.1" ; 
            data += "&Type=Individual"; // Can be "Bulk" or "Group" 
            URL url = new URL("http://www.abc.com/library/send_sms_2.php?" + data);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.connect();
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            StringBuffer buffer = new StringBuffer();
            while ((line = rd.readLine()) != null) {
                buffer.append(line).append("\n");
            }
            System.out.println(buffer.toString());
            rd.close();
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
