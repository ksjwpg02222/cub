package com.cub.demo.vo;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoinDeskVo {

    private Time time;
    private String disclaimer;
    private String chartName;
    private Bpi bpi;


    @Getter
    @Setter
    public static class Time {
        private String updated;
        private String updatedISO;
        private String updateduk;
    }

    @Getter
    @Setter
    public static class Bpi {
        @JsonProperty("USD")
        private Info usd;
        @JsonProperty("GBP")
        private Info gbp;
        @JsonProperty("EUR")
        private Info eur;

    }

    @Getter
    @Setter
    public static class Info {
        private String code;
        private String symbol;
        private String rate;
        private String description;
        @JsonProperty("rate_float")
        private Double rateFloat;
        private String name;
    }


    public String convertToString() {
        OffsetDateTime odt = OffsetDateTime.parse(this.getTime().getUpdatedISO());
        Instant instant = odt.toInstant();
        LocalDateTime localDateTime = instant.atZone(ZoneId.of("Asia/Taipei")).toLocalDateTime();
        String updateTime = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(localDateTime);

        Info usd = this.getBpi().getUsd();
        Info gbp = this.getBpi().getGbp();
        Info eur = this.getBpi().getEur();

        return String.format("更新時間：%S \n", updateTime) +
                String.format("幣別：%S 中文名稱：%S 匯率：%S \n", usd.getCode(), usd.getName(), usd.getRate()) +
                String.format("幣別：%S 中文名稱：%S 匯率：%S \n", gbp.getCode(), gbp.getName(), gbp.getRate()) +
                String.format("幣別：%S 中文名稱：%S 匯率：%S \n", eur.getCode(), eur.getName(), eur.getRate());

    }
}
