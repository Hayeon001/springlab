package com.kbstar.util;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Value;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class OCRUtil {  //spring container 위에서 구동하는거 아님.


    public static Object getResult(String imgpath, String imgname){

        JSONObject obj = null;

        //clova OCR
        String apiURL = "https://uhucar79op.apigw.ntruss.com/custom/v1/22514/6d0f5eecbe0eae9bc3cfecd6aee96995f2ab203584325fa5d2d120406de0c4ac/infer";
        String secretKey = "b1dXbFhJaWJGZ0hxS2VTS2hvRVhoZ2JmYkZWSXVSbkQ=";
        String imageFile = imgpath+imgname;

        try {
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setUseCaches(false);
            con.setDoInput(true);
            con.setDoOutput(true);
            con.setReadTimeout(30000);
            con.setRequestMethod("POST");
            String boundary = "----" + UUID.randomUUID().toString().replaceAll("-", "");
            con.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            con.setRequestProperty("X-OCR-SECRET", secretKey);

            JSONObject json = new JSONObject();
            json.put("version", "V2");
            json.put("requestId", UUID.randomUUID().toString());
            json.put("timestamp", System.currentTimeMillis());
            JSONObject image = new JSONObject();
            image.put("format", "jpg");
            image.put("name", "demo");
            JSONArray images = new JSONArray();

            images.add(image);
            json.put("images", images);
            String postParams = json.toString();

            con.connect();
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            long start = System.currentTimeMillis();
            File file = new File(imageFile);
            writeMultiPart(wr, postParams, file, boundary);
            wr.close();

            int responseCode = con.getResponseCode();
            BufferedReader br;
            if (responseCode == 200) {
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();

            //response에 결과가 내려온것. String형태
            JSONParser parser = new JSONParser();
            obj = (JSONObject) parser.parse(response.toString());

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return obj;
    }

    private static void writeMultiPart(OutputStream out, String jsonMessage, File file, String boundary) throws
            IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("--").append(boundary).append("\r\n");
        sb.append("Content-Disposition:form-data; name=\"message\"\r\n\r\n");
        sb.append(jsonMessage);
        sb.append("\r\n");

        out.write(sb.toString().getBytes("UTF-8"));
        out.flush();

        if (file != null && file.isFile()) {
            out.write(("--" + boundary + "\r\n").getBytes("UTF-8"));
            StringBuilder fileString = new StringBuilder();
            fileString
                    .append("Content-Disposition:form-data; name=\"file\"; filename=");
            fileString.append("\"" + file.getName() + "\"\r\n");
            fileString.append("Content-Type: application/octet-stream\r\n\r\n");
            out.write(fileString.toString().getBytes("UTF-8"));
            out.flush();

            try (FileInputStream fis = new FileInputStream(file)) {
                byte[] buffer = new byte[8192];
                int count;
                while ((count = fis.read(buffer)) != -1) {
                    out.write(buffer, 0, count);
                }
                out.write("\r\n".getBytes());
            }

            out.write(("--" + boundary + "--\r\n").getBytes("UTF-8"));
        }
        out.flush();
    }

    //파싱 할 위치
    public static Map getData(JSONObject obj){
        Map <String, String> map = new HashMap<>();
        JSONArray images = (JSONArray) obj.get("images");
        JSONObject obj1 = (JSONObject) images.get(0);
        JSONArray fields = (JSONArray) obj1.get("fields");

        JSONObject biznum_obj = (JSONObject) fields.get(0);
        String biznum = (String) biznum_obj.get("inferText");

        JSONObject bizname_obj = (JSONObject) fields.get(1);
        String bizname = (String) bizname_obj.get("inferText");

        JSONObject bizowner_obj = (JSONObject) fields.get(2);
        String bizowner = (String) bizowner_obj.get("inferText");

        JSONObject bizdate_obj = (JSONObject) fields.get(3);
        String bizdate = (String) bizdate_obj.get("inferText");

        JSONObject bizadd_obj = (JSONObject) fields.get(4);
        String bizadd = (String) bizadd_obj.get("inferText");

        map.put("biznum",biznum);
        map.put("bizname",bizname);
        map.put("bizowner",bizowner);
        map.put("bizdate",bizdate);
        map.put("bizadd",bizadd);

        return map;
    }

    public static Map getBab(JSONObject obj){
        Map <String, String> map = new HashMap<>();
        JSONArray images = (JSONArray) obj.get("images");
        JSONObject obj1 = (JSONObject) images.get(0);
        JSONArray fields = (JSONArray) obj1.get("fields");

        JSONObject date_obj = (JSONObject) fields.get(0);
        String date = (String) date_obj.get("inferText");

        JSONObject time_obj = (JSONObject) fields.get(1);
        String time = (String) time_obj.get("inferText");

        JSONObject mainmenu_obj = (JSONObject) fields.get(2);
        String mainmenu = (String) mainmenu_obj.get("inferText");

        JSONObject sidemenu_obj = (JSONObject) fields.get(3);
        String sidemenu = (String) sidemenu_obj.get("inferText");

        map.put("date",date);
        map.put("time",time);
        map.put("mainmenu",mainmenu);
        map.put("sidemenu",sidemenu);

        return map;
    }
}
