package entities;

import java.io.Serializable;

public class Result implements Serializable {
    String nickname;
    int score;
    public Result(String nickname, int score){
        this.nickname = nickname;
        this.score = score;
    }

    public Result() {
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
