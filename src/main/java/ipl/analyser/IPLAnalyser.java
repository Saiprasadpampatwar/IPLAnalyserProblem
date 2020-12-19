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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class IPLAnalyser {

    public static final String TOP_BATTING_AVG_FILE = "C:\\Users\\saiprasad\\IdeaProjects\\IPLAnaluser\\IPLAnaluser\\src\\test\\resources\\TopBattingAvg.json";
    private static final String TOP_STRIKE_RATE_FILE = "C:\\Users\\saiprasad\\IdeaProjects\\IPLAnaluser\\IPLAnaluser\\src\\test\\resources\\TopStrikeRate.json";
    private static final String TOP_4S_6S_FILE = "C:\\Users\\saiprasad\\IdeaProjects\\IPLAnaluser\\IPLAnaluser\\src\\test\\resources\\Top4s6s.json";
    public static List<IPLBatsmanStats> iplBatsmanStatsList;
    public static List<IPLBowlerStats> iplBowlerStatsList;


    public int loadIplBatsmanStat(String csvFilePath) throws IPLAnalyserException {
        try(Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
        CSVReader csvReader = new CSVReader(reader);){

            iplBatsmanStatsList = getCSVFileList(reader,IPLBatsmanStats.class);
            return  iplBatsmanStatsList.size();
        } catch (IOException| RuntimeException e ) {
            throw new IPLAnalyserException(e.getMessage(),IPLAnalyserException.ExceptionType.IPL_FILE_PROBLEM);
        }

    }

    public int loadIplBowlerStat(String csvFilePath) throws IPLAnalyserException {
        try(Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
            CSVReader csvReader = new CSVReader(reader);){

            iplBowlerStatsList = getCSVFileList(reader,IPLBowlerStats.class);
            return  iplBowlerStatsList.size();
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
        Collections.sort(iplBatsmanStatsList,com);
        Gson gson = new Gson();
        String json =gson.toJson(iplBatsmanStatsList);
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
        Collections.sort(iplBatsmanStatsList,com);
        Gson gson = new Gson();
        String json =gson.toJson(iplBatsmanStatsList);
        FileWriter fileWriter = new FileWriter(TOP_STRIKE_RATE_FILE);
        fileWriter.write(json);
        fileWriter.close();
    }

    public void sortingBasedOnMax6sAnd4s() throws IOException {
        Comparator com = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                IPLBatsmanStats b1 = (IPLBatsmanStats)o1;
                IPLBatsmanStats b2 = (IPLBatsmanStats)o2;

                if((b1.getSixes()+b1.getFours())>(b2.getFours()+b2.getSixes()))
                    return -3;
                else
                    return 3;
            }
        };
        Collections.sort(iplBatsmanStatsList,com);
        Gson gson = new Gson();
        String json =gson.toJson(iplBatsmanStatsList);
        FileWriter fileWriter = new FileWriter(TOP_4S_6S_FILE);
        fileWriter.write(json);
        fileWriter.close();
    }

    public void sortingBasedOnMaxStrikingRate6sAnd4s() {
        Comparator com = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                IPLBatsmanStats b1 = (IPLBatsmanStats)o1;
                IPLBatsmanStats b2 = (IPLBatsmanStats)o2;

                if(((b1.getSixes()+b1.getFours())>(b2.getFours()+b2.getSixes())) && (b1.getStrikeRate()>b2.getStrikeRate()))
                    return -3;
                else
                    return 3;
            }
        };
        Collections.sort(iplBatsmanStatsList,com);
    }


    public void sortingBasedOnTopAverageAlongWithStrikeRate() {
        Comparator<IPLBatsmanStats> iplBatsmanStatsComparator = Comparator.comparingDouble(IPLBatsmanStats::getAverage).thenComparing(IPLBatsmanStats::getStrikeRate);
        Collections.sort(iplBatsmanStatsList,iplBatsmanStatsComparator);
    }

    public void sortingBasedOnopRunScoredWithMaxAverage() {
        Comparator<IPLBatsmanStats> iplBatsmanStatsComparator = Comparator.comparingInt(IPLBatsmanStats::getRuns).thenComparing(IPLBatsmanStats::getAverage);
        Collections.sort(iplBatsmanStatsList,iplBatsmanStatsComparator);
    }

    public void sortingBasedOnBowlingAverage() {
        Comparator<IPLBowlerStats> iplBowlerStatsComparator = Comparator.comparingDouble(IPLBowlerStats::getAverage);
        Collections.sort(iplBowlerStatsList,iplBowlerStatsComparator);
        iplBowlerStatsList=iplBowlerStatsList.stream().filter(s->(s.getAverage()!=0)).collect(Collectors.toList());
    }

    public void sortingBasedOnBowlerStrikeRate() {
        Comparator<IPLBowlerStats> iplBowlerStatsComparator = Comparator.comparingDouble(IPLBowlerStats::getStrikeRate);
        Collections.sort(iplBowlerStatsList,iplBowlerStatsComparator);
        iplBowlerStatsList.stream().forEach(s->{
            System.out.println(s.getPlayer());
            System.out.println(s.getStrikeRate());
        });
    }

    public void sortingBasedOnEconomy() {
        Comparator<IPLBowlerStats> iplBowlerStatsComparator = Comparator.comparingDouble(IPLBowlerStats::getEconomy);
        Collections.sort(iplBowlerStatsList,iplBowlerStatsComparator);
        iplBowlerStatsList=iplBowlerStatsList.stream().filter(s->(s.getEconomy()!=0)).collect(Collectors.toList());

    }

    public void topStrikingRateWith5wAnd4w() {
        Comparator<IPLBowlerStats> iplBowlerStatsComparator = Comparator.comparingDouble(IPLBowlerStats::getStrikeRate).thenComparing(IPLBowlerStats::getFiveWicket).thenComparing(IPLBowlerStats::getFourWicket);
        Collections.sort(iplBowlerStatsList,iplBowlerStatsComparator);
        iplBowlerStatsList=iplBowlerStatsList.stream().filter(s->(s.getFiveWicket()!=0 || s.getFourWicket()!=0)).collect(Collectors.toList());

    }

    public void sortingBasedOnBowlingAvgWithStrikeRate() {
        Comparator<IPLBowlerStats> iplBowlerStatsComparator = Comparator.comparingDouble(IPLBowlerStats::getAverage).thenComparing(IPLBowlerStats::getStrikeRate);
        Collections.sort(iplBowlerStatsList,iplBowlerStatsComparator);
    }

    public void sortingBasedOnMostWicketsAndAverage() {
        Comparator<IPLBowlerStats> iplBowlerStatsComparator = Comparator.comparingInt(IPLBowlerStats::getWickets).thenComparing(IPLBowlerStats::getAverage);
        Collections.sort(iplBowlerStatsList,iplBowlerStatsComparator);

    }

    public List<String> sortingBasedOnBestBattingAndBowlingAverage() {
        Comparator<IPLBowlerStats> iplBowlerStatsComparator = Comparator.comparingDouble(IPLBowlerStats::getAverage);
        Comparator<IPLBatsmanStats> iplBatsmanStatsComparator = Comparator.comparingDouble(IPLBatsmanStats::getAverage);
        Collections.sort(iplBowlerStatsList,iplBowlerStatsComparator);
        Collections.sort(iplBatsmanStatsList,iplBatsmanStatsComparator);
        List<String> newBowlerList = new ArrayList();
        for(IPLBatsmanStats batsman: iplBatsmanStatsList){
            for(IPLBowlerStats bowler: iplBowlerStatsList){
                if(batsman.getPlayer().equals(bowler.getPlayer())){
                    
                    newBowlerList.add(bowler.getPlayer());
                }
            }
        }
        return newBowlerList;
    }
}
