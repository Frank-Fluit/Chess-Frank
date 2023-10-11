package nl.sogyo.chess.chesscontroller;

import chess.domain.Playable;
import chess.domain.ChessGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/startgame")
public class ChessController {


    @GetMapping
    public String hello(){

        Playable chess = new ChessGame();

        Playable.PieceEnum PieceOnSquare = chess.getPieceForSquare(1,1);

        return PieceOnSquare.toString();
    }


}



