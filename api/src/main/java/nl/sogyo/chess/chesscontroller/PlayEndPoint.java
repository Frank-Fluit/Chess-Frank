package nl.sogyo.chess.chesscontroller;

import chess.domain.Playable;
import chess.domain.ChessGame;
import jakarta.servlet.http.HttpSession;
import nl.sogyo.chess.chesscontroller.models.*;
import nl.sogyo.chess.chesscontroller.models.PlayerInputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/playgame")
public class PlayEndPoint {


    //@GetMapping(produces = "application/json")
    @PostMapping(produces = "application/json")
    public BoardDTO hello(@RequestBody MoveDTO moveToPlay, HttpSession session ) {

        Playable chess = (Playable) session.getAttribute("chessboardSession");

        System.out.println(moveToPlay);

        int[] originSquare = moveToPlay.getOriginSquare();
        int[] targetSquare = moveToPlay.getTargetSquare();
        System.out.println(Arrays.toString(originSquare));
        System.out.println(Arrays.toString(targetSquare));

        chess.playPiece(originSquare,targetSquare);


        return new BoardDTO(chess);

    }


}