public class TennisGame {

    public static String getScore(String player1Name, String player2Name, int player1Score, int player2Score) {
        String score = "";
        int tempScore=0;
        if (player1Score==player2Score)
        {
            switch (player1Score)
            {
                case 0:
                    score = "Love";
                    break;
                case 1:
                    score = "Fifteen";
                    break;
                case 2:
                    score = "Thirty";
                    break;
                case 3:
                    score = "Forty";
                    break;
                default:
                    score = "Deuce";
                    break;

            }
        }
        else if (player1Score>=4 || player2Score>=4)
        {
            int minusResult = player1Score-player2Score;
            final boolean isAdvantagePlayer1 = minusResult == 1;
            if (isAdvantagePlayer1) score ="Advantage player1";
            else {
                final boolean isAdvantagePlayer2 = minusResult == -1;
                if (isAdvantagePlayer2) score = "Advantage player2";
                else {
                    score = getPlayerWin(minusResult);
                }
            }
        }
        else
        {
            for (int i=1; i<3; i++)
            {
                if (i == 1) tempScore = player1Score;
                else { score+="-"; tempScore = player2Score;}
                switch(tempScore)
                {
                    case 0:
                        score+="Love";
                        break;
                    case 1:
                        score+="Fifteen";
                        break;
                    case 2:
                        score+="Thirty";
                        break;
                    case 3:
                        score+="Forty";
                        break;
                }
            }
        }
        return score;
    }

    private static String getPlayerWin(int minusResult) {
        String score;
        final boolean isWinPlayer1 = minusResult >= 2;
        if (isWinPlayer1) score = "Win for player1";
        else score = "Win for player2";
        return score;
    }
}
