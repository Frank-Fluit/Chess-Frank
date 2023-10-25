package nl.sogyo.chess.chesscontroller;

import chess.domain.Playable;
import chess.domain.ChessGame;
import jakarta.servlet.http.HttpSession;
import nl.sogyo.chess.entity.Winner;
import nl.sogyo.chess.chesscontroller.models.*;
import nl.sogyo.chess.chesscontroller.models.PlayerInputDTO;
import nl.sogyo.chess.repository.WinnerRepository;
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
    private final WinnerRepository winnerRepository;

    @Autowired
    public PlayEndPoint(WinnerRepository winnerRepository) {
        this.winnerRepository = winnerRepository;
    }


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

        if(chess.isEndOfGame()){

            if(chess.getWinner().equals(Playable.Winner.PLAYER_1)){
                System.out.println("Winner is white:" + chess.getNameOfPlayerOne());
                Winner winner = new Winner(chess.getNameOfPlayerOne());
                winnerRepository.save(winner);
            }
            if(chess.getWinner().equals(Playable.Winner.PLAYER_2)){
                System.out.println("Winner is black:" + chess.getNameOfPlayerTwo());
                Winner winner = new Winner(chess.getNameOfPlayerTwo());
                winnerRepository.save(winner);
            }
        }

        return new BoardDTO(chess);
    }


}