package com.example.clothstore.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class IdGenerator {
    /*
    code sau đây giúp tạo id tự động cho product type
    có định dạng là PT + năm, tháng, ngày, giờ, phút và giây + số ngẫu nhiên từ 0-99
    ví dụ: PT2025051500290885 trong đó:
    PT là viết tắt của Product Type
    20250515002908 có nghĩa là 2025-05-15 00:29:08 (theo định dạng: YYYY-MM-DD hh:mm:ss)
    85 là số ngẫu nhiên
    */
    public static String generateProductTypeId() {
        LocalDateTime now = LocalDateTime.now();

        // Định dạng ngay từ đầu không có dấu phân cách
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd HHmmss");
        String formattedDateTime = now.format(formatter);

        // Tạo ra số random từ 0 đến 99
        Random random = new Random();
        int randomNumber = random.nextInt(100);

        // Kết hợp cả 3 lại để tạo ra id
        String productTypeId ="PT"+formattedDateTime.replace(" ", "")+randomNumber;

        // Trả về id hoàn chỉnh
        return productTypeId;
    }
}
