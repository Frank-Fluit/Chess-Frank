package nl.sogyo.chess.chesscontroller;

import chess.domain.Playable;
import jakarta.servlet.http.HttpSession;
import nl.sogyo.chess.chesscontroller.models.BoardDTO;
import nl.sogyo.chess.chesscontroller.models.MoveDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/gamehistory")
public class GameHistoryEndPoint {


    @GetMapping(produces = "application/json")

    public String getGameHistory() {


        //TODO
        //Get winner from database here


        return "GameHistory";

    }


}