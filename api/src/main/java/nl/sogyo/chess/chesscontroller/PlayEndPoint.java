package nl.sogyo.chess.chesscontroller;

import chess.domain.Playable;
import chess.domain.ChessGame;
import nl.sogyo.chess.chesscontroller.models.BoardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController
//@RequestMapping("/playgame")
//public class PlayEndPoint {
//
//    //input a targetsquare, originpiece
//    //return board, gamestate?
//
//    @GetMapping(produces = "application/json")
//    public BoardDTO hello() {
//
//        //Playable chess = new ChessGame(player1Name,player2Name);
//        //var output = new BoardDTO(chess);
//        return "nothing";
//    }
//}

