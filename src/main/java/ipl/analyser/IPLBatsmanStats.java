package ipl.analyser;

import com.opencsv.bean.CsvBindByName;

public class IPLBatsmanStats {
    @CsvBindByName(column = "POS")
    private int position;

    @CsvBindByName (column = "Player")
    private String player;

    @CsvBindByName (column = "Mat")
    private int matchesPlayed;

    @CsvBindByName (column = "Inns")
    private int innings;

    @CsvBindByName (column = "NO")
    private int notOut;

    @CsvBindByName (column = "Runs")
    private int runs;

    @CsvBindByName (column = "HS")
    private String highScore;

    @CsvBindByName (column = "Avg")
    private double average;

    @CsvBindByName (column = "BF")
    private int ballsFaced;

    @CsvBindByName (column = "SR")
    private double strikeRate;

    @CsvBindByName (column = "100")
    private int centuries;

    @CsvBindByName (column = "50")
    private int fifties;

    @CsvBindByName (column = "4s")
    private int fours;

    @CsvBindByName (column = "6s")
    private int sixes;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public int getInnings() {
        return innings;
    }

    public void setInnings(int innings) {
        this.innings = innings;
    }

    public int getNotOut() {
        return notOut;
    }

    public void setNotOut(int notOut) {
        this.notOut = notOut;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public String getHighScore() {
        return highScore;
    }

    public void setHighScore(String highScore) {
        this.highScore = highScore;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public int getBallsFaced() {
        return ballsFaced;
    }

    public void setBallsFaced(int ballsFaced) {
        this.ballsFaced = ballsFaced;
    }

    public double getStrikeRate() {
        return strikeRate;
    }

    public void setStrikeRate(double strikeRate) {
        this.strikeRate = strikeRate;
    }

    public int getCenturies() {
        return centuries;
    }

    public void setCenturies(int centuries) {
        this.centuries = centuries;
    }

    public int getFifties() {
        return fifties;
    }

    public void setFifties(int fifties) {
        this.fifties = fifties;
    }

    public int getFours() {
        return fours;
    }

    public void setFours(int fours) {
        this.fours = fours;
    }

    public int getSixes() {
        return sixes;
    }

    public void setSixes(int sixes) {
        this.sixes = sixes;
    }

    @Override
    public String toString() {
        return "IPLBatsmanStats{" +
                "position=" + position +
                ", player='" + player + '\'' +
                ", matchesPlayed=" + matchesPlayed +
                ", innings=" + innings +
                ", notOut=" + notOut +
                ", runs=" + runs +
                ", highScore='" + highScore + '\'' +
                ", average=" + average +
                ", ballsFaced=" + ballsFaced +
                ", strikeRate=" + strikeRate +
                ", centuries=" + centuries +
                ", fifties=" + fifties +
                ", fours=" + fours +
                ", sixes=" + sixes +
                '}';
    }
}
