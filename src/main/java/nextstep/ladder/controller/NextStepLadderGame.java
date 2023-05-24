package nextstep.ladder.controller;

import nextstep.ladder.domain.*;
import nextstep.ladder.domain.nextstep.NextStepLadder;
import nextstep.ladder.domain.nextstep.NextStepLadderCreator;
import nextstep.ladder.domain.nextstep.NextStepLineCreator;
import nextstep.ladder.domain.strategy.BridgeStrategy;
import nextstep.ladder.utils.Util;
import nextstep.ladder.view.NextStepOutputView;

import java.util.List;
import java.util.Map;

import static nextstep.ladder.view.InputView.*;
import static nextstep.ladder.view.NextStepOutputView.printResult;

public class NextStepLadderGame {
    public static final String DELIMITER = ",";
    private final BridgeStrategy strategy;

    public NextStepLadderGame(BridgeStrategy strategy) {
        this.strategy = strategy;
    }

    public void run() {
        Participants participants = new Participants(getParticipantNames());
        LadderResult result = LadderResult.of(participants, getResultList());
        Height height = new Height(getLadderHeight());

        NextStepLineCreator lineCreator = new NextStepLineCreator();
        NextStepLadderCreator ladderCreator = new NextStepLadderCreator(lineCreator);
        NextStepLadder ladder = (NextStepLadder) ladderCreator.create(participants, height, strategy);


        NextStepOutputView.printLadder(participants, result, ladder);

        GameResult gameResult = ladder.run(participants, result);

        loopResult(participants, gameResult.getGameResult());
    }

    private void loopResult(Participants participants, Map<String, String> gameResult) {
        while (true){
            String input = getNameOrCodeForResult();
            if (input.equals(Code.EXIT.getCode())) {
                break;
            }
            participants.validateResultInput(input);
            printResult(input, gameResult);
        }
    }

    private List<String> getResultList() {
        return Util.separateToList(getResults(), DELIMITER);
    }

    private List<String> getParticipantNames() {
        return Util.separateToList(getParticipants(), DELIMITER);
    }
}