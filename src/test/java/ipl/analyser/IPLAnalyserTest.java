package ipl.analyser;

import jar.builder.CSVBuilderException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class IPLAnalyserTest {
    public static final String BATSMAN_PATH = "C:\\Users\\saiprasad\\IdeaProjects\\IPLAnaluser\\IPLAnaluser\\src\\test\\resources\\IPL2019FactsheetMostRuns.csv";
    public static final String BOWLER_PATH = "C:\\Users\\saiprasad\\IdeaProjects\\IPLAnaluser\\IPLAnaluser\\src\\test\\resources\\IPL2019FactsheetMostWkts.csv";

    @Test
    public void loadingGivenCSVAndCheckingNoOfEntries() throws IPLAnalyserException, IOException, CSVBuilderException {
        IPLAnalyser iplAnalyser = new IPLAnalyser();
        int noOfEntriesBatsman = iplAnalyser.loadIplBatsmanStat(BATSMAN_PATH);
        Assert.assertEquals(101,noOfEntriesBatsman);
        int noOfEntriesBowler = iplAnalyser.loadIplBowlerStat(BOWLER_PATH);
        Assert.assertEquals(99,noOfEntriesBowler);

    }

    @Test
    public void sortingBasedOnBattingAvarage() throws IPLAnalyserException, IOException {
        IPLAnalyser iplAnalyser = new IPLAnalyser();
        iplAnalyser.loadIplBatsmanStat(BATSMAN_PATH);
        iplAnalyser.sortingBasedOnBattingAverage();
        Assert.assertEquals("MS Dhoni",IPLAnalyser.iplBatsmanStatsList.get(0).getPlayer());
    }

    @Test
    public void sortingBasedOnStrikingRates() throws IPLAnalyserException, IOException {
        IPLAnalyser iplAnalyser = new IPLAnalyser();
        iplAnalyser.loadIplBatsmanStat(BATSMAN_PATH);
        iplAnalyser.sortingBasedOnStrikeRate();
        Assert.assertEquals("Ishant Sharma",IPLAnalyser.iplBatsmanStatsList.get(0).getPlayer());
    }

    @Test
    public void sortingBasedOnMaximum6sAnd4s() throws IPLAnalyserException, IOException {
        IPLAnalyser iplAnalyser = new IPLAnalyser();
        iplAnalyser.loadIplBatsmanStat(BATSMAN_PATH);
        iplAnalyser.sortingBasedOnMax6sAnd4s();
        Assert.assertEquals("Andre Russell",IPLAnalyser.iplBatsmanStatsList.get(0).getPlayer());
    }

    @Test
    public void sortingBasedOnMaximumStrikingRate6sAnd4s() throws IPLAnalyserException, IOException {
        IPLAnalyser iplAnalyser = new IPLAnalyser();
        iplAnalyser.loadIplBatsmanStat(BATSMAN_PATH);
        iplAnalyser.sortingBasedOnMaxStrikingRate6sAnd4s();
        Assert.assertEquals("Andre Russell",IPLAnalyser.iplBatsmanStatsList.get(0).getPlayer());
    }

    @Test
    public void sortingBasedOnTopAverageAlongWithStrikeRate() throws IPLAnalyserException, IOException {
        IPLAnalyser iplAnalyser = new IPLAnalyser();
        iplAnalyser.loadIplBatsmanStat(BATSMAN_PATH);
        iplAnalyser.sortingBasedOnTopAverageAlongWithStrikeRate();
        Assert.assertEquals("MS Dhoni",IPLAnalyser.iplBatsmanStatsList.get(IPLAnalyser.iplBatsmanStatsList.size()-1).getPlayer());
    }

    @Test
    public void sortingBasedOnTopRunScoredWithMaxAverage() throws IPLAnalyserException, IOException {
        IPLAnalyser iplAnalyser = new IPLAnalyser();
        iplAnalyser.loadIplBatsmanStat(BATSMAN_PATH);
        iplAnalyser.sortingBasedOnopRunScoredWithMaxAverage();
        Assert.assertEquals("David Warner ",IPLAnalyser.iplBatsmanStatsList.get(IPLAnalyser.iplBatsmanStatsList.size()-1).getPlayer());
    }

    @Test
    public void sortingBasedOnBowlingAvarage() throws IPLAnalyserException, IOException {
        IPLAnalyser iplAnalyser = new IPLAnalyser();
        iplAnalyser.loadIplBowlerStat(BOWLER_PATH);
        iplAnalyser.sortingBasedOnBowlingAverage();
        Assert.assertEquals("Anukul Roy",IPLAnalyser.iplBowlerStatsList.get(0).getPlayer());
    }

    @Test
    public void sortingBasedOnStrikeRateOfBowlers() throws IPLAnalyserException, IOException {
        IPLAnalyser iplAnalyser = new IPLAnalyser();
        iplAnalyser.loadIplBowlerStat(BOWLER_PATH);
        iplAnalyser.sortingBasedOnBowlerStrikeRate();
        Assert.assertEquals("Krishnappa Gowtham",IPLAnalyser.iplBowlerStatsList.get(IPLAnalyser.iplBowlerStatsList.size()-1).getPlayer());
    }

    @Test
    public void sortingBasedOnEconomy() throws IPLAnalyserException, IOException {
        IPLAnalyser iplAnalyser = new IPLAnalyser();
        iplAnalyser.loadIplBowlerStat(BOWLER_PATH);
        iplAnalyser.sortingBasedOnEconomy();

        Assert.assertEquals("Shivam Dube",IPLAnalyser.iplBowlerStatsList.get(0).getPlayer());
    }

    @Test
    public void bowlerWithTopStrikingRateWith5wAnd4w() throws IPLAnalyserException, IOException {
        IPLAnalyser iplAnalyser = new IPLAnalyser();
        iplAnalyser.loadIplBowlerStat(BOWLER_PATH);
        iplAnalyser.topStrikingRateWith5wAnd4w();

        Assert.assertEquals("Alzarri Joseph",IPLAnalyser.iplBowlerStatsList.get(0).getPlayer());
    }

    @Test
    public void sortingBasedOnBowlingAvgWithStrikeRateOfBowlers() throws IPLAnalyserException, IOException {
        IPLAnalyser iplAnalyser = new IPLAnalyser();
        iplAnalyser.loadIplBowlerStat(BOWLER_PATH);
        iplAnalyser.sortingBasedOnBowlingAvgWithStrikeRate();
        Assert.assertEquals("Krishnappa Gowtham",IPLAnalyser.iplBowlerStatsList.get(IPLAnalyser.iplBowlerStatsList.size()-1).getPlayer());
    }

    @Test
    public void sortingBasedOnMostWicketsAndAverage() throws IPLAnalyserException, IOException {
        IPLAnalyser iplAnalyser = new IPLAnalyser();
        iplAnalyser.loadIplBowlerStat(BOWLER_PATH);
        iplAnalyser.sortingBasedOnMostWicketsAndAverage();
        Assert.assertEquals("Imran Tahir",IPLAnalyser.iplBowlerStatsList.get(IPLAnalyser.iplBowlerStatsList.size()-1).getPlayer());
    }

    @Test
    public void sortingBasedOnBestBattingAndBowlingAverage() throws IPLAnalyserException, IOException {
        IPLAnalyser iplAnalyser = new IPLAnalyser();
        iplAnalyser.loadIplBatsmanStat(BATSMAN_PATH);
        iplAnalyser.loadIplBowlerStat(BOWLER_PATH);
        List<String> namesList = iplAnalyser.sortingBasedOnBestBattingAndBowlingAverage();
        Assert.assertEquals("Andre Russell",namesList.get(namesList.size()-1));
    }

    @Test
    public void sortingBasedOnAllrounder() throws IPLAnalyserException, IOException {
        IPLAnalyser iplAnalyser = new IPLAnalyser();
        iplAnalyser.loadIplBatsmanStat(BATSMAN_PATH);
        iplAnalyser.loadIplBowlerStat(BOWLER_PATH);
        List<String> namesList = iplAnalyser.sortingBasedOnBestBattingAndBowlingAverage();
        Assert.assertEquals("Andre Russell",namesList.get(namesList.size()-1));
    }

    @Test
    public void sortingBasedOnMaxHundredsWithBestAvg() throws IPLAnalyserException, IOException {
        IPLAnalyser iplAnalyser = new IPLAnalyser();
        iplAnalyser.loadIplBatsmanStat(BATSMAN_PATH);
        iplAnalyser.sortingBasedOnMaxHundredsWithBestAvg();
        Assert.assertEquals("David Warner ",IPLAnalyser.iplBatsmanStatsList.get(IPLAnalyser.iplBatsmanStatsList.size()-1).getPlayer());
    }

    @Test
    public void sortingBasedOnBestBattingAvgButZeroCenturiesOrFifties() throws IPLAnalyserException, IOException {
        IPLAnalyser iplAnalyser = new IPLAnalyser();
        iplAnalyser.loadIplBatsmanStat(BATSMAN_PATH);
        iplAnalyser.sortingBasedOnBestBattingAvgButZeroCenturiesOrFifties();
        Assert.assertEquals("Marcus Stoinis",IPLAnalyser.iplBatsmanStatsList.get(IPLAnalyser.iplBatsmanStatsList.size()-1).getPlayer());
    }
}
