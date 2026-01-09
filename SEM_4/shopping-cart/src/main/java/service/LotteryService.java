package service;

import model.Applicant;

import java.security.SecureRandom;
import java.util.Collections;
import java.util.List;

public class LotteryService {
    public List<Applicant> shuffleAndDraw(List<Applicant> list, int limit) {
        Collections.shuffle(list, new SecureRandom());

        // Lấy 500 người đầu tiên (hoặc ít hơn nếu tổng số người < 500)
        return list.subList(0, Math.min(limit, list.size()));
    }
}
