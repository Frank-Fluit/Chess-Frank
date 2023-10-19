package nl.sogyo.chess.chesscontroller;

import chess.domain.Playable;
import chess.domain.ChessGame;
import jakarta.servlet.http.HttpSession;
import nl.sogyo.chess.chesscontroller.models.BoardDTO;
import nl.sogyo.chess.chesscontroller.models.PlayerInputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping("/startgame")
public class ChessController {


    //@GetMapping(produces = "application/json")
    @PostMapping(produces = "application/json")
    public BoardDTO hello(@RequestBody PlayerInputDTO players, HttpSession session){

        System.out.println(players);

        String player1Name = players.getPlayer1Name();
        String player2Name = players.getPlayer2Name();
        System.out.println(player1Name);
        System.out.println(player2Name);

        //hier gaat iets fout met naam zetten
        Playable chess = new ChessGame(player1Name,player2Name);
        session.setAttribute("chessboardSession", chess);

        var output = new BoardDTO(chess);


        return output;

    }


}



