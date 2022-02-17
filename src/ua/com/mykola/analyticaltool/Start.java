package ua.com.mykola.analyticaltool;

import java.util.List;

public class Start {
    public static void main(String[] args) {

        InputProcessing inputProcessing = new InputProcessing();

        // data as in the example
        List<String> input = List.of("7",
                "C 1.1 8.15.1 P 15.10.2012 83",
                "C 1 10.1 P 01.12.2012 65",
                "C 1.1 5.5.1 P 01.11.2012 117",
                "D 1.1 8 P 01.01.2012-01.12.2012",
                "C 3 10.2 N 02.10.2012 100",
                "D 1 * P 08.10.2012-20.11.2012",
                "D 3 10 P 01.12.2012");
        List<String> output = inputProcessing.getOutputOfAllAverageWaitTimes(input);

        for (String line : output) {
            System.out.println(line);
        }

    }
}
