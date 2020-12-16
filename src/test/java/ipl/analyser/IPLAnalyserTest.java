package ipl.analyser;

import jar.builder.CSVBuilderException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

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
        Assert.assertEquals("MS Dhoni",IPLAnalyser.iplBatsmanStats.get(0).getPlayer());
    }
}
