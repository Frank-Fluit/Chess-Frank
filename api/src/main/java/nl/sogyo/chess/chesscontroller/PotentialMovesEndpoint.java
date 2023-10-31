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
@RequestMapping("/potential")
public class PotentialMovesEndpoint {


    @PostMapping(produces = "application/json")
    public BoardDTO hello(@RequestBody SingleSquareDTO squareToCheck, HttpSession session ) {

        Playable chess = (Playable) session.getAttribute("chessboardSession");

        System.out.println(squareToCheck);

        int row = squareToCheck.getOriginSquare()[0];
        int col = squareToCheck.getOriginSquare()[1];
        System.out.println(row);
        System.out.println(col);

        chess.updateSquares(row,col);

        return new BoardDTO(chess);
    }


}