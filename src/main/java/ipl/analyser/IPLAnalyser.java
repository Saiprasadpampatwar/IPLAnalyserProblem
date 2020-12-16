package ipl.analyser;

import com.google.gson.Gson;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import jar.builder.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class IPLAnalyser {

    public static final String TOP_BATTING_AVG_FILE = "C:\\Users\\saiprasad\\IdeaProjects\\IPLAnaluser\\IPLAnaluser\\src\\test\\resources\\TopBattingAvg.json";
    private static final String TOP_STRIKE_RATE_FILE = "C:\\Users\\saiprasad\\IdeaProjects\\IPLAnaluser\\IPLAnaluser\\src\\test\\resources\\TopStrikeRate.json";
    public static List<IPLBatsmanStats> iplBatsmanStats;
    public static List<IPLBowlerStats> iplBowlerStats;

    public int loadIplBatsmanStat(String csvFilePath) throws IPLAnalyserException {
        try(Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
        CSVReader csvReader = new CSVReader(reader);){

            iplBatsmanStats = getCSVFileList(reader,IPLBatsmanStats.class);
            return  iplBatsmanStats.size();
        } catch (IOException| RuntimeException e ) {
            throw new IPLAnalyserException(e.getMessage(),IPLAnalyserException.ExceptionType.IPL_FILE_PROBLEM);
        }

    }

    public int loadIplBowlerStat(String csvFilePath) throws IPLAnalyserException {
        try(Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
            CSVReader csvReader = new CSVReader(reader);){

            iplBowlerStats = getCSVFileList(reader,IPLBowlerStats.class);
            return  iplBowlerStats.size();
        } catch (IOException| RuntimeException e ) {
            throw new IPLAnalyserException(e.getMessage(),IPLAnalyserException.ExceptionType.IPL_FILE_PROBLEM);
        }

    }

    public <E>List getCSVFileList(Reader reader, Class csvClass)  {

        CsvToBeanBuilder<E> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
        csvToBeanBuilder.withType(csvClass);
        csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
        CsvToBean<E> csvToBean = csvToBeanBuilder.build();
        return csvToBean.parse();
    }

    public void sortingBasedOnBattingAverage() throws IOException {
        Comparator com = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                IPLBatsmanStats b1 = (IPLBatsmanStats)o1;
                IPLBatsmanStats b2 = (IPLBatsmanStats)o2;
                if(b1.getAverage()>b2.getAverage())
                    return -3;
                else
                    return 3;
            }
        };
        Collections.sort(iplBatsmanStats,com);
        Gson gson = new Gson();
        String json =gson.toJson(iplBatsmanStats);
        FileWriter fileWriter = new FileWriter(TOP_BATTING_AVG_FILE);
        fileWriter.write(json);
        fileWriter.close();
    }

    public void sortingBasedOnStrikeRate() throws IOException {
        Comparator com = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                IPLBatsmanStats b1 = (IPLBatsmanStats)o1;
                IPLBatsmanStats b2 = (IPLBatsmanStats)o2;
                if(b1.getStrikeRate()>b2.getStrikeRate())
                    return -3;
                else
                    return 3;
            }
        };
        Collections.sort(iplBatsmanStats,com);
        Gson gson = new Gson();
        String json =gson.toJson(iplBatsmanStats);
        FileWriter fileWriter = new FileWriter(TOP_STRIKE_RATE_FILE);
        fileWriter.write(json);
        fileWriter.close();
    }
}
