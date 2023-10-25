package nl.sogyo.chess.chesscontroller;

import chess.domain.Playable;
import jakarta.servlet.http.HttpSession;
import nl.sogyo.chess.chesscontroller.models.BoardDTO;
import nl.sogyo.chess.chesscontroller.models.MoveDTO;
import nl.sogyo.chess.repository.WinnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/gamehistory")
public class GameHistoryEndPoint {

    private final WinnerRepository winnerRepository;

    @Autowired
    public GameHistoryEndPoint(WinnerRepository winnerRepository) {
        this.winnerRepository = winnerRepository;
    }


    @GetMapping(produces = "application/json")

    public List<Object[]> getGameHistory() {
        List<Object[]> winners = winnerRepository.countWinners();
        return winners;

    }


}