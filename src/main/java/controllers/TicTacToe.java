package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static java.lang.String.*;

@Controller
public class TicTacToe {
    @RequestMapping("/game")
    public String Game(HttpServletRequest request) {
        String[][] fields = CreateGameField(request);
        String[][] fieldComp;
        if (CheckGame(fields).equals("nobody") && CanMove(fields)) {
            fieldComp = CompMove(fields);
        } else {
            fieldComp = fields;
        }
        if (CheckGame(fieldComp).equals("X")) {
            request.setAttribute("label", "YOU WIN!");
        }
        if (CheckGame(fieldComp).equals("0")) {
            request.setAttribute("label", "YOU LOSE!");
        }
        if (CheckGame(fieldComp).equals("nobody") && !CanMove(fieldComp)) {
            request.setAttribute("label", "STANDOFF");
        }

//        Map mp = new TreeMap();
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                String a = valueOf(i);
//                String b = valueOf(j);
//                String c = a + b;
//                mp.put(c, fieldComp[i][j]);
//            }
//        }
//        request.setAttribute("label", "STANDOFF");
        request.setAttribute("fieldParam", fieldComp);

        return "Game";
    }


    public static String[][] CreateGameField(HttpServletRequest req) {
        Map<String, String[]> allMap = req.getParameterMap();
        String[][] field = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String a = valueOf(i);
                String b = valueOf(j);
                String c = a + b;
                field[i][j] = allMap.get(c)[0];
            }
//        Enumeration<String> parameterNames = req.getParameter();
//        String[][] field = new String[3][3];
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                String str = parameterNames.nextElement();
//                field[i][j]=str;
//            }
//        }

        }
        return field;


    }


    public static boolean CanMove(String[][] move) {
        boolean p = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (move[i][j].equals("Y")) {
                    p = true;
                    break;
                }
            }

        }
        return p;
    }

    public static String CheckGame(String[][] chesk) {
        String winner = "nobody";
        // Проверка по горизонтали
        for (int i = 0; i < 3; i++) {
            if (chesk[i][0].equals(chesk[i][1]) && chesk[i][1].equals(chesk[i][2])
                    && !chesk[i][0].equals("Y")) {
                winner = chesk[i][0];
                break;
            }
        }

        // Проверка по вертикали если победитель пока не найден
        if (winner.equals("nobody")) {
            for (int i = 0; i < 3; i++) {
                if (chesk[0][i].equals(chesk[1][i]) && chesk[1][i].equals(chesk[2][i])
                        && !chesk[0][i].equals("Y")) {
                    winner = chesk[0][i];
                    break;
                }
            }
        }

        // Проверка главной диагонали если победитель пока не найден
        if (winner.equals("nobody")) {
            if (chesk[0][0].equals(chesk[1][1]) && chesk[1][1].equals(chesk[2][2])
                    && !chesk[0][0].equals("Y")) {
                winner = chesk[0][0];
            }
        }

        // Проверка побочной диагонали если победитель пока не найден
        if (winner.equals("nobody")) {
            if (chesk[0][2].equals(chesk[1][1]) && chesk[1][1].equals(chesk[2][0])
                    && !chesk[0][2].equals("Y")) {
                winner = chesk[0][2];
            }
        }
        // Возвращаем победителя или nobody, если такового пока нет
        return winner;
    }

    public static String[][] CompMove(String[][] move) {
        int x = (int) (Math.random() * 3), y = (int) (Math.random() * 3);
        while (move[x][y].equals("0") || move[x][y].equals("X")) {
            x = (int) (Math.random() * 3);
            y = (int) (Math.random() * 3);

        }
        move[x][y] = "0";
        return move;
    }
}
