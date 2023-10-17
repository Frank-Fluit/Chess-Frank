package nl.sogyo.chess.chesscontroller;

import chess.domain.Playable;
import chess.domain.ChessGame;
import nl.sogyo.chess.chesscontroller.models.BoardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/startgame")
public class ChessController {


    @GetMapping(produces = "application/json")
    public BoardDTO hello(){


        Playable chess = new ChessGame();

        var output = new BoardDTO(chess);


        return output;

    }


}



