package ipl.analyser;

public class IPLAnalyserException extends Exception {

        enum ExceptionType{
            IPL_FILE_PROBLEM, IPL_HEADER_DELIMETER_PROBLEM, FILE_OR_HEADER_PROBLEM, NO_SUCH_DATA;
        }

        ExceptionType type;

        public IPLAnalyserException(String message, ExceptionType type) {
            super(message);
            this.type = type;
        }
}


