package test;

import loader.DataLoader;
import graql.lang.statement.Statement;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class TestUtil {

    public static LocalDateTime getDT(String dtString) {
        DateTimeFormatter isoDateFormatter = DateTimeFormatter.ISO_DATE;
        String[] dt = dtString.split("T");
        LocalDate date = LocalDate.parse(dt[0], isoDateFormatter);
        if (dt.length > 1) {
            LocalTime time = LocalTime.parse(dt[1], DateTimeFormatter.ISO_TIME);
            return date.atTime(time);
        } else {
            return date.atStartOfDay();
        }
    }

    public static ArrayList<String> getData(String path) {
        ArrayList<String> rows = new ArrayList<>();
        InputStream es = DataLoader.getInputStream(path);
        if (es != null) {
            String line;
            try (BufferedReader br = new BufferedReader(new InputStreamReader(es))) {
                while ((line = br.readLine()) != null) {
                    rows.add(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return rows;
    }

    public static String concatMatches(ArrayList<Statement> statements) {
        String ret = "";
        for (Statement st :
                statements) {
            ret = ret + st.toString();
        }
        return ret;
    }
}
