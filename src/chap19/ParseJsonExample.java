package chap19;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class ParseJsonExample {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new FileReader("C:/Temp/member.json", Charset.forName("UTF-8")));
        String json = br.readLine();
        br.close();

        JSONObject root = new JSONObject(json);

        System.out.println(root);

        JSONObject tell = root.getJSONObject("tel");
        System.out.println(tell.getString("mobile"));

        JSONArray skill = root.getJSONArray("skill");
        System.out.println(skill);

    }
}
