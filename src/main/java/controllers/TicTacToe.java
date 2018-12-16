package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

import static java.lang.String.*;

@Controller
public class TicTacToe {

    static int number = 3;

    @RequestMapping("/startGame")
    public String start(HttpServletRequest request) {
        String[][] field = new String[number][number];
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                field[i][j] = String.valueOf(MessageGame.Y);
            }
        }
        request.setAttribute("fieldParam", field);
        return "game";
    }

    @RequestMapping("/game")
    public String game(HttpServletRequest request) {
        String[][] fields;
        try {
            fields = createGameField(request);
            String[][] fieldComp;
            if (checkGame(fields).equals(String.valueOf(MessageGame.nobody)) && canMove(fields)) {
                fieldComp = compMove(fields);
            } else {
                fieldComp = fields;
            }
            String label = "";
            if (checkGame(fieldComp).equals(String.valueOf(MessageGame.X))) {
                label = String.valueOf(MessageGame.YOU_WIN);
            } else if (checkGame(fieldComp).equals("0")) {
                label = String.valueOf(MessageGame.YOU_LOSE);
            } else if (checkGame(fieldComp).equals(String.valueOf(MessageGame.nobody)) && !canMove(fieldComp)) {
                label = String.valueOf(MessageGame.STANDOFF);
            }
            if (!label.equals("")) {
                request.setAttribute("label", label);
            }
            request.setAttribute("fieldParam", fieldComp);
            return "game";
        } catch (NullPointerException npe) {
            return "redirect:/";
        }
    }


    public static String[][] createGameField(HttpServletRequest req) throws NullPointerException {

        Map<String, String[]> allMap = req.getParameterMap();
        String[][] field = new String[number][number];
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                String a = valueOf(i);
                String b = valueOf(j);
                String c = a + b;
                field[i][j] = allMap.get(c)[0];
            }
        }
        return field;


    }


    public static boolean canMove(String[][] move) {

        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                if (move[i][j].equals(String.valueOf(MessageGame.Y))) {
                    return true;
                }
            }

        }
        return false;
    }

    public static String checkGame(String[][] chesk) {
        String winner = String.valueOf(MessageGame.nobody);
        // Проверка по горизонтали
        for (int i = 0; i < number; i++) {
            if (chesk[i][0].equals(chesk[i][1]) && chesk[i][1].equals(chesk[i][2])
                    && !chesk[i][0].equals(String.valueOf(MessageGame.Y))) {
                winner = chesk[i][0];
                break;
            }
        }

        // Проверка по вертикали если победитель пока не найден
        if (winner.equals(String.valueOf(MessageGame.nobody))) {
            for (int i = 0; i < number; i++) {
                if (chesk[0][i].equals(chesk[1][i]) && chesk[1][i].equals(chesk[2][i])
                        && !chesk[0][i].equals(String.valueOf(MessageGame.Y))) {
                    winner = chesk[0][i];
                    break;
                }
            }
        }

        // Проверка главной диагонали если победитель пока не найден
        if (winner.equals(String.valueOf(MessageGame.nobody))) {
            if (chesk[0][0].equals(chesk[1][1]) && chesk[1][1].equals(chesk[2][2])
                    && !chesk[0][0].equals(String.valueOf(MessageGame.Y))) {
                winner = chesk[0][0];
            }
        }

        // Проверка побочной диагонали если победитель пока не найден
        if (winner.equals(String.valueOf(MessageGame.nobody))) {
            if (chesk[0][2].equals(chesk[1][1]) && chesk[1][1].equals(chesk[2][0])
                    && !chesk[0][2].equals(String.valueOf(MessageGame.Y))) {
                winner = chesk[0][2];
            }
        }
        // Возвращаем победителя или nobody, если такового пока нет
        return winner;
    }

    public static String[][] compMove(String[][] move) {
        int x, y;
        do {
            x = (int) (Math.random() * number);
            y = (int) (Math.random() * number);
        }
        while (move[x][y].equals("0") || move[x][y].equals(String.valueOf(MessageGame.X)));
        move[x][y] = "0";
        return move;
    }
}
